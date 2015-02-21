package net.aerenserve.starport;

public abstract class Gate {

	protected final Terminal terminal;
	protected final int id;
	
	public Gate(int id, Terminal terminal) {
		this.id = id;
		this.terminal = terminal;
	}
	
	public String getIdentifier() {
		return this.terminal.getIdentifier() + this.id;
	}
}
