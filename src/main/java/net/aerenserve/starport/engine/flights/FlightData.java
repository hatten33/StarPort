package net.aerenserve.starport.engine.flights;

import net.aerenserve.starport.engine.factory.Creatable;
import net.aerenserve.starport.engine.location.Destination;

public class FlightData implements Creatable {
	
	public final String name;
	
	public final Classification classification;
	public final int passengers;
	public final int cargo;
	public final Destination destination;

	public FlightData(String name, Classification classification, int passengers, int cargo, Destination destination) {
		this.name = name;
		this.classification = classification;
		this.passengers = passengers;
		this.cargo = cargo;
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return String.format("%s class vessel \"%s\" with %d passengers and %d cargo, en route to %s", classification, name, passengers, cargo, destination);
	}
}
