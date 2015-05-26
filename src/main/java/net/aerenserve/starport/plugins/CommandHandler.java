package net.aerenserve.starport.plugins;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Proper command method is as follows:
 * 
 * @CommandHandler(name="testcommand", aliases={"test", "t"})
 * public boolean testCommand(String command, String[] args, Game game) {
 * 		//Logic here
 * }
 * 
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandHandler {
	String name();
	String[] aliases() default {};
}
