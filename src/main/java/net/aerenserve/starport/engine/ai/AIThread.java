package net.aerenserve.starport.engine.ai;

public abstract class AIThread implements Runnable {
	
	protected Thing thing;
	
	public AIThread(Thing thing) {
		this.thing = thing;
	}
	
	public Thing getThing() {
		return this.thing;
	}
	
	public abstract void reproduce();
		
}
