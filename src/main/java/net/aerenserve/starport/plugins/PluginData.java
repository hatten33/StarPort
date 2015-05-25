package net.aerenserve.starport.plugins;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PluginData {
	String name();
	String author();
	String desc();
	String main();
	double currentVersion() default 1.0;
	String versionSuffix() default "";
}
