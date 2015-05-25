package net.aerenserve.starport.engine.factory;

import net.aerenserve.starport.engine.SpacePort;
import net.aerenserve.starport.engine.StarPort;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.architecture.Architecture;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.coordinator.ArrivalCoordinator;
import net.aerenserve.starport.engine.coordinator.DepartureCoordinator;
import net.aerenserve.starport.event.MessageEvent;

public class StarportFactory implements Factory {

	@Override
	public StarPort create() {
		return create(StarPort.Type.SPACE, Architecture.Type.BASIC, Terminal.Size.SMALL);
	}
	
	public StarPort create(StarPort.Type portType, Architecture.Type archType, Terminal.Size size) {
		StarPort starport;
		switch(portType) {
		case SPACE:
			starport = new SpacePort("SpaceportX", new DepartureCoordinator(), new ArrivalCoordinator(), Architecture.getFromType(archType, size));
			break;
		default:
			return null;		
		}
		StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new MessageEvent("StarportFactory created a new StarPort. " +
				"{" + portType + ", " + archType + ", " + size + "}"));
		return starport;
	}

}
