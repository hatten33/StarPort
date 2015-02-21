package net.aerenserve.starport;

public abstract class Terminal {
	
	protected final String name;
	
	public Terminal(String name) {
		this.name = name;
	}
	
	public String getIdentifier() {
		return this.name;
	}

}
