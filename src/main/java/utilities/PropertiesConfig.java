package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertiesConfig {
 private final Properties propeties;
 private final String propertyFilePath= System.getProperty("user.dir")+"/resources/config.properties/";
 
 //private static variable
 private static PropertiesConfig configLoader;
 
 //private constructor
 private PropertiesConfig() {
	 propeties = PropertiesConfig.propertyLoader(propertyFilePath);
 }
 private static Properties propertyLoader(String propertyFilePath) {
	 Properties properties = new Properties();
	 BufferedReader reader;
	 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 try {
			 properties.load(reader);
			 reader.close();
		 }catch(IOException e) {
			 e.printStackTrace();
			 throw new RuntimeException("Failed to load properties file " + propertyFilePath);
		 }
		 
	 }catch (FileNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("configuration properties not found at " + propertyFilePath);
	}
	 return properties;
 }
 //public static method
 public static PropertiesConfig getFileConfigReader() {
	 if(configLoader == null) {
		 configLoader = new PropertiesConfig();
	 }
	 return configLoader;
 }
 public long getLongTimeOut() {
	 String longTimeOut = propeties.getProperty("LongTimeout");
	 if(longTimeOut != null) {
		 return Long.parseLong(longTimeOut);
	 }
	 else {
		 throw new RuntimeException("Long timeout not found in Config file");
	 }
 }
 public long getShortTimeOut() {
	 String longTimeOut = propeties.getProperty("ShortTimeout");
	 if(longTimeOut != null) {
		 return Long.parseLong(longTimeOut);
	 }
	 else {
		 throw new RuntimeException("Short timeout not found in Config file");
	 }
 }
 public String getUserUrl() {
	 String url = propeties.getProperty("UserUrl");
	 if(url != null) {
		 return url;
	 }
	 else {
		 throw new RuntimeException("User Url not found in Config file");
	 }
 }
 public String getAdminrUrl() {
	 String url = propeties.getProperty("AdminUrl");
	 if(url != null) {
		 return url;
	 }
	 else {
		 throw new RuntimeException("Admin Url not found in Config file");
	 }
 }
}
