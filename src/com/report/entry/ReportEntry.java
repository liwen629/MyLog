package com.report.entry;

import com.report.base.IFile;
import com.report.html.HtmlFile;
import com.report.ini.IniFile;
import com.report.log.LogFile;
import com.report.properties.PropertiesFile;
import com.report.txt.TxtFile;


public class ReportEntry {
	
	IFile myFile;
	String fileName;

	
	
	public void crateLog(String p_file){
		if (p_file.endsWith(".ini"))
			 myFile =new IniFile();
		else if (p_file.endsWith(".properties"))
			 myFile =new PropertiesFile();
		else if (p_file.endsWith(".html")) 	
			 myFile =new HtmlFile();
		else if (p_file.endsWith(".txt"))
			 myFile =new TxtFile();
		else if (p_file.endsWith(".log"))
			 myFile =new LogFile();
		else 
			myFile=null;	
		
		if (myFile!=null){
			myFile.createLog(p_file);
		}
			
		else
		{
			System.out.println("不支持的文件类型");
			System.exit(0);
		}
	}
	
	public void closeLog(){
		myFile.closeLog();
	}
	
	public void write(String p_info){
		myFile.write(p_info);
	}

	
	public void write(String p_info1,String p_info2){
		myFile.write(p_info1,p_info2);
	}
	
	public void write(String p_info1,String p_info2,String p_info3){
		myFile.write(p_info1,p_info2,p_info3);
	}
	
	public void write(String p_info1,boolean p_info2,boolean p_info3){
		myFile.write(p_info1,p_info2,p_info3);
	}
	
	public String read(String p_key){
		return myFile.read(p_key).toString();
	}
	
	public String read(String p_section,String p_key){
		return myFile.read(p_section,p_key);
	}
	
	

}
