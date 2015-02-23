package net.aerenserve.starport.engine;

public class SpawnerRunnable implements Runnable {

	@Override
	public void run() {
		StarPortSimulator.getInstance().getCurrentGame().createFlights(2);
		StarPortSimulator.getLogger().info("Spawned 2 flights!");
		StarPortSimulator.getLogger().info("useless message");
	}

}
