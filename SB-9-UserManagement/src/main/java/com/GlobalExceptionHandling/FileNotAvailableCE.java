package com.GlobalExceptionHandling;

import java.io.FileNotFoundException;

public class FileNotAvailableCE extends RuntimeException {

	//public static String msg;

	public FileNotAvailableCE(String str) {
		super(str);
//		msg = str;
	}

}
