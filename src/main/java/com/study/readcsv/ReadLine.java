package com.study.readcsv;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadLine {
	public static void main(String[] args) {
			BufferedReader br = BufferReaderUtil.getBufferRead("/home/yangchuan/桌面/研发部门所有人员.csv","UTF-8");
			String content=null;
			try{
				 while(null!=(content=br.readLine())){
					 	String insertUser="insert ignore into auth_user(cn_name,login_name,mail) VALUES(";
					 	String insertAuth="insert ignore into auth_user_role(user_id,role_id) VALUES(";
						String[] contents = content.split(",");
						if(contents.length==5){
							insertUser+="\""+contents[0]+"\","+"\""+contents[1]+"\",";
							insertUser+="\""+contents[2]+"\");";
							
							String userId="(select id from auth_user where login_name=\""+contents[1]+"\")";
							insertAuth+=userId+",8);";
							
							System.out.println(insertUser);
							System.out.println(insertAuth);
						}
				 }
				 br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
