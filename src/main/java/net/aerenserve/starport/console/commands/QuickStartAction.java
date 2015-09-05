package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;

public class QuickStartAction implements CommandAction {

	@Override
	public void exec(Console c, String[] params) throws Exception {
		new NewGameAction().exec(c, params);
		Game game = StarPortSimulator.getInstance().getCurrentGame();
		if(game != null) {
			game.getPluginManager().getPlugin("debugger").onEnable();
			game.getPluginManager().getPlugin("universe").onEnable();
			game.getPluginManager().getPlugin("map").onEnable();
		}
		new BeginGameAction().exec(c, params);
	}

}
