package com.nitk.antivirus;

import java.io.IOException;

public class Tester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Emulator emulator=new Emulator(".apk");
		//Emulator emulator=new Emulator(0, "blue1.apk");
		String s="Safe1";
		if(s.matches("Safe"))
			logger.write("Safe");
		else
			logger.write("Infected");
	}

}
