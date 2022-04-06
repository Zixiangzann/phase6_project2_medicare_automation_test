package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	Properties properties = null;

	//Load Properties function
	public void loadProperties(String filename) throws IOException {
		properties = new Properties();
		String projectDirPath = System.getProperty("user.dir");
		String propFilePath = projectDirPath + "/src/test/resources/config/" + filename;
		InputStream ins = new FileInputStream(propFilePath);
		properties.load(ins);

	}

	//getter for key
	public String get(String key) {

		return properties.getProperty(key);
	}
	
	//Just testing read properties function
	public static void main(String[] args) throws IOException {
		ReadProperties config = new ReadProperties();
		config.loadProperties("config.properties");
		String browser = config.get("browser");
		System.out.println(browser);
	}

}
