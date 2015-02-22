package net.aerenserve.starport;

import net.aerenserve.starport.architecture.Gate;

public interface Coordinator {

	public Flight addFlight(FlightData data, Itinerary itinerary, Gate gate);
	public Flight addFlight(FlightData data);
	
	public void delayFlight(Flight flight, Itinerary itinerary);
	public void changeGate(Flight flight, Gate newGate);
	
}
