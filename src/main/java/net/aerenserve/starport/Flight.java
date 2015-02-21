package net.aerenserve.starport;

public class Flight {
	
	private final FlightData data;
	private Gate gate;
	private Itinerary itinerary;

	public Flight(FlightData data, Gate gate, Itinerary itinerary) {
		this.data = data;
		this.gate = gate;
		this.itinerary = itinerary;
	}
	
	
	public FlightData getData() {
		return data;
	}

	public Gate getGate() {
		return gate;
	}

	public void setGate(Gate gate) {
		this.gate = gate;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

}
