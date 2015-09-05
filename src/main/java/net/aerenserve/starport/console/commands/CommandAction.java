package net.aerenserve.starport.console.commands;

import java.io.Console;

public interface CommandAction {
	public void exec(Console c, String[] params) throws Exception;
}
