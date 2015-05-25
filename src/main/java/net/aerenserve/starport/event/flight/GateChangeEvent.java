package net.aerenserve.starport.event.flight;

import net.aerenserve.starport.engine.architecture.Gate;
import net.aerenserve.starport.engine.flights.Flight;

public class GateChangeEvent extends FlightEvent {
	
	protected Gate newGate;
	protected final Gate oldGate;
	
	public GateChangeEvent(Flight flight, Gate newGate) {
		super(flight);
		this.newGate = newGate;
		this.oldGate = flight.getGate();
	}
		
	public Gate getOldGate() {
		return this.oldGate;
	}
	
	public Gate getNewGate() {
		return this.newGate;
	}
	
	public void setGate(Gate newGate) {
		this.newGate = newGate;
	}
}
