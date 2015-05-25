package net.aerenserve.starport.engine;

public class SpawnerRunnable implements Runnable {

	@Override
	public void run() {
		StarPortSimulator.getInstance().getCurrentGame().createFlights(2);
	}

}
