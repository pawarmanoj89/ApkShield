package com.nitk.antivirus;
import java.io.*;
import java.net.*;

import com.nitk.database.tables.downloaded_apk;

public class TCPClient {

	TCPClient() throws IOException{
				try {
					Process p0 = Runtime.getRuntime().exec("cmd /c  adb start-server ");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ServerSocket welcomeSocket=null;
			while(true)
				 {
				
					try {
						 	   welcomeSocket = new ServerSocket(Constants.clientPort);
						         String sentence;
						         int iApkId=-1;
						     String sApkName;
						    
						     Socket clientSocket = new Socket(Constants.serverIP, Constants.serverPort);
						     DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
						     BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						     sentence = "req";
						
						     outToServer.writeBytes(sentence + '\n');
						     int i=clientSocket.getLocalPort();
						     clientSocket.close();
						     Thread.sleep(1000L);
						     Socket connectionSocket = welcomeSocket.accept();
						      inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
						     
						     outToServer = new DataOutputStream(connectionSocket.getOutputStream());
						
						     iApkId = Integer.parseInt(inFromServer.readLine());
						     
						     downloaded_apk tdApk=downloaded_apk.getById(iApkId);  				     
						     sApkName=tdApk.apk_name;
						     String sApkPath=tdApk.file_path;
						     
						     logger.write("FROM SERVER: " + sApkName+"  --" +sApkPath);
						     int iScanStaus=-1;
						     String sScanReport=""; 
						     //call FtpClient
						    int iCheckStatus= Checker.getCheck(iApkId);
						     //FtpClient ftpClient=new FtpClient(sApkName);
						     if(iCheckStatus==1)
						     		{
						    	 	// call Emulator
						    	 		sScanReport=sScanReport+"New File ";
						    	 		int iFileIndexStart =tdApk.file_path.lastIndexOf("/");
										String sFileName = tdApk.file_path.substring(iFileIndexStart+1);
										String sFilePath = tdApk.file_path.substring(0, iFileIndexStart);
						    	 		iScanStaus=Emulator.startScanning(iApkId,sApkName,sFileName);
									     if(iScanStaus==1)
								        	 sScanReport=sScanReport+"is Scanned "; 
								     else
								    	 sScanReport=sScanReport+"is Curupted ";
					
						        	  }
						     
						     else 
						      	 sScanReport=sScanReport+"is Already Scanned ";
						     logger.write("~~~~~~~~~~~~~~");
						     sentence = sScanReport;
						     outToServer.writeBytes(sentence + '\n');
						
						     welcomeSocket.close();
						     
					 } catch (Exception e) {
					     // TODO Auto-generated catch block
					     e.printStackTrace();
					     logger.write("Client :");
					     welcomeSocket.close();
					     break; 
					 }
				
					
					
				 }
   }
		
		


 
}