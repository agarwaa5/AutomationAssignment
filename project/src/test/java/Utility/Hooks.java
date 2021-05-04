package Utility;

import java.io.FileNotFoundException;
import java.io.IOException;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	//piece of code that would be executed before every scenario
	@Before ()
	public static void setup () throws FileNotFoundException, IOException {
		PropertyFileHandler.loadPropertyFile("src/resources/TestData/TestData.properties");
		WebDriverHelper.startUpDriver(PropertyFileHandler.readProperty("Browser"),
				PropertyFileHandler.readProperty("Os"), PropertyFileHandler.readProperty("path"),
				PropertyFileHandler.readProperty("Headless"));
	}
	
	//piece of code that would be executed after every scenario
	@After ()
	public static void tearDown() {
		WebDriverHelper.getWebDriver().quit();
	}

}
