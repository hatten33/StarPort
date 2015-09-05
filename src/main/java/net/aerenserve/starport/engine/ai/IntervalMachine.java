package net.aerenserve.starport.engine.ai;

import java.util.Random;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.scheduler.Scheduler;

/**
 * May it make your games interesting.
 *
 */
public class IntervalMachine extends AIThread {
	
	protected final Random rand;
	protected EntropyThing entropy;

	public IntervalMachine(float chaosFactor, int interval, int intervalRandom) {
		super(new EntropyThing(chaosFactor, interval, intervalRandom));
		this.rand = new Random();
		this.entropy = (EntropyThing) this.getThing();
	}
	
	public boolean chaos() {
		return rand.nextFloat() <= entropy.getChaosFactor();
	}
	
	public long getNextDelay() {
		if(chaos()) {
			StarPortSimulator.getLogger().finest("IntervalMachine generated chaos as next delay.");
			return 0; //TODO let's make this more chaotic sometime
		} else {
			int r = rand.nextInt(entropy.getIntervalRandom());
			int ret = rand.nextBoolean() ? entropy.getInterval() + r : entropy.getInterval() - r;
			StarPortSimulator.getLogger().finest("IntervalMachine returning " + ret + " as next delay.");
			return ret;
		}
	}

	@Override
	public void run() {
		reproduce();
	}
	
	@Override
	public void reproduce() {
		Scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				int flights = 1;
				if(chaos()) {
					StarPortSimulator.getLogger().finest("IntervalMachine generated chaos as the flight number.");
					flights = 10;
				}
				StarPortSimulator.getInstance().getCurrentGame().createFlights(flights);
				reproduce();
			}
		}, getNextDelay() * 1000);
	}
	
}
