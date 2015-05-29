package net.aerenserve.starport.engine.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
			
			Random r = new Random();
			
			double rangeMin = -(num * 12);
			double rangeMax = (num * 12);
			double rX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rZ = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			System system = new System(star, new HyperspaceCoordinate(rX, rY, rZ));

			sys.put(star, system);
		}
		return sys;
	}
}
