package net.aerenserve.starport.event.listener;

import java.util.logging.Level;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.event.Event;
import net.aerenserve.starport.event.MessageEvent;

public class DebugListener implements Listener {

	public DebugListener() {
		StarPortSimulator.getInstance().getEventCoordinator().addListener(this);
	}
	
	@EventHandler
	public void onEvent(Event event) {
		StarPortSimulator.getLogger().log(Level.FINE, "Recieved Event: " + event.getClass().getName());
	}
	
	@EventHandler
	public void onMessageEvent(MessageEvent event) {
		StarPortSimulator.getLogger().log(Level.FINE, event.getMessage());
	}
	
}
