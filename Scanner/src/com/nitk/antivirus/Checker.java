package com.nitk.antivirus;
import com.nitk.database.tables.*;
import com.nitk.ftp.Ftp;
import com.nitk.md5.md5;



import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Checker {
	public static int getCheck(int iApkId) throws InterruptedException {
		try {
			//for (downloaded_apk tdApk:downloaded_apk.getData("checked=0")){
					downloaded_apk tdApk = downloaded_apk.getById(iApkId);
				// download file, generate md5 and delete file	
				
				//	Ftp.connectFtp();
					int iFileIndexStart =tdApk.file_path.lastIndexOf("/");
					String sFileName = tdApk.file_path.substring(iFileIndexStart+1);
					String sFilePath = tdApk.file_path.substring(0, iFileIndexStart);
					/*Ftp.getFile(sFileName,Constants.sApkStoreLocation);*/
				//	Ftp.changeWorkingDir(sFilePath);
					
				//	Ftp.getFile(sFileName,Constants.sApkStoreLocation);
					/*int iFileIndexStart =tdApk.file_path.lastIndexOf("/");
					String sFileName = tdApk.file_path.substring(iFileIndexStart+1);
					String sFilePath = tdApk.file_path.substring(0, iFileIndexStart);
					Ftp.getFile(sFileName,Constants.sApkStoreLocation);*/
					Thread.sleep(1000);
				//	Ftp.closeFtp();
					sample.FileDownload(sFilePath, sFileName);
					
					String smd5 = md5.getDigest(Constants.sApkStoreLocation+"/"+sFileName);
					//(new File(Constants.sApkStoreLocation+"/"+sApkName)).delete();
					
					ArrayList<apk_details> apks = apk_details.getData("md5='"+smd5+"'");
					if(apks.size() == 0){	
						// New File
						// insert into apk details
							apk_details tDetails = new apk_details(); 
							tDetails.apk_name = tdApk.apk_name;
							tDetails.file_pointer = tdApk.file_path/*+tdApk.apk_name*/;
							tDetails.first_scan = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
							tDetails.last_scan = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
							tDetails.current_count=1;
							tDetails.last_count=1;
							tDetails.md5 = smd5;
							EmulatorConstants.iNewApkId=apk_details.insert(tDetails);
						
						// update download file as checked		 
							tdApk.checked =1;
							downloaded_apk.update(tdApk);
							return 1;
					  }
					else
					{	// File already there
						apk_details tDetails = apks.get(0);
						tDetails.last_scan=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
						tDetails.current_count=tDetails.current_count+1;
						tDetails.last_count=tDetails.current_count+1;
						apk_details.update(tDetails);
						// Delete entry from downloaded apk
						tdApk.delete(iApkId);
						// Delete from storage
						// 					
					logger.write("File already scanned");
					return 0;
 
					}
				//}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		return 0;
  }
}
