package net.aerenserve.starport.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	
	private static final ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

	public static void schedule(Runnable runnable, long delayMs) {
		exec.schedule(runnable, delayMs, TimeUnit.MILLISECONDS);
	}
}
