package com.readcsv.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FiledTest {
	public static void main(String[] args) {
	     	InputStreamReader isr = null;
			try {
				isr = new InputStreamReader(new FileInputStream(new File("/home/yangchuan/桌面/研发部门所有人员.csv")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(isr,4096);
			String content = null;
			try{
				 while((content=br.readLine())!=null){
					 	String insertUser="insert ignore into auth_user(cn_name,login_name,mail) VALUES(";
					 	String insertAuth="insert ignore into auth_user_role(user_id,role_id) VALUES(";
						String[] contents = content.split(",");
						if(null!= contents && contents.length==5 && "折800系统开发部".equals(contents[4])){
							insertUser+="\""+contents[0]+"\","+"\""+contents[1]+"\",";
							insertUser+="\""+contents[2]+"\");";
							
							String userId="(select id from auth_user where login_name=\""+contents[1]+"\")";
							insertAuth+=userId+",8);";
							System.out.println(insertUser);
							System.out.println(insertAuth);
						}
				 }
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
