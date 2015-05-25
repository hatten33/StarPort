package net.aerenserve.starport.event.flight;

import net.aerenserve.starport.engine.flights.Flight;
import net.aerenserve.starport.event.CancellableEvent;

public abstract class FlightEvent extends CancellableEvent {
	
	protected final Flight flight;
	
	public FlightEvent(Flight flight) {
		this.flight = flight;
	}
	
	public Flight getFlight() {
		return this.flight;
	}

}
