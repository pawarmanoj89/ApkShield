package com.nitk.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.nitk.antivirus.logger;

/**
 * Class Name    : MD5
 * Date          : Nov 7, 2011 4:07:51 PM
 * Description   : Contents the functions to generate the MD5 message digest
 *  			 
 * 
 */
public class md5 {
	static InputStream instream;


	/** Function Name: getDigest
	 * 	this function is used to to get MD5 from file url
	 * @param 
	 * 
	 * @return MD5 output in String format
	 * 
	 */

	public static String getDigest(String url) throws NoSuchAlgorithmException
	{
		logger.write(">>> getDigest Begin <<<");

		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			File file = new File(url);
			instream = new FileInputStream(file);               
			byte[] buffer = new byte[8192];
			int read = 0;

			while( (read = instream.read(buffer)) > 0) {
				digest.update(buffer, 0, read);
			}       

			byte[] md5sum = digest.digest();
			BigInteger bigInt = new BigInteger(1, md5sum);
			String output = bigInt.toString(16);
			logger.write("MD5: " + output);
			logger.write (">>> getDigest Completed <<<");
			return output;
		}
		catch(IOException e) {
			throw new RuntimeException("Unable to process file for MD5", e);
		}
		finally {
			try {
				instream.close();
			}
			catch(IOException e) {
				throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
			}
		} 
	}
}
