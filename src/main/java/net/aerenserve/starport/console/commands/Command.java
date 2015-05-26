package net.aerenserve.starport.console.commands;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Command {
	
	NEW(new NewGameAction(), new ArrayList<String>()),
	
	SPAWNTEST(new SpawnTestAction(), new ArrayList<String>()),
	
	BEGIN(new BeginGameAction(), Arrays.asList("start")),
	
	ARRIVALS(new ArrivalsAction(), new ArrayList<String>()),
	
	ENABLE(new EnablePluginAction(), new ArrayList<String>()),
	
	LOAD(new LoadPluginAction(), new ArrayList<String>()),
	
	QUIT(new QuitAction(), Arrays.asList("q","stop","exit"));

	


	public interface Listener {
		public void exception(Exception e);
	}

	private Action action;
	private List<String> alias;

	private Command(Action a, List<String> alias) {
		this.action = a;
		this.alias = alias;
	}

	public void exec(final Console c, final String[] params, final Listener l) {
		try {
			action.exec(c, params);
		} catch (Exception e) {
			l.exception(e);
		}
	}
	
	public static Command getCmd(String commandName) {
		for(Command cmd : values()) {
			if(cmd.toString().equalsIgnoreCase(commandName)) {
				return cmd;
			}
			if(cmd.alias.contains(commandName)) {
				return cmd;
			}
		}
		throw new IllegalArgumentException();
	}
}