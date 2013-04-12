package com.nitk.antivirus;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class logger {

	public static void write(String text)
	{
		BufferedWriter output = null;
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = sd.format(new java.util.Date());
	    File file = new File("F://ApkShield/LogFiles/UploadLogFile "+currentDate+".txt");
	    String strDirectory="F:/ApkShield/LogFiles";
	  
	  try {
		  boolean success = (new File(strDirectory)).mkdir();
		
		 
		  output = new BufferedWriter(new FileWriter(file, true));
		  output.write("\r\n"+Calendar.getInstance().getTime()+"\r\n");
		  output.write(text);
		  logger.write(text);
		 
		  output.close();
				  
					
	   } catch (IOException e) {
		// TODO Auto-generated catch block
//		logger.write(e+"");
//		logger.write("Failed to create Log file");
	}
	}
}

/*logger.write(e+"");
logger.write("Check Log File's Problem:Check DB Server Is working or not");*/