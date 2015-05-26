package net.aerenserve.starport.engine.coordinator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.architecture.Gate;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.architecture.Gate.State;
import net.aerenserve.starport.engine.flights.Classification;
import net.aerenserve.starport.engine.flights.Flight;
import net.aerenserve.starport.engine.flights.FlightData;
import net.aerenserve.starport.event.CancellableEvent;
import net.aerenserve.starport.event.flight.ArrivalDelayEvent;
import net.aerenserve.starport.event.flight.GateChangeEvent;

import org.joda.time.DateTime;

public class ArrivalCoordinator implements Coordinator {
	
	private Map<Gate, Flight> gates;
	private Terminal terminal;
	
	public ArrivalCoordinator() {
		this.gates = new ConcurrentHashMap<Gate, Flight>();
	}

	@Override
	public Flight addFlight(FlightData data, Gate gate, Itinerary itinerary) {
		Flight newFlight = new Flight(data, gate, itinerary);
		this.gates.put(gate, newFlight);
		this.terminal.setState(gate, State.ARRIVAL);
		return newFlight;
	}
	
	@Override
	public Flight addFlight(FlightData data) {
		Gate gate;
		if(this.terminal.hasOpenGate()) {
			gate = this.terminal.getGate(Gate.State.OPEN);
		} else {
			gate = new Gate(-1, this.terminal);
			this.terminal.addGate(gate);

		}
		Flight flight = addFlight(data, gate, null);
		StarPortSimulator.getLogger().info("Gate " + gate.getIdentifier() + " now recieving: " + data.name + " - [" + data.classification + "]");
		return flight;
	}

	@Override
	public void delayFlight(Flight flight, Itinerary itinerary) {
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
