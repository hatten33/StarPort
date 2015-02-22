package net.aerenserve.starport;

import org.joda.time.DateTime;

import net.aerenserve.starport.architecture.Gate;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.events.ArrivalDelayEvent;
import net.aerenserve.starport.events.CancellableEvent;
import net.aerenserve.starport.events.GateChangeEvent;

public class ArrivalCoordinator implements Coordinator {

	@Override
	public Flight addFlight(FlightData data, Itinerary itinerary, Gate gate) {
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
		DateTime newTime = flight.getItinerary().getArrival();
		CancellableEvent e = StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new ArrivalDelayEvent(flight, newTime.plusMinutes(minutes)));
		if(!e.isCancelled()) flight.getItinerary().delayArrival(minutes);
	}

	@Override
	public void changeGate(Flight flight, Gate newGate) {
		CancellableEvent e = StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new GateChangeEvent(flight, newGate));
		if(!e.isCancelled()) flight.setGate(newGate);	
	}

}
