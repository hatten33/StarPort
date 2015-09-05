package net.aerenserve.starport.engine;

import net.aerenserve.starport.engine.architecture.Architecture;
import net.aerenserve.starport.engine.coordinator.FlightCoordinator;
import net.aerenserve.starport.engine.factory.Creatable;

public interface StarPort extends Creatable {
	
	public enum Type {
		SPACE,
	}
	
	public Type getType();

	public String getName();
	public void setName(String newName);
	
	public FlightCoordinator getDepartureCoordinator();
	public FlightCoordinator getArrivalCoordinator();
	
	public Architecture getArchitecture();

}
