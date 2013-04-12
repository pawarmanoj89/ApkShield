package com.nitk.antivirus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InstallAntiviruses {

	/**
	 * @param args
	 */
	
	static String sAntivirusSource="D:/ApkShied/antivirus";
	static String sLookoutSource="Lookout_Mobile_Security_6.2.apk";
	static String sBitdefenderSource="com.bitdefender.security.apk";
	static String sQuickhealSource="Mobsec.apk";
	static String sNetquinSource="NetQin_P2115_AV_android2.0_V5.2.16.02_20110927.apk";
	static String sWebrootSource="com.webroot.security_v2.2.1.1046.apk";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.write("Hi");
		String s=null;
		BufferedReader stdInput;
		  BufferedReader stdError;
		try {
			Process p0 = Runtime.getRuntime().exec("cmd /c  adb start-server ");
			Process p = Runtime.getRuntime().exec("cmd /c  adb install "+sAntivirusSource+"/"+sLookoutSource);
			 
				stdInput = new BufferedReader(new 
			        InputStreamReader(p.getInputStream()));
			   stdError = new BufferedReader(new 
			        InputStreamReader(p.getErrorStream()));

			  // read the output from the command
			 logger.write("Here is the standard output of the command:\n");
			 while ((s = stdInput.readLine()) != null) {
			       logger.write(s);
			   }
			   
			   // read any errors from the attempted command
			   logger.write("Here is the standard error of the command (if any):\n");
			   while ((s = stdError.readLine()) != null) {
			       logger.write(s);
			   }
			  

			
			Process p2 = Runtime.getRuntime().exec("cmd /c  adb install "+sAntivirusSource+"/"+sBitdefenderSource);
			stdInput = new BufferedReader(new 
			        InputStreamReader(p2.getInputStream()));
			   stdError = new BufferedReader(new 
			        InputStreamReader(p2.getErrorStream()));

			  // read the output from the command
			 logger.write("Here is the standard output of the command:\n");
			 while ((s = stdInput.readLine()) != null) {
			       logger.write(s);
			   }
			   
			   // read any errors from the attempted command
			   logger.write("Here is the standard error of the command (if any):\n");
			   while ((s = stdError.readLine()) != null) {
			       logger.write(s);
			   }

			Process p3 = Runtime.getRuntime().exec("cmd /c  adb install "+sAntivirusSource+"/"+sQuickhealSource);
			stdInput = new BufferedReader(new 
			        InputStreamReader(p3.getInputStream()));
			   stdError = new BufferedReader(new 
			        InputStreamReader(p3.getErrorStream()));

			  // read the output from the command
			 logger.write("Here is the standard output of the command:\n");
			 while ((s = stdInput.readLine()) != null) {
			       logger.write(s);
			   }
			   
			   // read any errors from the attempted command
			   logger.write("Here is the standard error of the command (if any):\n");
			   while ((s = stdError.readLine()) != null) {
			       logger.write(s);
			   }

			Process p4 = Runtime.getRuntime().exec("cmd /c  adb install "+sAntivirusSource+"/"+sNetquinSource);
			stdInput = new BufferedReader(new 
			        InputStreamReader(p4.getInputStream()));
			   stdError = new BufferedReader(new 
			        InputStreamReader(p4.getErrorStream()));

			  // read the output from the command
			 logger.write("Here is the standard output of the command:\n");
			 while ((s = stdInput.readLine()) != null) {
			       logger.write(s);
			   }
			   
			   // read any errors from the attempted command
			   logger.write("Here is the standard error of the command (if any):\n");
			   while ((s = stdError.readLine()) != null) {
			       logger.write(s);
			   }

			Process p5 = Runtime.getRuntime().exec("cmd /c  adb install "+sAntivirusSource+"/"+sWebrootSource);
			stdInput = new BufferedReader(new 
			        InputStreamReader(p5.getInputStream()));
			   stdError = new BufferedReader(new 
			        InputStreamReader(p5.getErrorStream()));

			  // read the output from the command
			 logger.write("Here is the standard output of the command:\n");
			 while ((s = stdInput.readLine()) != null) {
			       logger.write(s);
			   }
			   
			   // read any errors from the attempted command
			   logger.write("Here is the standard error of the command (if any):\n");
			   while ((s = stdError.readLine()) != null) {
			       logger.write(s);
			   }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
