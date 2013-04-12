package com.nitk.antivirus;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nitk.database.tables.apk_details;
import com.nitk.database.tables.downloaded_apk;

public class Emulator {

	static AntivirusReport antivirusReport;
	static String s=null;
	static String sError=null;
			    
	
	    
	    
	    public static int startScanning(int iApkId,String sApplicationName,String sApplicationFilename) throws IOException {
	    	EmulatorConstants.iApkId=iApkId;
	    	EmulatorConstants.sApplicationName=sApplicationName;
	    	Thread tThreadLog=new Thread();
	    	// Clearing all Logs

	    	
	    	clearLog(EmulatorConstants.sLookoutLogSource, EmulatorConstants.sLookoutLogFile);
	        clearLog(EmulatorConstants.sBitdefenderLogSource, EmulatorConstants.sBitdefenderLogFile);
	        clearLog(EmulatorConstants.sWebrootLogSource, EmulatorConstants.sWebrootLogFile);
	        clearLog(EmulatorConstants.sNetqinLogSource,EmulatorConstants.sNetqinLogFile);

	    	int iInsatllReport=install(EmulatorConstants.sApplicationName,sApplicationFilename);
	    	logger.write("IInstallReport "+iInsatllReport);
	        if(iInsatllReport==1)		// Install successfully
	        {
				    	
				    	
				        try {
							tThreadLog.sleep(60000);		// Wait until log generated
							
						   }
				        catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
					    
					        
				        // Copy all Log files to LogDestination
					   loggenerator(EmulatorConstants.sBitdefenderLogSource,EmulatorConstants.sBitdefenderLogDestination);
				       loggenerator(EmulatorConstants.sLookoutLogSource,EmulatorConstants.sLookoutLogDestination);
				       loggenerator(EmulatorConstants.sQuickhealLogSource,EmulatorConstants.sQuickhealLogDestination);
				       loggenerator(EmulatorConstants.sNetqinLogSource,EmulatorConstants.sNetqinLogDestination);
				       loggenerator(EmulatorConstants.sWebrootLogSource,EmulatorConstants.sWebrootLogDestination);
						    	
				       logger.write("Main App name "+EmulatorConstants.sApplicationName);

				      /* // Check package name by comparing its application name
				       EmulatorConstants.sPackageName=packageNameByApplication(EmulatorConstants.sApplicationName);
				       if(EmulatorConstants.sPackageName==null)		// no match Found
				       {	logger.write("Main/// App "+EmulatorConstants.sApplicationName+" Package name "+EmulatorConstants.sPackageName);
				       		EmulatorConstants.sPackageName=getPackageName();		// get random package name
				    	   logger.write("Main////// App "+EmulatorConstants.sApplicationName+" Package name "+EmulatorConstants.sPackageName);
				       }
						logger.write(EmulatorConstants.sPackageName);
						*/
				       EmulatorConstants.sPackageName = sample.getPackageNameUsingAAPT(Constants.sApkStoreLocation+"/"+sApplicationFilename);
						// call to generate reports from log
						 AntivirusReport.generateAntivirusReport(EmulatorConstants.iApkId,EmulatorConstants.sPackageName);
						     
				    	
				    	logger.write("in main "+EmulatorConstants.sApplicationName);
				    	// uninstall package
				        uninstall(EmulatorConstants.sPackageName);
				        
				    

				      return 1;  
				        
	        }
	        
	        // Else ----- File Corrupted
	        else{
	        		apk_details.delete((int) EmulatorConstants.iNewApkId);
	        		downloaded_apk.delete(iApkId);
	        		return 0;
	        }
	    }

		public static int install(String sApplicationName,String sApplicationFilename){
			String sOutput=" ";
			
				try {
					         
						    // run the Unix "ps -ef" command
			    					logger.write("cmd /c  adb install \""+EmulatorConstants.sApplicationSource+"/"+sApplicationFilename+"\"");
						          Process p = Runtime.getRuntime().exec("cmd /c  adb install \""+EmulatorConstants.sApplicationSource+"/"+sApplicationFilename+"\"");
						       	
						          BufferedReader stdInput = new BufferedReader(new 
						                 InputStreamReader(p.getInputStream()));
						           BufferedReader stdError = new BufferedReader(new 
						                 InputStreamReader(p.getErrorStream()));
			
						           // read the output from the command
						          logger.write("Here is the standard output of the command:\n");
						          while ((s = stdInput.readLine()) != null) {
						                logger.write(s);
						                sOutput=sOutput+s;
						            }
						            
						            // read any errors from the attempted command
						            logger.write("Here is the standard error of the command (if any):\n");
						            while ((sError = stdError.readLine()) != null) {
						                logger.write("Error Code "+sError);
						                
						            }
						           
						            if(sOutput.contains("Success"))
						            {
						            	return 1;
						            }
						
			
			        }
			
			        catch (IOException e) {
			            logger.write("exception happened - here's what I know: ");
			            e.printStackTrace();
			            System.exit(-1);
			       }
			return 0;
			
			
			
			        

		}

