package net.aerenserve.starport.architecture;

public class Gate {

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
	
	public String getIdentifier() {
		return this.terminal.getIdentifier() + this.id;
	}
}
