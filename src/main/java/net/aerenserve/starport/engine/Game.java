package net.aerenserve.starport.engine;

import net.aerenserve.starport.engine.ai.TheAI;
import net.aerenserve.starport.engine.architecture.Architecture;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.factory.Creatable;
import net.aerenserve.starport.engine.flights.FlightAgent;
import net.aerenserve.starport.engine.location.Galaxy;
import net.aerenserve.starport.plugins.PluginManager;

public class Game implements Creatable {
	
	private PluginManager pluginManager;
	
	private final Galaxy galaxy;
	
	private StarPort starport;
	private FlightAgent flightAgent;

	public Game(boolean debug) {
		this(StarPortSimulator.getInstance().getStarportFactory().create(), debug);
	}
	
	public Game(StarPort.Type portType, Architecture.Type archType, Terminal.Size size, boolean debug) {
		this(StarPortSimulator.getInstance().getStarportFactory().create(portType, archType, size), debug);
	}
	
	public Game(StarPort starport, boolean debug) {
		this.galaxy = new Galaxy(30);
		
		this.starport = starport;
		
		if(starport == null) StarPortSimulator.getLogger().warning("No Starport found.");
		
		this.flightAgent = new FlightAgent();
		try {
			this.flightAgent.setFactory(StarPortSimulator.getInstance().getFlightFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		load(debug);
	}

	public StarPort getStarPort() {
		return this.starport;
	}
	
	public Galaxy getGalaxy() {
		return this.galaxy;
	}
	
	public void setStarPort(StarPort.Type portType, Architecture.Type archType, Terminal.Size size) {
		this.starport = StarPortSimulator.getInstance().getStarportFactory().create(portType, archType, size);
	}
	
	private void load(boolean debug) { 
		this.pluginManager = new PluginManager(debug);
		this.pluginManager.loadDefaultPlugins();
	}
	
	public void begin() {
		new TheAI(this);
	}
	
	public void createFlights(int number) {
		for(int i = 0; i < number; i++) {
			this.flightAgent.spawn();
		}
	}
	
	public PluginManager getPluginManager() {
		return this.pluginManager;
	}
}
