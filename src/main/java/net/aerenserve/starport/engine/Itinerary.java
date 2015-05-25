package net.aerenserve.starport.engine;

import org.joda.time.DateTime;

public class Itinerary {
	
	private DateTime departure;
	private DateTime arrival;
	
	public Itinerary(DateTime departure, DateTime arrival) {
		this.departure = departure;
		this.arrival = arrival;
	}

	public DateTime getDeparture() {
		return this.departure;
	}

	public void setDeparture(DateTime departure) {
		this.departure = departure;
	}

	public DateTime getArrival() {
		return this.arrival;
	}

	public void setArrival(DateTime arrival) {
		this.arrival = arrival;
	}
	
	public void delayDeparture(int minutes) {
		this.departure.plusMinutes(minutes);
	}
	
	public void delayArrival(int minutes) {
		this.arrival.plusMinutes(minutes);
	}


}
