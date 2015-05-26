package net.aerenserve.starport;

import net.aerenserve.starport.engine.StarPortSimulator;

public class Main {
	
	/**
	 * Launch a StarPortSimulator instance from command line
	 * 
	 * @param args As of now, no args are needed to run.
	 * @see StarPortSimulator
	 */

	public static void main(String[] args) {
		System.out.println("Starting StarPort Simulator. . .");
		boolean debug = false;
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("-debug"))
				debug = true;
		}
		new StarPortSimulator(debug).start();
	}
}
