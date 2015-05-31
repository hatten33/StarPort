package net.aerenserve.starport.engine.location;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.aerenserve.starport.engine.names.StarNames;

public class Galaxy implements Mappable {

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

			HyperspaceCoordinate hyp = new HyperspaceCoordinate(rX, rY, rZ);
			while(!locationOkay(hyp, sys.values())) {
				double X = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				double Y = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				double Z = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
				hyp = new HyperspaceCoordinate(X, Y, Z);
			}
			System system = new System(star, hyp);
			sys.put(star.toLowerCase(), system);
		}
		return sys;
	}
	
	public System getSystem(String system) {
		return this.systems.get(system);
	}

	private boolean locationOkay(HyperspaceCoordinate hyp, Collection<System> others) {
		for(System s : others) {
			if(s.getCoordinate().getDistance(hyp) < 3) return false;
		}
		return true;
	}

	@Override
	public double[][] getPoints() {
		double[][] pts = new double[systems.size()][3];
		int i = 0;
		for(System s : systems.values()) {
			pts[i] = s.getCoordinate().toArray();
			i++;
		}
		return pts;
	}
}
