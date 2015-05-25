package net.aerenserve.starport.engine;

import java.io.IOException;
import java.util.logging.Logger;

import net.aerenserve.starport.console.ConsoleThread;
import net.aerenserve.starport.console.StarportLogger;
import net.aerenserve.starport.engine.factory.FlightDataFactory;
import net.aerenserve.starport.engine.factory.GameFactory;
import net.aerenserve.starport.engine.factory.StarportFactory;
import net.aerenserve.starport.event.EventCoordinator;
import net.aerenserve.starport.event.listener.DebugListener;

public class StarPortSimulator {
	
	public static Logger logger;
	
	public static StarPortSimulator instance;
	private final EventCoordinator eventCoordinator;

	private final GameFactory gameFactory;
	private final StarportFactory starportFactory;
	private final FlightDataFactory flightFactory;
	
	private transient Game game;

	public StarPortSimulator() {
		instance = this;

		logger = getLogger();
		
		this.eventCoordinator = new EventCoordinator();
		this.gameFactory = new GameFactory();
		this.starportFactory = new StarportFactory();
		this.flightFactory = new FlightDataFactory();
		
		new DebugListener();
	}
	
	public void start() {
		new Thread(new ConsoleThread()).start();
	}
	
	public Game newGame() {
		this.game = (Game) this.gameFactory.create();
		return this.game;
	}
	
	public void end() {
		instance = null;
	}
	
	public Game getCurrentGame() {
		return this.game;
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

	public FlightDataFactory getFlightFactory() {
		return flightFactory;
	}

	public static StarPortSimulator getInstance() {
		return instance;
	}
	
	private static Logger initializeLogger() {
		Logger logger = null;
		try {
			logger = StarportLogger.setup();
			logger.setUseParentHandlers(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logger;
	}
	
	public static Logger getLogger() {
		if(logger == null) {
			logger = initializeLogger();
		}
		return logger;
	}
}
