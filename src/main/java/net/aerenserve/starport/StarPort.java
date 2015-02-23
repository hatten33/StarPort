package net.aerenserve.starport;

import net.aerenserve.starport.architecture.Architecture;
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
