package com.nitk.antivirus;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nitk.database.tables.apk_details;
import com.nitk.database.tables.report_master;


public class AntivirusReport {
		
	
	    static String sPackageName=null;
	    	
	    static String sLookoutReport=null;
	    static String sBitdefenderReport=null;
	    static String sWebrootReport=null;
	    static String sNetqinReport=null;
	    static String sQuickhealReport=null;
	    static int iScanStatus=0;

		
	    
		static void generateAntivirusReport(int iApkId,String sPackageName){
			
						try {
							sLookoutReport=lookout(EmulatorConstants.sReportFolder+"/"+EmulatorConstants.sLookoutLogDestination);
							sBitdefenderReport=bitdefender(EmulatorConstants.sReportFolder+"/"+EmulatorConstants.sBitdefenderLogDestination);
							sWebrootReport=webroot(EmulatorConstants.sReportFolder+"/"+EmulatorConstants.sWebrootLogDestination);
							sNetqinReport=netqin(EmulatorConstants.sReportFolder+"/"+EmulatorConstants.sNetqinLogDestination);
							sQuickhealReport=quickheal(EmulatorConstants.sReportFolder+"/"+EmulatorConstants.sQuickhealLogDestination);
							logger.write("[[[[[[[[[[[[[]]]]]]]]]]]]]]");
							logger.write(sLookoutReport+" "+sBitdefenderReport+" "+sWebrootReport+" "+sNetqinReport+" "+sQuickhealReport);
							
							insertReportMaster(EmulatorConstants.iNewApkId,1,sLookoutReport);
							insertReportMaster(EmulatorConstants.iNewApkId,2,sBitdefenderReport);
							insertReportMaster(EmulatorConstants.iNewApkId,3,sWebrootReport);
							insertReportMaster(EmulatorConstants.iNewApkId,4,sNetqinReport);
							insertReportMaster(EmulatorConstants.iNewApkId,5,sQuickhealReport);
							
							// Update apk_details's ScanStatus 
							apk_details tDetails=apk_details.getById((int) EmulatorConstants.iNewApkId);
							tDetails.scan_status=iScanStatus;
							apk_details.update(tDetails);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
		}

		
		
		
		private static void insertReportMaster(long iApkId,int iAntivirusId,String sReport) {
			// TODO Auto-generated method stub
			report_master tMaster=new report_master();
			tMaster.apk_id=(int) iApkId;
			tMaster.antivirus_id=iAntivirusId;
			tMaster.report=sReport;
			if(sReport.matches("Safe")) 
				tMaster.result=0;
			else 
				{
				tMaster.result=1;
				iScanStatus=iScanStatus+1;
				}
						
			report_master.insert(tMaster);
		}

		
		public static String lookout(String sFilepath) throws IOException
		{
			
			FileInputStream fstream = new FileInputStream(sFilepath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//Read File Line By Line
			String strLine=br.readLine();

			if(strLine==null)
				{	
					logger.write("Lookout :- Safe");
					return "Safe";
				}
			else
				{
				 logger.write("Lookout:- malicious");
				 return "Infected";
				}
			

			
		}

		
		


		public static String bitdefender(String sFilepath) throws IOException
		{
			FileInputStream fstream = new FileInputStream(sFilepath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//Read File Line By Line
			String strLine=br.readLine();

			if(strLine==null)
				{
					logger.write("Bitdefender:- Unknown");
					return "Safe";
				}
			
			else
				 {
						// Print the content on the console
						String sApplication=strLine.substring(strLine.indexOf("Application ")+12, strLine.indexOf("was")-1);
						logger.write ("Bitdefender App Name-"+sApplication);
			
						String sStatus=strLine.substring(strLine.indexOf("and found ")+10, strLine.length());
						logger.write ("Bitdefender Status-"+sStatus);
						if(sStatus.equalsIgnoreCase("clean"))
							return "Safe";
							
						else
							return "Infected";
			
				}
			
		}


		public static String webroot(String sFilepath) throws IOException
		{
			FileInputStream fstream = new FileInputStream(sFilepath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine=br.readLine();

			//Read File Line By Line
			if(strLine==null)
				{
					logger.write("Webroot:- Clean");
					return "Safe";
				}
			else
			 {
				// Print the content on the console
				logger.write("Webroot:- Infected");
				return "Infected";
			}
			
		}

		
		
		
		
		public static String netqin(String sFilepath) throws Exception
		{
			
			FileInputStream fstream = new FileInputStream(sFilepath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//Read File Line By Line
			String strLine=br.readLine();

			if(strLine==null)
				{
					logger.write("Netqin :- Safe");
					return "Safe";
				}
			else
			{
				logger.write("Netqin:- malicious");
				return "Infected";
			}

		}
			
		
		public static String quickheal(String sDB) throws Exception
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:"+sDB);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select count(*) from VirusProtectionReports;");
			rs.next();
			int currentcount=rs.getInt(1);
			rs.close();


			File f=new File(EmulatorConstants.sReportFolder+"/Quickheal.txt");

			DataInputStream in = new DataInputStream(new FileInputStream(f));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine=br.readLine();
			int count=0;
			Writer output = null;
			if(strLine==null)
				{ 
	                             count=0;
					output = new BufferedWriter(new FileWriter(f));
		
				output.write(""+count);

					
	                         } 
			count=Integer.parseInt(strLine);
			br.close();

			if(currentcount!=count)
			{
				
				f.delete();
				
				f.createNewFile();
				//f=new File(EmulatorConstants.sQuickhealCount+"Quickheal.txt");
				output = new BufferedWriter(new FileWriter(f));
				String Count=""+currentcount;
				output.write(Count);


				output.close();
				conn.close();
				return "Infected";
			}
			else
			{
				System.out.print("quickheal Safe");
				conn.close();
				return "Safe";
			}
			
		}
		
		
		
		
		

//		public static String quickheal(String sDB) throws Exception
//		{
//			Class.forName("org.sqlite.JDBC");
//			Connection conn= DriverManager.getConnection("jdbc:sqlite:"+sDB);
//			Statement stat = conn.createStatement();
//
//			ResultSet rs = stat.executeQuery("select * from VirusProtectionReports;");
//
//			while (rs.next()) {
//				logger.write("Type " + rs.getString("virus"));
//				logger.write("Name = " + (rs.getString("location")).substring(14,(rs.getString("location")).indexOf(".apk")));
//				// 13 as /data/app/com.
//			}
//			rs.close();
//			conn.close();
//			return null;
//
//		}
		
	}
