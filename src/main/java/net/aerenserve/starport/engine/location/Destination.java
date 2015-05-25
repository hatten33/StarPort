package net.aerenserve.starport.engine.location;

import net.aerenserve.starport.engine.names.PlanetNames;


public class Destination {
	
	public enum Planet { 
		CORUSCANT("Coruscant", new HyperspaceCoordinate(0,0,0));
		
		public final String name;
		public final Coordinate coordinate;

		private Planet(String name, HyperspaceCoordinate coordinate) {
			this.name = name;
			this.coordinate = coordinate;
		}
	}
	
	private final String name;
	private final Coordinate coordinate;
	
	public Destination(Planet planet) {
		this.name = planet.name;
		this.coordinate = planet.coordinate;
	}
	
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
