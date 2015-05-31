package net.aerenserve.starport.engine.ai;

import net.aerenserve.starport.engine.Game;

public class TheAI {
	
	public TheAI(Game g) {
		new Thread(new EntropyMachine(0.05f, 30, 15)).start();
	}

}
