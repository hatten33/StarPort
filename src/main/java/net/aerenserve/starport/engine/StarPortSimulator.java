package net.aerenserve.starport.engine;

import net.aerenserve.starport.events.DebugListener;
import net.aerenserve.starport.events.EventCoordinator;

public class StarPortSimulator {
	
	public static StarPortSimulator instance;
	private final EventCoordinator eventCoordinator;


	private final GameFactory gameFactory;
	private final StarportFactory starportFactory;
	private final FlightFactory flightFactory;

	public StarPortSimulator() {
		this.eventCoordinator = new EventCoordinator();
		this.gameFactory = new GameFactory();
		this.starportFactory = new StarportFactory();
		this.flightFactory = new FlightFactory();
		
		new DebugListener();
	}
	
	public void start() {
		instance = this;
	}
	
	public void end() {
		instance = null;
	}
	
	public EventCoordinator getEventCoordinator() {
		return this.eventCoordinator;
	}
	
	
	public GameFactory getGameFactory() {
		return gameFactory;
	}

	public StarportFactory getStarportFactory() {
		return starportFactory;
	}

	public FlightFactory getFlightFactory() {
		return flightFactory;
	}

	public static StarPortSimulator getInstance() {
		return instance;
	}
}
