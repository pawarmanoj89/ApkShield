package com.nitk.antivirus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

import org.apache.commons.net.ftp.FTP;

public class sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		/*// TODO Auto-generated method stub
		String s = "/home/ftp-dir/ftp-upload/www.android-themes.com/11-01-2012/MyLauncher2012-01-11 17-12-57-605.apk";
		int iFileIndexStart =s.lastIndexOf("/");
		String sFileName = s.substring(iFileIndexStart+1);
		String sFilePath = s.substring(0, iFileIndexStart);
			logger.write(sFileName+"\n");	
			String sFullPath = "/home/ftp-dir/ftp-upload/www.android-themes.com/11-01-2012";
			String sFileName =  "SPBShell3D5.02012-01-11 17-30-14-983.apk";
			FileDownload(sFullPath, sFileName);*/
		String sFilePath=Constants.sApkStoreLocation+"/Love2012-01-11 17-33-17-294.apk";
		//sFileName = sFileName.replace(" ", "/");
		//System.out.print(sFileName);
		String sPackageName=getPackageNameUsingAAPT(sFilePath);
		System.out.print(sPackageName);
		
				
			
			
	}

	public static String getPackageNameUsingAAPT(String sFilePath)
			throws IOException {
		String sPackageName="";
		sFilePath = "\""+sFilePath+"\"";
		Process processUninstall = Runtime.getRuntime().exec("cmd /c aapt dump badging "+sFilePath);

		BufferedReader stdInput1 = new BufferedReader(new 
		InputStreamReader(processUninstall.getInputStream()));

		BufferedReader stdError1 = new BufferedReader(new 
		InputStreamReader(processUninstall.getErrorStream()));
		String s=null;
		 while ((s = stdInput1.readLine()) != null) {
		       if(s.contains("package: name='"))
		       {
		    	   int iStartIndex = s.indexOf("package: name='")+15;
		    	   int iEndIndex = s.indexOf("'", iStartIndex);
		    	   sPackageName = s.substring(iStartIndex,iEndIndex);
		    	   return sPackageName;
		       }
		      
		         }
		 return sPackageName;
	}

	public static void FileDownload(String sFullPath, String sFileName)
			{
		try {
			FTPClient ftp = new FTPClient();
			ftp.connect(Constants.sFtpServerIP);
			ftp.login(Constants.sFtpUserName,Constants.sFtpPassword);
			
			
			ftp.changeDirectory(sFullPath);
			ftp.setType(FTP.BINARY_FILE_TYPE);
			ftp.download(sFileName, new java.io.File(Constants.sApkStoreLocation+"\\"+sFileName));
			ftp.disconnect(true);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPIllegalReplyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPDataTransferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FTPAbortedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
