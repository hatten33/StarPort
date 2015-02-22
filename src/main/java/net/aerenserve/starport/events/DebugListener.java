package net.aerenserve.starport.events;

import net.aerenserve.starport.engine.StarPortSimulator;

public class DebugListener implements Listener {

	public DebugListener() {
		StarPortSimulator.getInstance().getEventCoordinator().addListener(this);
	}
	
	@EventHandler
	public void onEvent(CancellableEvent event) {
		System.out.println("Recieved Event: " + event.getClass().getName());
	}
}
