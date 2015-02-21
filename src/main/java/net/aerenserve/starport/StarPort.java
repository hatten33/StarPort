package net.aerenserve.starport;

public interface StarPort {

	public String getName();
	public String setName();
	
	public Coordinator getDepartureCoordinator();
	public Coordinator getArrivalCoordinator();
}
