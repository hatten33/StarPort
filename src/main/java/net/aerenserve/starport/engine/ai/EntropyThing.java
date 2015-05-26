package net.aerenserve.starport.engine.ai;

public class EntropyThing implements Thing {

	protected float chaosFactor;
	protected int interval;
	protected int intervalRandom;
	
	public EntropyThing(float chaosFactor, int interval, int intervalRandom) {
		this.chaosFactor = chaosFactor;
		this.interval = interval;
		this.intervalRandom = intervalRandom;
	}
	
	public float getChaosFactor() {
		return chaosFactor;
	}
	
	public void setChaosFactor(float chaosFactor) {
		this.chaosFactor = chaosFactor;
	}
	
	public int getInterval() {
		return interval;
	}
	
	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public int getIntervalRandom() {
		return intervalRandom;
	}
	
	public void setIntervalRandom(int intervalRandom) {
		this.intervalRandom = intervalRandom;
	}

}
