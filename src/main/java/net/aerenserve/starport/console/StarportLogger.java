package net.aerenserve.starport.console;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StarportLogger {

	static private FileHandler fileTxt;
	static private ConsoleHandler consoleHandler;
	static private Formatter nexusFormatter;

	static public Logger setup() throws IOException {
		Logger logger = Logger.getLogger("StarPort");
		logger.setLevel(Level.INFO);
		
		nexusFormatter = new StarportLogFormatter();
		
		fileTxt = new FileHandler("log.txt");
		fileTxt.setFormatter(nexusFormatter);
		fileTxt.setLevel(Level.FINEST);
		
		consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(nexusFormatter);
		consoleHandler.setLevel(Level.FINEST);
			
		logger.addHandler(fileTxt);
		logger.addHandler(consoleHandler);
		
		return logger;
	}

}

