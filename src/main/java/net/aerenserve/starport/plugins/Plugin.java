package net.aerenserve.starport.plugins;

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

}
