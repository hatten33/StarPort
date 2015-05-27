package net.aerenserve.starport.engine.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.aerenserve.starport.engine.names.StarNames;

public class Galaxy {

	private Map<String, System> systems;
	
	public Galaxy(int systems) {
		this.systems = genSystems(systems);
	}
	
	private Map<String, System> genSystems(int num) {
		List<String> nameRegistry = new ArrayList<String>();
		Map<String, System> sys = new HashMap<String, System>();
		for(int i = 0; i < num; i++) {
			String star = StarNames.gen();
			while(nameRegistry.contains(star)) {
				star = StarNames.gen();
			}
			System system = new System(star);
			sys.put(star, system);
		}
		return sys;
	}
}
