package net.aerenserve.starport.console;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

import net.aerenserve.starport.console.commands.Command;
import net.aerenserve.starport.engine.StarPortSimulator;

public class ConsoleThread implements Runnable {

	private static final String NO_CONSOLE = "Error: Console unavailable";
	private static final String UNKNOWN_COMMAND = "Unknown command [%1$s]%n";
	private static final String COMMAND_ERROR = "Command error [%1$s]: [%2$s]%n";

	private static final String PROMPT = "\r $ ";

	public void run() {
		Console console = System.console();
		if (console != null) {
			execCommandLoop(console);
		} else {
			throw new RuntimeException(NO_CONSOLE);
		}
	}

	public static void main(String[] args) {

	}

	private static void execCommandLoop(final Console console) {
		while (true) {
			String commandLine = console.readLine(PROMPT, new Date());
			Scanner scanner = new Scanner(commandLine);

			if (scanner.hasNext()) {
				final String commandName = scanner.next().toUpperCase();
				String param = scanner.hasNext() ? scanner.next() : "";
				try {
					final Command cmd = Command.getCmd(commandName);
					cmd.exec(console, new String[] { param },
							new Command.Listener() {
						@Override
						public void exception(Exception e) {
							console.printf(COMMAND_ERROR, cmd,
									e.getMessage());
							e.printStackTrace();
						}
					});
				} catch (IllegalArgumentException e) {
					if(StarPortSimulator.getInstance().getCurrentGame() != null) {
						if(!StarPortSimulator.getInstance().getCurrentGame().getPluginManager().passCommand(commandName, new String[] { param })) {
							console.printf(UNKNOWN_COMMAND, commandName);
						}
					} else console.printf(UNKNOWN_COMMAND, commandName);
				}
			}

			scanner.close();
		}
	}
}
