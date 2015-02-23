package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.StarPortSimulator;

public class NewGameAction implements Action {

	@Override
	public void exec(Console c, String[] params) {
		StarPortSimulator.getInstance().newGame();
		StarPortSimulator.getLogger().info("Your game is ready. Type 'begin' to start simulation.");
	}
}
