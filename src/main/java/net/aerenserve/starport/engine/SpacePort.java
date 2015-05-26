package net.aerenserve.starport.engine;

import net.aerenserve.starport.engine.architecture.Architecture;
import net.aerenserve.starport.engine.coordinator.ArrivalCoordinator;
import net.aerenserve.starport.engine.coordinator.DepartureCoordinator;

public class SpacePort implements StarPort {

	private String name;

	private DepartureCoordinator departure;
	private ArrivalCoordinator arrival;

	private Architecture architecture;
	
	public SpacePort(String name, DepartureCoordinator departure, ArrivalCoordinator arrival, Architecture architecture) {
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
		this.architecture = architecture;
		
		this.departure.setTerminal(architecture.getTerminals().get(0));
		this.arrival.setTerminal(architecture.getTerminals().get(0));
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String newName) {
		this.name = newName;
	}

	@Override
	public DepartureCoordinator getDepartureCoordinator() {
		return this.departure;
	}

	@Override
	public ArrivalCoordinator getArrivalCoordinator() {
		return this.arrival;
	}

	@Override
	public Architecture getArchitecture() {
		return this.architecture;
	}
	
	@Override
	public Type getType() {
		return Type.SPACE;
	}

}
