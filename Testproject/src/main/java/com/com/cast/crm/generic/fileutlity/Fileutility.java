package com.com.cast.crm.generic.fileutlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Fileutility {
	public String getdatafromProprty(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./configappdata/commondatass.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String q1 = pobj.getProperty(key);
	   return q1;
		
	}

}
