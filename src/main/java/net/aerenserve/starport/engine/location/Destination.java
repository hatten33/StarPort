package net.aerenserve.starport.engine.location;

import net.aerenserve.starport.engine.names.PlanetNames;


public class Destination {
	
	private final String name;
	private final Coordinate coordinate;
	
	public Destination(String name, Coordinate coordinate) {
		this.name = name;
		this.coordinate = coordinate;
	}

	public String getName() {
		return name;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public static Destination getRandom() {
		return new Destination(PlanetNames.gen(), new HyperspaceCoordinate(0,0,0));
	}

}
