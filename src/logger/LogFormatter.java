/**
 * 
 */
package logger;

//imports 
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.*;

/**
 * 
 * <h1>LogFormatter</h1> 
 * <p>Create a custom Log logging Formatter to show the entries
 * in a CSV file with 3 columns: level, time-stamp, source module and message.</p>
 *
 * @author RoahnKumar Feb 15, 2016 2016 LogFormat.java
 */
public class LogFormatter extends Formatter {

	/**
	 * systemTime - indicates time of system, in our case garden management
	 * system, it may be fire management system
	 */
	private String systemTime;
	/**
	 * systemTime - indicates day of system, in our case garden management
	 * system, it may be fire management system
	 */
	private String day;

	/**
	 * Default Constructor: This method initialize default variables
	 */
	public LogFormatter() {
		// TODO Auto-generated constructor stub
		systemTime = "0:0";
		day ="0";
	}

	/*
	 * <h1>format</h1> This custom log method which is called when ever log
	 * records need to published. This methods return message in string format
	 * <p>
	 * 
	 * @param record it is object of type java.util.LogRecord
	 * 
	 * @return Log record in the form of String
	 * 
	 */
	@Override
	public String format(LogRecord record) {

		StringBuilder formartRecord = new StringBuilder();
		formartRecord.append("\n");
		formartRecord.append(record.getLevel());
		formartRecord.append(",");
		formartRecord.append(fomatDate(record.getMillis()));
		formartRecord.append(",");
		formartRecord.append(record.getSourceClassName());
		formartRecord.append(",");
		try {
			String[] message = record.getMessage().split(":");
			formartRecord.append(message[0]);
			formartRecord.append(",");
			formartRecord.append(message[1]);
		} catch (Exception ex) {
			System.err.println("Type of log is not found like interaction, system, Randomness");
			formartRecord.append(record.getMessage());
		}
		formartRecord.append(",");
		formartRecord.append(day);
		formartRecord.append(",");
		formartRecord.append(systemTime);
		return formartRecord.toString();
	}

	/*
	 * This method converts given time in Milli sec to a Format which is
	 * required foe log
	 */

	private String fomatDate(long milisec) {
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-yy HH:mm:ss");
		Date recordDate = new Date(milisec);
		return date.format(recordDate);
	}

	/**
	 * @return the systemTime
	 */
	public String getSystemTime() {
		return systemTime;
	}

	/**
	 * @param systemTime
	 *            the systemTime to set
	 */
	public void setSystemTime(String systemTime) {
		this.systemTime = systemTime;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
}
