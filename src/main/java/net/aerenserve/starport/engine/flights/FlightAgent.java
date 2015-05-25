package net.aerenserve.starport.engine.flights;

import net.aerenserve.starport.engine.Agent;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.factory.Factory;
import net.aerenserve.starport.engine.factory.FlightDataFactory;
import net.aerenserve.starport.event.FlightDataCreateEvent;

public class FlightAgent implements Agent {
	
	private FlightDataFactory factory;
	
	@Override
	public FlightDataFactory getFactory() {
		return this.factory;
	}

	@Override
	public void setFactory(Factory factory) throws Exception {
		if(factory instanceof FlightDataFactory) {
			this.factory = (FlightDataFactory) factory;
		} else throw new Exception("FlightAgent will only accept FlightFactory! Factory provided: " + factory.getClass().getName());
	}
	
	@Override
	public void spawn() {
		FlightData data = this.factory.create();
		FlightDataCreateEvent event = new FlightDataCreateEvent(data);
		StarPortSimulator.getInstance().getEventCoordinator().fireEvent(event);
		if(!event.isCancelled()) {
			StarPortSimulator.getInstance().getCurrentGame().getStarPort().getArrivalCoordinator().addFlight(data);
		} else {
			spawn(); //This will create a stack overflow when used in conjunction with the universe plugin and it runs out of names.
		}
	}

}
