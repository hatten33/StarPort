package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;

public class ArrivalsAction implements CommandAction {
	
	@Override
	public void exec(Console c, String[] params) {
		Game game = StarPortSimulator.getInstance().getCurrentGame();
		if(game != null) {
			game.getStarPort().getArrivalCoordinator().list();
		}
	}
}
