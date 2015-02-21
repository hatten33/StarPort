package net.aerenserve.starport;

import org.joda.time.DateTime;

import net.aerenserve.starport.events.ArrivalDelayEvent;
import net.aerenserve.starport.events.Event;
import net.aerenserve.starport.events.GateChangeEvent;

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
		DateTime newTime = flight.getItinerary().getArrival();
		Event e = StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new ArrivalDelayEvent(flight, newTime.plusMinutes(minutes)));
		if(!e.isCancelled()) flight.getItinerary().delayArrival(minutes);
	}

	@Override
	public void changeGate(Flight flight, Gate newGate) {
		Event e = StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new GateChangeEvent(flight, newGate));
		if(!e.isCancelled()) flight.setGate(newGate);	
	}

}
