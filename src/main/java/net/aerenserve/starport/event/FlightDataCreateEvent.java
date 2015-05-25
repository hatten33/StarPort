package net.aerenserve.starport.event;

import net.aerenserve.starport.engine.flights.FlightData;

public class FlightDataCreateEvent extends CancellableEvent {
	
	protected final FlightData data;
	
	public FlightDataCreateEvent(FlightData data) {
		this.data = data;
	}
	
	public FlightData getFlightData() {
		return this.data;
	}
	
}
