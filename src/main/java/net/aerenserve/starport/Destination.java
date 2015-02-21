package net.aerenserve.starport;

import net.aerenserve.starport.coordinate.Coordinate;
import net.aerenserve.starport.coordinate.HyperspaceCoordinate;

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

	public String getName() {
		return name;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

}
