package net.aerenserve.starport.event.flight;

import net.aerenserve.starport.engine.flights.Flight;

import org.joda.time.DateTime;

public class DepartureDelayEvent extends FlightDelayEvent {

	public DepartureDelayEvent(Flight flight, DateTime newDepartureTime) {
		super(flight, newDepartureTime);
	}
}
