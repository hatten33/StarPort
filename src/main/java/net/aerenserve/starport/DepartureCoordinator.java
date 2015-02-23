package net.aerenserve.starport;

import net.aerenserve.starport.architecture.Gate;
import net.aerenserve.starport.architecture.Terminal;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.event.CancellableEvent;
import net.aerenserve.starport.event.flight.DepartureDelayEvent;
import net.aerenserve.starport.event.flight.GateChangeEvent;

import org.joda.time.DateTime;

public class DepartureCoordinator implements Coordinator {

	@Override
	public Flight addFlight(FlightData data, Gate gate, Itinerary itinerary) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Flight addFlight(FlightData data) {
		return null;
	}

	@Override
	public void delayFlight(Flight flight, Itinerary itinerary) {
		flight.setItinerary(itinerary);
	}
	
	public void delayFlight(Flight flight, int minutes) {
		DateTime newTime = flight.getItinerary().getDeparture();
		CancellableEvent e = (CancellableEvent) StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new DepartureDelayEvent(flight, newTime.plusMinutes(minutes)));
		if(!e.isCancelled()) flight.getItinerary().delayDeparture(minutes);
	}

	@Override
	public void changeGate(Flight flight, Gate newGate) {
		CancellableEvent e = (CancellableEvent) StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new GateChangeEvent(flight, newGate));
		if(!e.isCancelled()) flight.setGate(newGate);	
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTerminal(Terminal terminal) {
		// TODO Auto-generated method stub
		
	}


}

