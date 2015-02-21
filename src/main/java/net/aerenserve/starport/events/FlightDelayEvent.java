package net.aerenserve.starport.events;

import net.aerenserve.starport.Flight;

import org.joda.time.DateTime;

public abstract class FlightDelayEvent extends FlightEvent {

	protected DateTime newTime;
	
	public FlightDelayEvent(Flight flight, DateTime newTime) {
		super(flight);
		this.newTime = newTime;
	}
	
	public DateTime getNewTime() {
		return this.newTime;
	}
	
}