	public static void loggenerator(String sSource,String sDestination ){

    
		  try{
	      	
		  		    logger.write("cmd /c  adb pull "+sSource+" "+EmulatorConstants.sLogDestination+"/"+sDestination);
			        Process processLog = Runtime.getRuntime().exec("cmd /c  adb pull "+sSource+" "+EmulatorConstants.sLogDestination+"/"+sDestination );
			    	
			        BufferedReader stdInput1 = new BufferedReader(new 
			             InputStreamReader(processLog.getInputStream()));
	
			        BufferedReader stdError1 = new BufferedReader(new 
			             InputStreamReader(processLog.getErrorStream()));
	
			        // read the output from the command
			        logger.write("Here is the standard output of the command:\n");
			        while ((s = stdInput1.readLine()) != null) {
			            logger.write(s);
			        	}
			        
			        // read any errors from the attempted command
			        logger.write("Here is the standard error of the command (if any):\n");
			        while ((s = stdError1.readLine()) != null) {
			            logger.write(s);
			        	}
			        
			        
			        
		  }

		  catch (IOException e) {
		            logger.write("exception happened - here's what I know: ");
		            e.printStackTrace();
		            System.exit(-1);
		     }
	}



	public static void clearLog(String sSource,String sDestination ){

	    
		  try{
	    	
	    	
					  	logger.write("cmd /c  adb push "+EmulatorConstants.sEmptyLogDestination+"/"+sDestination+" "+sSource );
				        Process processLog = Runtime.getRuntime().exec("cmd /c  adb push "+EmulatorConstants.sEmptyLogDestination+"/"+sDestination+" "+sSource );
				    	
				        BufferedReader stdInput1 = new BufferedReader(new 
				             InputStreamReader(processLog.getInputStream()));
		
				        BufferedReader stdError1 = new BufferedReader(new 
				             InputStreamReader(processLog.getErrorStream()));
		
				        // read the output from the command
				        logger.write("Here is the standard output of the command:\n");
				        while ((s = stdInput1.readLine()) != null) {
				            logger.write(s);
				        }
				        
				        // read any errors from the attempted command
				        logger.write("Here is the standard error of the command (if any):\n");
				        while ((s = stdError1.readLine()) != null) {
				            logger.write(s);
				        }
				        
				        
		        
		  }

        catch (IOException e) {
		            logger.write("exception happened - here's what I know: ");
		            e.printStackTrace();
		            System.exit(-1);
	        }

	}








	public static void uninstall(String sPackageName){
		
			String sPackageList=null;
				
		  
		  
				logger.write("Uninstall "+sPackageName);
				
				try {
							Process processUninstall = Runtime.getRuntime().exec("cmd /c  adb uninstall "+ sPackageName);
							BufferedReader stdInput1 = new BufferedReader(new 
							InputStreamReader(processUninstall.getInputStream()));
		
							BufferedReader stdError1 = new BufferedReader(new 
							InputStreamReader(processUninstall.getErrorStream()));
		
						        // read the output from the command
						    logger.write("Here is the standard output of the command:\n");
						  
						     while ((s = stdInput1.readLine()) != null) {
						       //logger.write(s);
						       sPackageList=sPackageList+s;
					             }

					}
					catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
			}
		



	public static String getPackageName() throws IOException
			{
					  			
				logger.write("Inside getPackage --"+EmulatorConstants.sLogDestination+"/currentPackages.xml");
				FileInputStream fstream = new FileInputStream(EmulatorConstants.sLogDestination+"/currentPackages.xml");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
			
					//Read File Line By Line
						while ((strLine = br.readLine()) != null) {
							// Print the content on the console
								
								if(strLine.contains("package name"))
								{
									int iStart=strLine.indexOf("\"")+1;
									int iEnd=strLine.indexOf("\"",iStart);
							
					
									//logger.write(strLine.substring(iStart, iEnd));
									if(! EmulatorConstants.sStanderedPackageList.toLowerCase().contains(strLine.substring(iStart, iEnd)))
									{
										return strLine.substring(iStart, iEnd);
									}
									
								}
							
							
						}
				in.close();
				
				return null;
			 }
			
			
			
			
			public static String packageNameByApplication(String sApplicationNameLocal) throws IOException
			{
				
				
				try{
					logger.write("cmd /c  adb pull data/system/packages.xml "+EmulatorConstants.sLogDestination+"/currentPackages.xml" );
				  	Process processUninstall = Runtime.getRuntime().exec("cmd /c  adb pull data/system/packages.xml "+EmulatorConstants.sLogDestination+"/currentPackages.xml" );
			    	}

				catch (IOException e) {
		            logger.write("exception happened - here's what I know: ");
		            e.printStackTrace();
		            System.exit(-1);
					}
	
					
					FileInputStream fstream = new FileInputStream(EmulatorConstants.sLogDestination+"/currentPackages.xml");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine;
				//	sApplicationNameLocal=sApplicationNameLocal.substring(0, sApplicationNameLocal.length()-4);
					if(sApplicationNameLocal.length()>5)
					{sApplicationNameLocal=sApplicationNameLocal.substring(0, 4);}
					
				
				//Read File Line By Line
			   while ((strLine = br.readLine()) != null) {
							// Print the content on the console
						
							if(strLine.contains("package name") && strLine.toLowerCase().contains(sApplicationNameLocal.toLowerCase()))
							{
									int iStart=strLine.indexOf("\"")+1;
									int iEnd=strLine.indexOf("\"",iStart);
					
									if(!EmulatorConstants.sStanderedPackageList.contains(strLine.substring(iStart, iEnd)))
								       {
											return strLine.substring(iStart, iEnd);
								       }
							}
						
			
			   		}
				return null;
			
			
			}
			
			

			
	}

