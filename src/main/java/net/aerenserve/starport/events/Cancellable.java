package net.aerenserve.starport.events;

public interface Cancellable {
	
	public void setCancelled(boolean cancel);
	public boolean isCancelled();

}
