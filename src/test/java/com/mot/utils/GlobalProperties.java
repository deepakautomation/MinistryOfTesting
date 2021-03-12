package com.mot.utils;

import java.util.HashMap;

public class GlobalProperties {
	
	public static ThreadLocal<String> FileSeperator;
	public static HashMap<String, String> PropertyMap;
	public static String ConfigFilePath;
	
	
	public GlobalProperties(){
		FileSeperator = new ThreadLocal<String>(){
			
			@Override
            protected String initialValue() {
				return System.getProperty("file.separator");
			}
		};
		
		
		PropertyMap =new HashMap<String, String>();
		
		ConfigFilePath = System.getProperty("user.dir") + FileSeperator.get() +  "config.properties";

	}
	
	public static HashMap<String,String> getPropertyMap(){
        return PropertyMap;
    }

}
