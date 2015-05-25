package net.aerenserve.starport.engine.coordinator;

import net.aerenserve.starport.engine.Itinerary;
import net.aerenserve.starport.engine.architecture.Gate;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.flights.Flight;
import net.aerenserve.starport.engine.flights.FlightData;

public interface Coordinator {

	public Flight addFlight(FlightData data, Gate gate, Itinerary itinerary);
	public Flight addFlight(FlightData data);
	
	public void delayFlight(Flight flight, Itinerary itinerary);
	public void changeGate(Flight flight, Gate newGate);
	
	public void setTerminal(Terminal terminal);
	
	public void list();
	
}
