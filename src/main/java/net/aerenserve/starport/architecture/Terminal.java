package net.aerenserve.starport.architecture;

import java.util.ArrayList;
import java.util.List;

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
	
	protected List<Gate> gates;
	
	public Terminal(String name) {
		this.name = name;
		this.gates = new ArrayList<Gate>();
	}
	
	public String getIdentifier() {
		return this.name;
	}
	
	/**
	 * Necessary to 'install' gates to your terminal.
	 * @param gate
	 */
	public void addGate(Gate gate) {
		this.gates.add(gate);
	}

}
