package net.aerenserve.starport.console;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class StarportLogFormatter extends Formatter {

	public String format(LogRecord rec) {
		StringBuilder sb = new StringBuilder();
		sb.append("\r[" + getCurrentTimeStamp() + "] ");
		sb.append("[" + rec.getLevel().toString() + "] ");
		sb.append(rec.getMessage());
		sb.append("\r\n $ ");
		return sb.toString();
	}
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}
