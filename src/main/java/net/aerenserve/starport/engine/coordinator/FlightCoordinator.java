package net.aerenserve.starport.engine.coordinator;

import net.aerenserve.starport.engine.architecture.Gate;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.flights.Flight;
import net.aerenserve.starport.engine.flights.FlightData;

public interface FlightCoordinator {

	public Flight addFlight(Flight flight, Gate gate);
	
	public Flight queue(FlightData data);
	
	public void setFlightItinerary(Flight flight, Itinerary itinerary);
	public void changeGate(Flight flight, Gate newGate);
	
	public void setTerminal(Terminal terminal);
	
	public void list();
	
}
