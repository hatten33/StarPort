package net.aerenserve.starport;

public interface Coordinator {

	public Flight addFlight(FlightData data, Itinerary itinerary, Gate gate);
	
	public void delayFlight(Flight flight, Itinerary itinerary);
	public void changeGate(Flight flight, Gate newGate);
	
}
