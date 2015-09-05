package net.aerenserve.starport.engine.location;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.names.PlanetNames;
import net.aerenserve.starport.engine.names.StarNames;

public class System implements Mappable {
	
	private final String name;
	private final HyperspaceCoordinate coordinate;
	
	private Map<String, Destination> places;
	
	public System(String name, HyperspaceCoordinate coordinate) {
		this(name, 12 + (216 - 12) * new Random().nextDouble(), coordinate);
	}
	
	public System(String name, double radius, HyperspaceCoordinate coordinate) {
		this.name = name;
		this.coordinate = coordinate;
		this.places = genPlaces(radius);
		StringBuilder sb = new StringBuilder();
		sb.append("System populated with destinations:\n" +
				"System: " + getName() + "\n" +
				"Radius: " + Coordinate.round(radius) + "\n" +
				"Hyperspace Coord: "  + coordinate.toString() + "\n");
		for(Destination d : places.values()) {
			sb.append("    " + d.toString() + "\n");
		}
		StarPortSimulator.getLogger().info(sb.toString());
				
	}
	
	public String getName() {
		return this.name;
	}
	
	public HyperspaceCoordinate getCoordinate() {
		return this.coordinate;
	}
	
	public Map<String, Destination> getDestinations() {
		return this.places;
	}
	
	private Map<String, Destination> genPlaces(double radius) {
		List<String> nameRegistry = new ArrayList<String>();
		Map<String, Destination> places = new HashMap<String, Destination>();
		
		double maxPlaces = radius / 12;
		
		Random r = new Random();
		double rangeMin = -radius;
		double rangeMax = radius;
		
		//Generate the star
		Destination star = new Destination(this.name, new LocationCoordinate(0,0,0));
		places.put(this.name, star);
		
		for(double i = 0; i < maxPlaces; i++) {
			double rX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rZ = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			LocationCoordinate loc = new LocationCoordinate(rX, rY, rZ);
			while(!locationOkay(loc, places.values())) {
				double X = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				double Y = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				double Z = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				loc = new LocationCoordinate(X, Y, Z);
			}
			String name = PlanetNames.gen();
			while(nameRegistry.contains(name)) {
				name = StarNames.gen();
			}
			Destination place = new Destination(name, loc);
			places.put(name, place);
		}
		if(places.size() <= 1) {
			double rX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rZ = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			Destination place = new Destination(PlanetNames.gen(), new LocationCoordinate(rX, rY, rZ));
			places.put(name, place);
		}
		return places;
	}
	
	private boolean locationOkay(LocationCoordinate loc, Collection<Destination> others) {
		for(Destination d : others) {
			if(d.getCoordinate().getDistance(loc) < 5) return false;
		}
		return true;
	}

	@Override
	public double[][] getPoints() {
		double[][] pts = new double[places.size()][3];
		int i = 0;
		for(Destination d : places.values()) {
			pts[i] = d.getCoordinate().toArray();
			i++;
		}
		return pts;
	}
}
