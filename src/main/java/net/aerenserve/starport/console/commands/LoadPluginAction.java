package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;

public class LoadPluginAction implements CommandAction {
	
	@Override
	public void exec(Console c, String[] params) {
		Game game = StarPortSimulator.getInstance().getCurrentGame();
		if(game != null) {
			//Still need to have it look for the plugin to load in plugin loader. PluginManager should handle compiling a list? 
			game.getPluginManager().getPlugin(params[0]).onLoad();
		}
	}
}
