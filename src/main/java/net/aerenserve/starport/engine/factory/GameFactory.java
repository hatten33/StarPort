package net.aerenserve.starport.engine.factory;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.event.MessageEvent;

public class GameFactory implements Factory {

	@Override
	public Creatable create() {
		StarPortSimulator.getInstance().getEventCoordinator().fireEvent(new MessageEvent("GameFactory created a new Game."));
		StarPortSimulator.getInstance();
		return new Game(StarPortSimulator.DEBUG);
	}

}
