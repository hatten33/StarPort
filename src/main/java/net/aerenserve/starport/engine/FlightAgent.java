package net.aerenserve.starport.engine;

import net.aerenserve.starport.FlightData;
import net.aerenserve.starport.engine.factory.Factory;
import net.aerenserve.starport.engine.factory.FlightFactory;

public class FlightAgent implements Agent {
	
	private FlightFactory factory;
	
	@Override
	public FlightFactory getFactory() {
		return this.factory;
	}

	@Override
	public void setFactory(Factory factory) throws Exception {
		if(factory instanceof FlightFactory) {
			this.factory = (FlightFactory) factory;
		} else throw new Exception("FlightAgent will only accept FlightFactory! Factory provided: " + factory.getClass().getName());
	}
	
	@Override
	public void spawn() {
		FlightData flight = this.factory.create();
		StarPortSimulator.getInstance().getCurrentGame().getStarPort().getArrivalCoordinator().addFlight(flight);
	}

}
