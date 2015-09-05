package net.aerenserve.starport.engine.architecture;

import net.aerenserve.starport.engine.architecture.Dock.DockSize;

public class Gate {
	
	public enum State { DOCKING, ARRIVAL, DEPARTURE, LAUNCHING, OPEN, CLOSED, REPAIR }

	protected final Terminal terminal;
	protected final int id;
	
	protected Dock dock;
	
	public Gate(int id, Terminal terminal) {
		this.id = id;
		this.terminal = terminal;
	}
	
	public void setDock(Dock dock) {
		this.dock = dock;
	}
	
	public DockSize getDockSize() {
		return this.dock.size;
	}
	 
	public String getIdentifier() {
		if(this.id < 0) return this.terminal.getIdentifier() + "-NULL";
		return this.terminal.getIdentifier() + this.id;
	}
}
