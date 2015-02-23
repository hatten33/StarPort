package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.StarPortSimulator;

public class SpawnTestAction implements Action {

	@Override
	public void exec(Console c, String[] params) throws Exception {
        int amount = 1;
        try {
            amount = Integer.parseInt(params[0]);
        } catch (NumberFormatException e) { /* ignore */ }

		StarPortSimulator.getInstance().getCurrentGame().createFlights(amount);
	}

	
}
