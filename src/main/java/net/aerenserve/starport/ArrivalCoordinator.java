package net.aerenserve.starport;

public class ArrivalCoordinator implements Coordinator {

	@Override
	public Flight addFlight(FlightData data, Itinerary itinerary, Gate gate) {
		return null;
	}

	@Override
	public void delayFlight(Flight flight, Itinerary itinerary) {
		flight.setItinerary(itinerary);
	}
	
	public void delayFlight(Flight flight, int minutes) {
		flight.getItinerary().delayArrival(minutes);
	}

	@Override
	public void changeGate(Flight flight, Gate newGate) {
		flight.setGate(newGate);
	}

}
