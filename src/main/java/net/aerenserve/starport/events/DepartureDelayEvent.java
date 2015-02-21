package net.aerenserve.starport.events;

import net.aerenserve.starport.Flight;

import org.joda.time.DateTime;

public class DepartureDelayEvent extends FlightDelayEvent {

	public DepartureDelayEvent(Flight flight, DateTime newDepartureTime) {
		super(flight, newDepartureTime);
	}
}
