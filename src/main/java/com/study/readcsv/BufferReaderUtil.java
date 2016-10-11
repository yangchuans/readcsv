package com.study.readcsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class BufferReaderUtil {
	
	public static BufferedReader getBufferRead(String filePath,String EnCodeMethod){
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(new File(filePath)),EnCodeMethod);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new BufferedReader(isr,4096);
	}
}
