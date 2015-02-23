package net.aerenserve.starport;

import net.aerenserve.starport.architecture.Gate;
import net.aerenserve.starport.architecture.Terminal;

public interface Coordinator {

	public Flight addFlight(FlightData data, Gate gate, Itinerary itinerary);
	public Flight addFlight(FlightData data);
	
	public void delayFlight(Flight flight, Itinerary itinerary);
	public void changeGate(Flight flight, Gate newGate);
	
	public void setTerminal(Terminal terminal);
	
	public void list();
	
}
