package com.nitk.antivirus;
import java.io.*;
import java.net.*;

import com.nitk.database.tables.uploaded_apk;

public class TCPClient {

	TCPClient(){
				try {
					Process p0 = Runtime.getRuntime().exec("cmd /c  adb start-server ");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	//	while(true)
				 {
				
					try {
						 	   ServerSocket welcomeSocket = new ServerSocket(Constants.clientPort);
						         String sentence;
						         int iApkId=-1;
						     String sApkName;
						    
						     Socket clientSocket = new Socket(Constants.serverIP, Constants.serverPort);
						     DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
						     BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						     sentence = "req";
						
						     outToServer.writeBytes(sentence + '\n');
						     outToServer.flush();
						     outToServer.close();
						     int i=clientSocket.getLocalPort();
						     clientSocket.close();
						     Thread.sleep(1000L);
						     Socket connectionSocket = welcomeSocket.accept();
						      inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
						     
						     outToServer = new DataOutputStream(connectionSocket.getOutputStream());
						     
						     iApkId = Integer.parseInt(inFromServer.readLine());
						     
						     
						     uploaded_apk tdApk=uploaded_apk.getById(iApkId);  	
						     logger.write(iApkId+"");
						     sApkName=tdApk.apk_name;
						     
						     logger.write("FROM SERVER: " + sApkName);
						     //outToServer.writeBytes("This is");
						     
						     
						     int iScanStaus=-1;
						     String sScanReport="...."; 
						     sScanReport=sScanReport+"New File ";
						     //call FtpClient
						    int iCheckStatus=Checker.getCheck(iApkId);
						     //FtpClient ftpClient=new FtpClient(sApkName);
						     if(iCheckStatus==1)
						     		{
						    	 	// call Emulator
						    	 
					    	 		int iFileIndexStart =tdApk.file_path.lastIndexOf("/");
									String sFileName = tdApk.file_path.substring(iFileIndexStart+1);
									String sFilePath = tdApk.file_path.substring(0, iFileIndexStart);
					    	 		iScanStaus=Emulator.startScanning(iApkId,sApkName,sFileName);
									     if(iScanStaus==1)
								        	 sScanReport=sScanReport+"Scanned"; 
								     else
								    	 sScanReport=sScanReport+"Corrupted";
					
						        	  }
						     
						     else 
						        {
						      	 logger.write("is Already Scanned ");
						      	sScanReport=sScanReport +"is Already Scanned ";
						        }
						     
						     sentence = sScanReport;
						     outToServer.writeBytes(EmulatorConstants.iNewApkId+":"+sentence + '\n');
						     outToServer.flush();
						     outToServer.close();
						     welcomeSocket.close();
						     
					 } 
					catch (Exception e) {
					     // TODO Auto-generated catch block
					     e.printStackTrace();
					     logger.write("Client :");
					
					 }
				
					
					
				 }
   }
		
		


 
}