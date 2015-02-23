package net.aerenserve.starport.event.flight;

import net.aerenserve.starport.Flight;

import org.joda.time.DateTime;

public class ArrivalDelayEvent extends FlightDelayEvent {

	public ArrivalDelayEvent(Flight flight, DateTime newArrivalTime) {
		super(flight, newArrivalTime);
	}

}
