package com.report.base;

public interface IFile {

	void write(String p_info);
	void createLog(String p_info);
	void closeLog();
	void write(String p_info1,String p_info2);
	void write(String p_info1,String p_info2,String p_info3);
	void write(String p_info1,boolean p_info2,boolean p_info3);
	String read();
	String read(String p_info);
	String read(String p_info1,String p_info2);
}
