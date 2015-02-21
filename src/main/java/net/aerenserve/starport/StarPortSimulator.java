package net.aerenserve.starport;

import net.aerenserve.starport.events.EventCoordinator;

public class StarPortSimulator {
	
	public static StarPortSimulator instance;
	private EventCoordinator eventCoordinator;

	
	public void start() {
		instance = this;
		this.eventCoordinator = new EventCoordinator();
	}
	
	public void end() {
		instance = null;
	}
	
	public EventCoordinator getEventCoordinator() {
		return this.eventCoordinator;
	}
	
	public static StarPortSimulator getInstance() {
		return instance;
	}
}
