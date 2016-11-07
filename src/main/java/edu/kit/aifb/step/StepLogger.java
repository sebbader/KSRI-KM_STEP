package edu.kit.aifb.step;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class StepLogger extends Logger{
	
	private static Logger logger;

	protected StepLogger(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static Logger setLogger() {

		try {

			// create the 'logs' folder
			File logs = new File("logs");
			if (!logs.exists()) logs.mkdirs();
			
			// create the logger
			logger = getRootLogger();

			ConsoleAppender consoleAppender = new ConsoleAppender(new PatternLayout());
			logger.addAppender(consoleAppender);

			// construct the log file name
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
			FileAppender fileAppender = new FileAppender(new PatternLayout(), "logs/AdministrationShell_RCX_" + sdf.format(cal.getTime()) );
			logger.addAppender(fileAppender);

			return logger;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}

	public static Logger getLogger() {
		return logger;
	}

}
