package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class LoadPropertiesRegisterData {


	public static Properties userData = getLoginData();
	
	public static Properties getLoginData() {
		Path propertiesPath = Paths.get(System.getProperty("user.dir"),
				"src", "test", "java", "Properties", "RegisterDataPro.properties");
		
		Properties properties = new Properties();
		try (FileInputStream stream = new FileInputStream(propertiesPath.toFile())) {
			properties.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties from: " + propertiesPath.toAbsolutePath(), e);
		}
		
		return properties;
	}
}
