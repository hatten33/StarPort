package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.architecture.Architecture;
import net.aerenserve.starport.engine.architecture.Terminal;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.StarPort;

public class NewGameAction implements Action {

	@Override
	public void exec(Console c, String[] params) {
		Game game = StarPortSimulator.getInstance().newGame();
		if(params.length > 1) {
			game.setStarPort(StarPort.Type.SPACE, Architecture.Type.valueOf(params[0]), Terminal.Size.valueOf(params[1]));
		}
		StarPortSimulator.getLogger().info("Your game is ready. Type 'begin' to start simulation.");
	}
}
