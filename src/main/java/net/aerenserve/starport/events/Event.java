package net.aerenserve.starport.events;

public abstract class Event {

	private boolean cancel = false;
	
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
	
	public boolean isCancelled() {
		return cancel;
	}
}
