package net.aerenserve.starport.events;

import net.aerenserve.starport.Flight;

import org.joda.time.DateTime;

public class ArrivalDelayEvent extends FlightDelayEvent {

	public ArrivalDelayEvent(Flight flight, DateTime newArrivalTime) {
		super(flight, newArrivalTime);
	}

}
