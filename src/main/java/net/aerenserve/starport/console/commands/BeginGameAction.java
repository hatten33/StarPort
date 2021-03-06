package net.aerenserve.starport.console.commands;

import java.io.Console;

import net.aerenserve.starport.engine.StarPort;
import net.aerenserve.starport.engine.StarPortSimulator;

public class BeginGameAction implements CommandAction {

	@Override
	public void exec(Console c, String[] params) throws Exception {
		StarPort port = StarPortSimulator.getInstance().getCurrentGame().getStarPort();
		StarPortSimulator.getLogger().info("Creating a new Game with the following StarPort:\n"
				+ "Type: " + port.getType() + "\n"
				+ "Terminals: " + port.getArchitecture().getTerminals().size() + "\n"
				+ "Gates: " + port.getArchitecture().getAllGates().size() + "\n");
		StarPortSimulator.getInstance().getCurrentGame().begin();
	}
	
}
