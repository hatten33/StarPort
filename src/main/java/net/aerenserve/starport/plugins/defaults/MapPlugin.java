package net.aerenserve.starport.plugins.defaults;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.engine.location.System;
import net.aerenserve.starport.gui.SpaceMapper;
import net.aerenserve.starport.plugins.CommandHandler;
import net.aerenserve.starport.plugins.Plugin;
import net.aerenserve.starport.plugins.PluginData;


@PluginData (
		name = "Map",
		author = "hatten33",
		desc = "Adds a command to create maps of your galaxy and systems.", 
		main = "net.aerenserve.starport.plugins.defaults.MapPlugin",
		currentVersion = 1.0
		)
public class MapPlugin extends Plugin {

	@Override
	public void onLoad() {
		StarPortSimulator.getLogger().info("Map v" + getVersion() + " by " + getPluginData().author() + " loaded.");
	}

	@Override
	public void onUnload() {
		StarPortSimulator.getLogger().info("Map v" + getVersion() + " unloaded.");	
	}

	@Override
	public void onEnable() {
		registerCommands();
		StarPortSimulator.getLogger().info("Map v" + getVersion() + " enabled!");
	}

	@Override
	public void onDisable() {
		StarPortSimulator.getLogger().info("Map v" + getVersion() + " disabled!");		
	}

	@CommandHandler(name="map")
	public boolean mapCommand(String command, String[] args, Game game) {
		if(args.length >= 1) {
			if(args[0].equalsIgnoreCase("galaxy")) {
				new SpaceMapper(game.getGalaxy()).openMap();
			} else {
				System sys = game.getGalaxy().getSystem(args[0].toLowerCase());
				if(sys != null) {
			}
				new SpaceMapper(sys).openMap();
			}
		} else {
			StarPortSimulator.getLogger().info("Usage: $ map galaxy OR $ map (system name)");
		}
		return true;
	}
}
