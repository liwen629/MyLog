package com.report.html;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.report.base.IFile;

//import java.util.logging.SimpleFormatter;

public class HtmlFile  implements IFile{


   private Logger logger = Logger.getLogger(HtmlFile.class.getName());
   private FileHandler fileHTML;
   
    

     public void createLog(String p_logName ,boolean p_apped){
    	 try {
 			fileHTML = new FileHandler(p_logName,p_apped);
 		} catch (SecurityException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		fileHTML.setFormatter(new HtmlReportFormatter());
 		logger.addHandler(fileHTML);
     }
     
     @Override
     public void createLog(String p_logName){
    	 try {
 			fileHTML = new FileHandler(p_logName);
 		} catch (SecurityException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		fileHTML.setFormatter(new HtmlReportFormatter());
 		logger.addHandler(fileHTML);
     }
   

	
     @Override
	public void closeLog() {
		fileHTML.close();
		RecordStore.p_pass=0; 
		RecordStore.p_fail=0; 
		RecordStore.result=""; 
		RecordStore.expected=""; 
		RecordStore.actual=""; 
		//fileHTML.close();
		
		
	}

	@Override
	public void write(String p_info, String p_expected,String p_actual)  {
		RecordStore.actual = p_actual;
		RecordStore.expected = p_expected;
		
		if(p_expected.equals(p_actual))
			RecordStore.result = "Pass";
		else
			RecordStore.result = "Fail";
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		

	}
	
	//添加参数为boolean
	public void write(String p_info, boolean p_expected,boolean p_actual)  {
		RecordStore.actual = p_actual;
		RecordStore.expected = p_expected;
		
		if(p_expected==p_actual)
			RecordStore.result = "Pass";
		else
			RecordStore.result = "Fail";
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		

	}
	//添加参数为object，可以支持多种的期望结果 与实际结果的类型比较
	public void write(String p_info, Object p_expected,Object p_actual)  {
		RecordStore.actual = p_actual;
		RecordStore.expected = p_expected;
		
		if(p_expected.equals(p_actual))
			RecordStore.result = "Pass";
		else
			RecordStore.result = "Fail";
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		

	}

	@Override
	public void write(String p_info) {
		// TODO Auto-generated method stub
		logger.info(p_info);
		
	}

	@Override
	public void write(String p_info, String p_result) {
		// TODO Auto-generated method stub
		
		RecordStore.result = p_result;
		// setup();
		try {
			logger.info(p_info);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" logger write exception!");
		}
		
	}

	

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String p_key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String p_section, String p_key) {
		// TODO Auto-generated method stub
		return null;
	}




	

	
	

}
