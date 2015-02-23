package net.aerenserve.starport.engine;

import net.aerenserve.starport.StarPort;
import net.aerenserve.starport.architecture.Architecture;
import net.aerenserve.starport.architecture.Terminal;
import net.aerenserve.starport.engine.factory.Creatable;
import net.aerenserve.starport.scheduler.Scheduler;

public class Game implements Creatable {
	
	private StarPort starport;
	private FlightAgent flightAgent;

	public Game() {
		this(StarPortSimulator.getInstance().getStarportFactory().create());
	}
	
	public Game(StarPort.Type portType, Architecture.Type archType, Terminal.Size size) {
		this(StarPortSimulator.getInstance().getStarportFactory().create(portType, archType, size));
	}
	
	public Game(StarPort starport) {
		this.starport = starport;
		if(starport == null) StarPortSimulator.getLogger().warning("STARPORT IS NULL!");
		
		this.flightAgent = new FlightAgent();
		try {
			this.flightAgent.setFactory(StarPortSimulator.getInstance().getFlightFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StarPort getStarPort() {
		return this.starport;
	}
	
	public void begin() {
		Scheduler.schedule(new SpawnerRunnable(), 4000);
	}
	
	public void createFlights(int number) {
		for(int i = 0; i < number; i++) {
			this.flightAgent.spawn();
		}
	}
}
