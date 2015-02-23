package net.aerenserve.starport.console.commands;

import java.io.Console;

public interface Action {
	public void exec(Console c, String[] params) throws Exception;
}
