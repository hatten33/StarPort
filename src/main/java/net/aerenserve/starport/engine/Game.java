package net.aerenserve.starport.engine;

import net.aerenserve.starport.StarPort;
import net.aerenserve.starport.architecture.Architecture;
import net.aerenserve.starport.architecture.Terminal;

public class Game implements Creatable {
	
	public StarPort starport;

	public Game() {
		this((StarPort) StarPortSimulator.getInstance().getStarportFactory().create());
	}
	
	public Game(StarPort.Type portType, Architecture.Type archType, Terminal.Size size) {
		this((StarPort) StarPortSimulator.getInstance().getStarportFactory().create(portType, archType, size));
	}
	
	public Game(StarPort starport) {
		this.starport = starport;
	}

}
