package net.aerenserve.starport.plugins;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.plugins.defaults.UniversePlugin;

public class PluginManager {

	private Map<String, Plugin> plugins;

	public PluginManager() {
		plugins = new ConcurrentHashMap<String, Plugin>();
		loadDefaultPlugins();
	}

	private void loadDefaultPlugins() {

		/* Universe */ 
		UniversePlugin universe = new UniversePlugin();
		if(registerPlugin(universe))
			universe.onLoad();

	}

	public boolean registerPlugin(Plugin plugin) {
		if(plugin.getClass().isAnnotationPresent(PluginData.class)) {
			String name = plugin.getClass().getAnnotation(PluginData.class).name();
			if(this.plugins.keySet().contains(name.toLowerCase())) {
				return false;
			} else {
				this.plugins.put(name.toLowerCase(), plugin);
				return true;
			}
		} else {
			StarPortSimulator.getLogger().info("I found a plugin class called " + plugin.getClass().getName() + ", but it has no PluginData Annotation");
			return false;
		}
	}

	public Plugin getPlugin(String name) {
		return this.plugins.get(name.toLowerCase());
	}
}
