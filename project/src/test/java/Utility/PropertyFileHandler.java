package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {
	
	static Properties prop = new Properties();
	
	PropertyFileHandler propertyFileHandler = new PropertyFileHandler();
	
	//load property file
	public static void loadPropertyFile(String path) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		}
	
	// values from property file by passing the key
	public static String readProperty(String key) {
		return prop.getProperty(key);
	}
	
	// write values to property file
	public static void writeProperty(String key, String value, String propertyFilePath) throws FileNotFoundException, IOException {
		prop.setProperty(key,value);
		prop.store(new FileOutputStream(propertyFilePath),null);
	}

}
