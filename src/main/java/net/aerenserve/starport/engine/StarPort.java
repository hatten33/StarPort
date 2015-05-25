package net.aerenserve.starport.engine;

import net.aerenserve.starport.engine.architecture.Architecture;
import net.aerenserve.starport.engine.coordinator.Coordinator;
import net.aerenserve.starport.engine.factory.Creatable;

public interface StarPort extends Creatable {
	
	public enum Type {
		SPACE,
	}

	public String getName();
	public void setName(String newName);
	
	public Coordinator getDepartureCoordinator();
	public Coordinator getArrivalCoordinator();
	
	public Architecture getArchitecture();

}
