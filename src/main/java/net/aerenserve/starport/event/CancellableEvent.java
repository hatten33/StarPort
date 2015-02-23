package net.aerenserve.starport.event;

public abstract class CancellableEvent implements Cancellable, Event {

	private boolean cancel = false;
	
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
	
	public boolean isCancelled() {
		return cancel;
	}
}
