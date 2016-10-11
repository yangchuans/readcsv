package com.study.readcsv;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadTable {
	
	public static void main(String[] args) {
		BufferedReader br = BufferReaderUtil.getBufferRead("/home/yangchuan/桌面/全流程发布平台菜单与url.csv","GBK");
		String content=null;
		try {
			while(null!=(content=br.readLine())){
				String [] online = content.split(",");
				for(int i=0;i<online.length;i++){
					String item  =online[i];
					System.out.println(item);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
