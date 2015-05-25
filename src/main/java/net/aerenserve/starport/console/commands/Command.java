package net.aerenserve.starport.console.commands;

import java.io.Console;

public enum Command {
	
	NEW(new NewGameAction()),
	
	SPAWNTEST(new SpawnTestAction()),
	
	BEGIN(new BeginGameAction()),
	
	ARRIVALS(new ArrivalsAction()),
	
	ENABLE(new EnablePluginAction()),
	
	LOAD(new LoadPluginAction()),
	
	QUIT(new QuitAction());

	
	

	public interface Listener {
		public void exception(Exception e);
	}

	private Action action;

	private Command(Action a) {
		this.action = a;
	}

	public void exec(final Console c, final String[] params, final Listener l) {
		try {
			action.exec(c, params);
		} catch (Exception e) {
			l.exception(e);
		}
	}
}