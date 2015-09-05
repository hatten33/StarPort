package net.aerenserve.starport.engine.coordinator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.architecture.Gate;
import net.aerenserve.starport.engine.architecture.Gate.State;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.flights.Classification;
import net.aerenserve.starport.engine.flights.Flight;
import net.aerenserve.starport.engine.flights.FlightData;
import net.aerenserve.starport.event.CancellableEvent;
import net.aerenserve.starport.event.flight.ArrivalDelayEvent;
import net.aerenserve.starport.event.flight.FlightQueueEvent;
import net.aerenserve.starport.event.flight.GateChangeEvent;

import org.joda.time.DateTime;

public class ArrivalCoordinator implements FlightCoordinator {
	
	private Map<Gate, Flight> gates;
	private Terminal terminal;
	
	private List<Flight> queue;
	 
	public ArrivalCoordinator() {
		this.gates = new ConcurrentHashMap<Gate, Flight>();
		this.queue = new ArrayList<Flight>();
	}

	@Override
	public Flight addFlight(Flight flight, Gate gate) {
		CancellableEvent e = (CancellableEvent) StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new GateChangeEvent(flight, gate));
		if(!e.isCancelled()) return null;
		this.gates.put(gate, flight);
		this.terminal.setState(gate, State.ARRIVAL);	
		StarPortSimulator.getLogger().info("Gate " + gate.getIdentifier() + " now recieving: " + flight.getData().name + " - [" + flight.getData().classification + "]");
		return flight;
	}
	
	public Flight queue(FlightData data) {
		Flight flight = new Flight(data, null, null);
		this.queue.add(flight);
		CancellableEvent e = (CancellableEvent) StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new FlightQueueEvent(flight));
		if(!e.isCancelled()) return null;
		return flight;
	}

	@Override
	public void setFlightItinerary(Flight flight, Itinerary itinerary) {
		flight.setItinerary(itinerary);
	}
	
	public void delayFlight(Flight flight, int minutes) {
		DateTime newTime = flight.getItinerary().getArrival();
		CancellableEvent e = (CancellableEvent) StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new ArrivalDelayEvent(flight, newTime.plusMinutes(minutes)));
		if(!e.isCancelled()) flight.getItinerary().delayArrival(minutes);
	}

	@Override
	public void changeGate(Flight flight, Gate newGate) {
		CancellableEvent e = (CancellableEvent) StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new GateChangeEvent(flight, newGate));
		if(!e.isCancelled()) flight.setGate(newGate);	
	}

	@Override
	public void list() {
		Map<Classification, Integer> count = new HashMap<Classification, Integer>();
		for(Classification c : Classification.values()) {
			count.put(c, 0);
		}
		for(Gate g : gates.keySet()) {
			Classification classification = gates.get(g).getData().classification;
			count.put(classification, count.get(classification) + 1);
		}
		for(Classification c : count.keySet()) {
			StarPortSimulator.getLogger().info(c + " count: " + count.get(c));
		}
	}

	@Override
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

}
