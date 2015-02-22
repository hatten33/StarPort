package net.aerenserve.starport.engine;

import net.aerenserve.starport.PlanetaryPort;
import net.aerenserve.starport.SpacePort;
import net.aerenserve.starport.StarPort;
import net.aerenserve.starport.architecture.Architecture;
import net.aerenserve.starport.architecture.Terminal;

public class StarportFactory implements Factory {

	@Override
	public Creatable create() {
		return create(StarPort.Type.SPACE, Architecture.Type.BASIC, Terminal.Size.SMALL);
	}
	
	public StarPort create(StarPort.Type portType, Architecture.Type archType, Terminal.Size size) {
		StarPort starport;
		switch(portType) {
		case PLANETARY:
			starport = new PlanetaryPort();
			break;
		case SPACE:
			starport = new SpacePort();
			break;
		default:
			return null;		
		}
		starport.setArchitecture(Architecture.getFromType(archType, size));
		return starport;
	}

}
