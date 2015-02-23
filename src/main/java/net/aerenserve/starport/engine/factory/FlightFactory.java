package net.aerenserve.starport.engine.factory;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import net.aerenserve.starport.Classification;
import net.aerenserve.starport.Destination;
import net.aerenserve.starport.FlightData;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.event.MessageEvent;

public class FlightFactory implements Factory {
	
	private RandomCollection<Classification> classifications;
	
	public FlightFactory() {
		this.classifications = new RandomCollection<Classification>();
		for(Classification c : Classification.values()) {
			this.classifications.add(c.weight, c);
		}
	}

	@Override
	public FlightData create() {
		FlightData data = new FlightData(getRandomClassification(), 10, 3, new Destination(Destination.Planet.CORUSCANT));
		StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new MessageEvent("FlightFactory created a new FlightData. \n" +
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
