package net.aerenserve.starport.plugins.defaults;

import java.util.logging.Level;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.event.Event;
import net.aerenserve.starport.event.MessageEvent;
import net.aerenserve.starport.event.listener.EventHandler;
import net.aerenserve.starport.event.listener.Listener;
import net.aerenserve.starport.plugins.CommandHandler;
import net.aerenserve.starport.plugins.Plugin;
import net.aerenserve.starport.plugins.PluginData;

@PluginData (
		name = "Debugger",
		author = "hatten33",
		desc = "Increases log sensitivity and listens for all MessageEvents.", 
		main = "net.aerenserve.starport.plugins.defaults.DebugPlugin",
		currentVersion = 1.0
		)
public class DebugPlugin extends Plugin implements Listener {

	@Override
	public void onLoad() {
		StarPortSimulator.getLogger().info("Debugger v" + getVersion() + " by " + getPluginData().author() + " loaded.");
	}

	@Override
	public void onUnload() {
		StarPortSimulator.getLogger().info("Debugger v" + getVersion() + " unloaded.");	
	}

	@Override
	public void onEnable() {
		StarPortSimulator.getLogger().setLevel(Level.FINEST);
		StarPortSimulator.getInstance().getEventCoordinator().addListener(this);
		registerCommands();
		StarPortSimulator.getLogger().info("Debugger v" + getVersion() + " enabled!");
	}

	@Override
	public void onDisable() {
		StarPortSimulator.getInstance().getEventCoordinator().removeListener(this);
		StarPortSimulator.getLogger().info("Debugger v" + getVersion() + " disabled!");		
	}

	@EventHandler
	public void onFlightDataCreateEvent(MessageEvent event) {
		StarPortSimulator.getLogger().info(event.getMessage());
	}
	
	@EventHandler
	public void onEvent(Event event) {
		StarPortSimulator.getLogger().finest("Recieved Event: " + event.getClass().getName());
	}
	
	@CommandHandler(name="level", aliases={"lvl", "log"})
	public boolean levelCommand(String command, String[] args, Game game) {
		if(args.length >= 1) {
			try {
				StarPortSimulator.getLogger().setLevel(Level.parse(args[0].toUpperCase()));
			} catch (IllegalArgumentException e) { 
				StarPortSimulator.getLogger().warning("That is not a valid log level!\n"
						+ "Try FINEST, FINER, FINE, INFO, WARNING, SEVERE, CONFIG, ALL, OFF");
			}
		} else {
			StarPortSimulator.getLogger().info("Usage: $ level FINEST");
		}
		return true;
	}
}
