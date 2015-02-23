package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.StarPortSimulator;

public class BeginGameAction implements Action {

	@Override
	public void exec(Console c, String[] params) throws Exception {
		StarPortSimulator.getInstance().getCurrentGame().begin();
	}
	
}
