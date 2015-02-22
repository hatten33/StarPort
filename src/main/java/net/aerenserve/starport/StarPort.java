package net.aerenserve.starport;

import net.aerenserve.starport.architecture.Architecture;
import net.aerenserve.starport.engine.Creatable;

public interface StarPort extends Creatable {
	
	public enum Type {
		SPACE,
		PLANETARY;
	}

	public String getName();
	public String setName();
	
	public Coordinator getDepartureCoordinator();
	public Coordinator getArrivalCoordinator();
	
	public Architecture getArchitecture();
	public void setArchitecture(Architecture architecture);

}
