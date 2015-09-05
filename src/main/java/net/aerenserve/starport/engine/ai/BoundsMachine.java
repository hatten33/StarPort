package net.aerenserve.starport.engine.ai;

import java.util.Random;

import net.aerenserve.starport.engine.StarPortSimulator;
import net.aerenserve.starport.scheduler.Scheduler;

public class BoundsMachine extends AIThread {
	
	protected final Random rand;
	protected EntropyThing entropy;
	
	private transient int lastMin;
	private transient int lastMax;

	public BoundsMachine(float chaosFactor, int interval, int intervalRandom) {
		super(new EntropyThing(chaosFactor, interval, intervalRandom));
		this.rand = new Random();
		this.entropy = (EntropyThing) this.getThing();
	}
	
	public boolean chaos() {
		return rand.nextFloat() <= entropy.getChaosFactor();
	}
	
	public long getNextInteger(int min, int max) {
		this.lastMax = max;
		this.lastMin = min;
		if(chaos()) {
			StarPortSimulator.getLogger().finest("BoundsMachine generated chaos. Ignoring bounds...");
			return 0; //TODO let's make this more chaotic sometime
		} else {
			int r = rand.nextInt(entropy.getIntervalRandom());
			int ret = rand.nextBoolean() ? entropy.getInterval() + r : entropy.getInterval() - r;
			StarPortSimulator.getLogger().finest("EntropyMachine returning " + ret + " as next delay.");
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
				
			}
		}, getNextInteger(lastMin, lastMax) * 1000);
	}
	
}
