package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import PageFactory.OttonovaPageFactory;
import Utility.WebDriverHelper;


public class Beitragsrechner {
	
	static Beitragsrechner object;
	
	public static Beitragsrechner getBeitragsrechner() {
		if (object == null)
			object = new Beitragsrechner();
		return object;
		
	}
	
	//creating a reference for Javascript Executor
	JavascriptExecutor js = (JavascriptExecutor)WebDriverHelper.getWebDriver();	
	
	//Click on button "Jetzt Beitrag berechnen", a popup would appear and click on button "Akzeptieren"
	public void clickJetztBeitragberechnen() throws InterruptedException {
		OttonovaPageFactory.pf.uiJetztBTN.click();
		Thread.sleep(5000);
		//Click on Akzeptieren button on popup
		OttonovaPageFactory.pf.uiAkzeptierenBTN.click();
	}
	
	//Select Angestellt Radio Button 
	public void clickAngestellt() {
		OttonovaPageFactory.pf.uiAngestelltRadioBTN.click();
	}
	
	//Enter income as 70000
	public void enterIncome(String income) {
		OttonovaPageFactory.pf.uiIncomeTXT.sendKeys(income);
	}
	
	//Click on Weiter
	public void clickWeiter() {
		OttonovaPageFactory.pf.uiWeiterBTN.click();
	}
	
	//Select start date from the dropdown
	public void selectVollversicherungStartDate(String startDate) {
		Select uiStartDate = new Select(WebDriverHelper.getWebDriver().findElement(By.xpath("//*[@formcontrolname='ingress_date']")));
		uiStartDate.selectByVisibleText(startDate);
	}
	
	
	public void enterBirthDate() {	
		//used Javascript path and Javascript Executor to locate shadow root elements
		
		//Enter day
		WebElement day = (WebElement) js.executeScript("return document.querySelector('otto-input-birthday-zodiac').shadowRoot.querySelector('input')");
		String jse1 = "arguments[0].value='01'";
		((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript(jse1, day);
		
		//Enter month
		WebElement month = (WebElement) js.executeScript("return document.querySelector('otto-input-birthday-zodiac').shadowRoot.querySelector('div > div > input.month')");
		String jse2 = "arguments[0].value='01'";
		((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript(jse2, month);
		
		//Enter year
		WebElement year = (WebElement) js.executeScript("return document.querySelector('otto-input-birthday-zodiac').shadowRoot.querySelector('div > div > input.year')");
		String jse3 = "arguments[0].value='2020'";
		((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript(jse3, year);
		
		//to populate the error message
		day.sendKeys(Keys.ENTER);
	}
	
	public void enterFutureBirthDate() {		
		//used Javascript path and Javascript Executor to locate shadow root elements
		
		//Re-enter day
		WebElement day = (WebElement) js.executeScript("return document.querySelector('otto-input-birthday-zodiac').shadowRoot.querySelector('input')");
		String jse1 = "arguments[0].value='01'";
		((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript(jse1, day);
		
		//Re-enter month
		WebElement month = (WebElement) js.executeScript("return document.querySelector('otto-input-birthday-zodiac').shadowRoot.querySelector('div > div > input.month')");
		String jse2 = "arguments[0].value='01'";
		((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript(jse2, month);
		
		//Re-enter year
		WebElement year = (WebElement) js.executeScript("return document.querySelector('otto-input-birthday-zodiac').shadowRoot.querySelector('div > div > input.year')");
		String jse3 = "arguments[0].value='2022'";
		((JavascriptExecutor) WebDriverHelper.getWebDriver()).executeScript(jse3, year);
		
		//to populate the error message
		day.sendKeys(Keys.ENTER);
	}
	

}
