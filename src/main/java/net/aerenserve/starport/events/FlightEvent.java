package net.aerenserve.starport.events;

import net.aerenserve.starport.Flight;

public abstract class FlightEvent extends Event {
	
	protected final Flight flight;
	
	public FlightEvent(Flight flight) {
		this.flight = flight;
	}
	
	public Flight getFlight() {
		return this.flight;
	}

}
