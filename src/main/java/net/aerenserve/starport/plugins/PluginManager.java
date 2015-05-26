package net.aerenserve.starport.plugins;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.aerenserve.starport.engine.SpawnerRunnable;
import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.plugins.defaults.DebugPlugin;
import net.aerenserve.starport.plugins.defaults.UniversePlugin;
import net.aerenserve.starport.scheduler.Scheduler;

public class PluginManager {
	
	private final boolean debug;

	private Map<String, Plugin> plugins; //lowercase Plugin name, Plugin object
	private Map<String, Method> commands; //command name, corresponding method
	private Map<String, String> registry; //command name, corresponding plugin

	public PluginManager(boolean debug) {
		plugins = new ConcurrentHashMap<String, Plugin>();
		commands = new ConcurrentHashMap<String, Method>();
		registry = new ConcurrentHashMap<String, String>();
		
		this.debug = debug;
	}

	public void loadDefaultPlugins() {

		/* Universe */ 
		UniversePlugin universe = new UniversePlugin();
		if(registerPlugin(universe))
			universe.onLoad();

		/* Debugger */
		final DebugPlugin debugger = new DebugPlugin();
		if(registerPlugin(debugger))
			debugger.onLoad();
		if(debug)
			Scheduler.schedule(new Runnable() {
				@Override
				public void run() {
					debugger.onEnable();
				}
			}, 250);
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
			StarPortSimulator.getLogger().warning("I found a plugin class called " + plugin.getClass().getName() + ", but it has no PluginData Annotation");
			return false;
		}
	}

	public Plugin getPlugin(String name) {
		return this.plugins.get(name.toLowerCase());
	}

	/**
	 * Do not call this yourself. Use {@link Plugin#registerCommands()} instead.
	 */
	public void registerCommand(Plugin plugin, Method m) {
		String name = m.getAnnotation(CommandHandler.class).name().toLowerCase();
		String pName = plugin.getClass().getAnnotation(PluginData.class).name().toLowerCase();
		//If plugin is registered/loaded (? unsure on loaded. probably.)
		if(this.plugins.keySet().contains(pName)) {
			if(!commands.keySet().contains(name)) {
				commands.put(name, m);
				registry.put(name, pName);
			}
		}
	}

	/**
	 * Do not call this yourself. Use {@link Plugin#unregisterCommands()} instead.
	 */
	public void unregisterCommand(Method m) {
		String name = m.getAnnotation(CommandHandler.class).name().toLowerCase();
		if(!commands.keySet().contains(name)) {
			commands.put(name, null);
			registry.put(name, null);
		}

	}

	public boolean passCommand(String command, String[] args) {
		for(Method m : commands.values()) {
			if(commandMatches(command, m)) {
				try {
					StarPortSimulator.getLogger().finest("Passing command: " + command + " to method: " + m.getName());
					return (boolean) m.invoke(plugins.get(registry.get(m.getAnnotation(CommandHandler.class).name().toLowerCase())), command, args, StarPortSimulator.getInstance().getCurrentGame());
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	private boolean commandMatches(String command, Method m) {
		if(m.getAnnotation(CommandHandler.class).name().equals(command.toLowerCase()) 
				|| Arrays.asList(m.getAnnotation(CommandHandler.class).aliases()).contains(command.toLowerCase())) {
			return true; 
		} else return false;
	}
}
