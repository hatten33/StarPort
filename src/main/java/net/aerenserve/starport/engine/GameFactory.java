package net.aerenserve.starport.engine;

public class GameFactory implements Factory {

	@Override
	public Creatable create() {
		return new Game();
	}

}
