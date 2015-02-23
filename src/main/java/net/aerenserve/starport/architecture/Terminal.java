package net.aerenserve.starport.architecture;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import net.aerenserve.starport.architecture.Gate.State;

public class Terminal {

	public enum Size {
		TINY(2),
		SMALL(4),
		MEDIUM(10),
		EXECUTIVE(12),
		LARGE(18),
		GIGANTIC(30);
		
		public final int gates;
		
		private Size(int gates) {
			this.gates = gates;
		}
	}
	
	protected Size size;
	protected final String name;
	
	protected Map<Gate, Gate.State> gates;
	
	public Terminal(String name) {
		this.name = name;
		this.gates = new ConcurrentHashMap<Gate, Gate.State>();
	}
	
	public String getIdentifier() {
		return this.name;
	}
	
	/**
	 * Necessary to 'install' gates to your terminal.
	 * @param gate
	 */
	public void addGate(Gate gate) {
		this.gates.put(gate, Gate.State.OPEN);
	}
	
	public void setState(Gate gate, Gate.State state) {
		this.gates.put(gate, state);
	}
	
	public Map<Gate, Gate.State> getGates() {
		return this.gates;
	}
	
	public Gate getGate(Gate.State gateState) {
	    Iterator<Entry<Gate, State>> it = this.gates.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Gate, State> pair = (Map.Entry<Gate, State>) it.next();
	        if(pair.getValue().equals(Gate.State.OPEN)) return pair.getKey();
	        it.remove();
	    }
	    return null;
	}

	public boolean hasOpenGate() {
		return getGate(Gate.State.OPEN) != null;
	}
}
