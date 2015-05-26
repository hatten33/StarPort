package net.aerenserve.starport.engine.factory;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.flights.Classification;
import net.aerenserve.starport.engine.flights.FlightData;
import net.aerenserve.starport.engine.location.Destination;
import net.aerenserve.starport.engine.names.ShipNames;
import net.aerenserve.starport.event.MessageEvent;

public class FlightDataFactory implements Factory {
	
	private RandomCollection<Classification> classifications;
	
	public FlightDataFactory() {
		this.classifications = new RandomCollection<Classification>();
		for(Classification c : Classification.values()) {
			this.classifications.add(c.weight, c);
		}
	}

	@Override
	public FlightData create() {
		FlightData data = new FlightData(ShipNames.gen(), getRandomClassification(), 10, 3, Destination.getRandom());
		StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new MessageEvent("FlightDataFactory created a new FlightData. \n" +
				"Name: " + data.name + "\n" +
				"Classification: " + data.classification + "\n" +
				"Passengers: " + data.passengers + "\n" +
				"Cargo: " + data.cargo + "\n" +
				"Destination: " + data.destination.getName()));
		return data;
	}

	public Classification getRandomClassification() {
		return this.classifications.next();
	}
	
	private class RandomCollection<E> {
	    private final NavigableMap<Double, E> map = new TreeMap<Double, E>();
	    private final Random random;
	    private double total = 0;

	    public RandomCollection() {
	        this(new Random());
	    }

	    public RandomCollection(Random random) {
	        this.random = random;
	    }

	    public void add(double weight, E result) {
	        if (weight <= 0) return;
	        total += weight;
	        map.put(total, result);
	    }

	    public E next() {
	        double value = random.nextDouble() * total;
	        return map.ceilingEntry(value).getValue();
	    }
	}

}
