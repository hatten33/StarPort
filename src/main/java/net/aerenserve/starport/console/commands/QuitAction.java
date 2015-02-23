package net.aerenserve.starport.console.commands;

import java.io.Console;

public class QuitAction implements Action {

	@Override
	public void exec(Console c, String[] params) {
		c.printf("Bye%n");
		System.exit(0);
	}
}
