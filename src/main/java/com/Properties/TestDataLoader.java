package com.Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.Constants.Constants;
import com.Report.ExtentFactory;

public class TestDataLoader {

	private TestDataLoader() {

		String env = Constants.EXECUTION_ENV;

		switch (env) {
		case "test":

			loadFile(Constants.TEST_ENV_DATA_FILE);
			break;

		case "prod":

			loadFile(Constants.PROD_ENV_DATA_FILE);
			break;
		default:
			break;
		}
	}

	private static TestDataLoader instance = new TestDataLoader();

	public static TestDataLoader getInstance() {
		return instance;
	}

	public static Properties prop;

	private static void loadFile(String filePath) {

		FileReader reader = null;
		try {
			reader = new FileReader(filePath);
		} catch (FileNotFoundException e) {

			ExtentFactory.getInstance().failTest("Exception occure while reading test data file");
		}
		prop = new Properties();

		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getPropertyValue(String key) {

		return prop.getProperty(key);
	}

	public String getAppUrl() {

		return prop.getProperty("app_url");
	}

	public String getUsername() {

		return prop.getProperty("username");
	}

	public String getPassword() {

		return prop.getProperty("password");
	}
}
