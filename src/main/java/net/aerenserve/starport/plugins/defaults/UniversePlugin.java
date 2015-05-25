package net.aerenserve.starport.plugins.defaults;

import java.util.ArrayList;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.event.FlightDataCreateEvent;
import net.aerenserve.starport.event.listener.EventHandler;
import net.aerenserve.starport.event.listener.Listener;
import net.aerenserve.starport.plugins.Plugin;
import net.aerenserve.starport.plugins.PluginData;

@PluginData (
		name = "Universe",
		author = "hatten33",
		desc = "Builds a 'universe' inside a game by making sure all objects/names are unique.", 
		main = "net.aerenserve.starport.plugins.defaults.Universe",
		currentVersion = 1.0
		)
public class UniversePlugin extends Plugin implements Listener {
	
	protected NameBackend backend;

	@Override
	public void onLoad() {
		StarPortSimulator.getLogger().info("Universe v" + getVersion() + " by " + getPluginData().author() + " loaded.");
	}

	@Override
	public void onUnload() {
		StarPortSimulator.getLogger().info("Universe v" + getVersion() + " unloaded.");	
	}

	@Override
	public void onEnable() {
		this.backend = new ListBackend();
		StarPortSimulator.getInstance().getEventCoordinator().addListener(this);
		StarPortSimulator.getLogger().info("Universe v" + getVersion() + " enabled!");
	}

	@Override
	public void onDisable() {
		StarPortSimulator.getInstance().getEventCoordinator().removeListener(this);
		StarPortSimulator.getLogger().info("Universe v" + getVersion() + " disabled!");		
	}
	
	@EventHandler
	public void onFlightDataCreateEvent(FlightDataCreateEvent event) {
		StarPortSimulator.getLogger().fine("Universe caught an event!");		
		if(!backend.nameInUse(event.getFlightData().name)) {
			backend.addName(event.getFlightData().name);
		} else {
			event.setCancelled(true);
		}
	}
	
	private abstract class NameBackend {
		public abstract boolean nameInUse(String name);
		public abstract boolean addName(String name);
		public abstract void removeName(String name);
	}
	
	private class ListBackend extends NameBackend {
		
		private ArrayList<String> names;
		
		public ListBackend() {
			this.names = new ArrayList<String>();
		}

		@Override
		public boolean nameInUse(String name) {
			return names.contains(name);
		}

		@Override
		public boolean addName(String name) {
			if(!nameInUse(name)) {
				names.add(name);
				return true;
			} else return false;
		}

		@Override
		public void removeName(String name) {
			names.remove(name);
		}
		
	}

}
