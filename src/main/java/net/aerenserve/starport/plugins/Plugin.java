package net.aerenserve.starport.plugins;

import java.lang.reflect.Method;

import net.aerenserve.starport.engine.Game;
import net.aerenserve.starport.engine.StarPortSimulator;

public abstract class Plugin {

	public abstract void onLoad();
	public abstract void onUnload();

	public abstract void onEnable();
	public abstract void onDisable();

	public PluginData getPluginData() {
		return this.getClass().getAnnotation(PluginData.class);
	}

	public String getVersion() { 
		return getPluginData().currentVersion() + getPluginData().versionSuffix();
	}

	protected void registerCommands() {
		for(Method m : this.getClass().getDeclaredMethods()) {
			if(isValidCommandMethod(m)) {
				StarPortSimulator.getLogger().finest("Registering method: " + m.getName() + " as a command handler.");	
				StarPortSimulator.getInstance().getCurrentGame().getPluginManager().registerCommand(this, m);
			}
		}
	}

	protected void unregisterCommands() {
		for(Method m : this.getClass().getDeclaredMethods()) {
			if(isValidCommandMethod(m)) {
				StarPortSimulator.getInstance().getCurrentGame().getPluginManager().unregisterCommand(m);
			}
		}
	}

	private boolean isValidCommandMethod(Method m) {
		if(m.isAnnotationPresent(CommandHandler.class)) {
			if(m.getParameterTypes().length == 3) {
				Class<?>[] types = m.getParameterTypes();
				if(types[0].isAssignableFrom(String.class) 
						&& types[1].isAssignableFrom(String[].class)
						&& types[2].isAssignableFrom(Game.class)) {
					return true;
				}
			}
		}
		return false;
	}
}

