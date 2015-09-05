package net.aerenserve.starport.event.flight;

import net.aerenserve.starport.engine.architecture.Gate;
import net.aerenserve.starport.engine.flights.Flight;

public class GateAssignEvent extends FlightEvent {
	
	protected Gate newGate;
	
	public GateAssignEvent(Flight flight, Gate newGate) {
		super(flight);
		this.newGate = newGate;
	}
	
	public Gate getNewGate() {
		return this.newGate;
	}
	
	public void setGate(Gate newGate) {
		this.newGate = newGate;
	}
}
