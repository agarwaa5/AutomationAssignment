package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverHelper {
	
	static WebDriverHelper wHelper;
	static WebDriver driver;
	
	public static WebDriverHelper getWebDriverHelper() {
		if (wHelper == null) {
			wHelper = new WebDriverHelper();
		}
		return wHelper;
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}
	

	public static void startUpDriver(String Browser, String Os, String path, String headless) {
		
		System.out.println("browser value is " +PropertyFileHandler.readProperty("Browser"));
		System.out.println("OS value is " +PropertyFileHandler.readProperty("Os"));
		System.out.println("Path value is " +PropertyFileHandler.readProperty("path"));
		System.out.println("Headless value is " +PropertyFileHandler.readProperty("Headless"));
		
		if (Browser.equalsIgnoreCase("chrome") && headless.equals("no")) {
        	System.out.println("Inside chrome");
        	System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver();
       }
			else if (Browser.equals("chrome") && Os.equals("Windows") && headless.equals("yes")) {
			System.setProperty("webdriver.chrome.driver", path);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors", "--silent");
			driver = new ChromeDriver(options);
		}
		
		driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
		
	}
	
	public void enterURL(String url) throws InterruptedException {
		//Launch the application
		driver.navigate().to(url);
		
		// Initialize and wait till element became visible - timeout in 10 seconds
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Hi, ich bin Isabel. ']")));
	}
}
