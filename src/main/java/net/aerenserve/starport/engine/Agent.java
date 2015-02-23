package net.aerenserve.starport.engine;

import net.aerenserve.starport.engine.factory.Factory;

public interface Agent {
	
	public Factory getFactory();
	public void setFactory(Factory factory) throws Exception;

	public void spawn();

}
