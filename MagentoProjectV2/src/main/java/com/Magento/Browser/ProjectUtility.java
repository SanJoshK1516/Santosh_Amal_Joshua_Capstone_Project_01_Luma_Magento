package com.Magento.Browser;

import java.io.FileInputStream;
import java.util.Properties;

public class ProjectUtility {

//	Method to read the Browser from the ProjectData.properties File
	public static String properties(String data) throws Exception {
		String propertiesData = null;

		try {

			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\ProjectData.properties";
			FileInputStream reader = new FileInputStream(filePath);
			Properties p = new Properties();
			p.load(reader);
			propertiesData = p.getProperty(data);
		} catch (Exception e) {
			System.out.println("Properties: " + e);
		}
		return propertiesData;

	}

}
