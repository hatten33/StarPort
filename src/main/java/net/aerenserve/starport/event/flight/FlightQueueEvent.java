package net.aerenserve.starport.event.flight;

import net.aerenserve.starport.engine.flights.Flight;
import net.aerenserve.starport.event.MessageEvent;

public class FlightQueueEvent extends MessageEvent {
	
	protected final Flight flight;
	
	public FlightQueueEvent(Flight flight) {
		super("Queuing flight | " + flight.getData().toString());
		this.flight = flight;
	}
	
	public Flight getFlight() {
		return this.flight;
	}
	
}
