package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utility.WebDriverHelper;

public class OttonovaPageFactory {
	
	//initElements method to initialize web elements
	public static OttonovaPageFactory pf = PageFactory.initElements(WebDriverHelper.getWebDriver(), OttonovaPageFactory.class);
	
	@FindBy(how = How.ID,using="uc-btn-accept-banner")
	public WebElement uiAkzeptierenBTN;
	
	@FindBy(how = How.XPATH,using="//button[text()='Jetzt Beitrag berechnen']")
	public WebElement  uiJetztBTN;
	
	@FindBy(how = How.XPATH,using="//span[text()='Angestellt']")
	public WebElement  uiAngestelltRadioBTN;
	
	@FindBy(how = How.XPATH, using="//*[@type='tel'][@placeholder='Einkommen']")
	public WebElement uiIncomeTXT;
	
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Weiter')]")
	public WebElement uiWeiterBTN;
	
	@FindBy(how = How.XPATH, using="//*[contains(@class,'birthday ng-tns')]")
	public WebElement uiBirthDateTXT;
	
	@FindBy(how = How.XPATH, using="//*[text()=' Leider kannst du dich erst ab 16 Jahren alleine versichern. ']")
	public WebElement uiActualErrorMsg1;
	
	@FindBy(how = How.XPATH, using="//*[text()=' Du bist in der Zukunft geboren? Bitte überprüfe deine Eingaben. ']")
	public WebElement uiActualErrorMsg2;
	
	@FindBy(how = How.XPATH, using="//*[text()=' Wann bist du ']")
	public WebElement uiHomePage;
	
}
