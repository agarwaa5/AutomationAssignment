package StepDefinition;

import PageFactory.OttonovaPageFactory;
import Utility.PropertyFileHandler;
import Utility.WebDriverHelper;
import Webpages.Beitragsrechner;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class FrontendStepDefinition {
	
	@Given("I launch the application as {string}")
	public void i_launch_the_application_as(String url) throws InterruptedException {
		WebDriverHelper.getWebDriverHelper().enterURL(PropertyFileHandler.readProperty(url));
	}

	@When("I click on Jetzt Beitrag berechnen")
	public void i_click_on_Jetzt_Beitrag_berechnen() throws InterruptedException {
		Beitragsrechner.getBeitragsrechner().clickJetztBeitragberechnen();
		Thread.sleep(2000);
	}

	@When("I select Angestellt")
	public void i_select_Angestellt() throws InterruptedException {
		Beitragsrechner.getBeitragsrechner().clickAngestellt();
		Thread.sleep(3000);
	}

	@When("I enter an income as {string}")
	public void i_enter_an_income_as(String income) {
		Beitragsrechner.getBeitragsrechner().enterIncome(PropertyFileHandler.readProperty(income));
	}

	@When("I click on Weiter")
	public void i_click_on_Weiter() throws InterruptedException {
		Beitragsrechner.getBeitragsrechner().clickWeiter();
		Thread.sleep(5000);
	}

	@When("I select Vollversicherung and enter date as {string}")
	public void i_select_Vollversicherung_and_enter_date_as(String startDate) {
		Beitragsrechner.getBeitragsrechner().selectVollversicherungStartDate(PropertyFileHandler.readProperty(startDate));
	}

	@Then("I validate the age with birthdate")
	public void i_validate_the_age_with_birthdate() throws InterruptedException {
		String expectedErrorMsg1 = "Leider kannst du dich erst ab 16 Jahren alleine versichern.";
		
		Beitragsrechner.getBeitragsrechner().enterBirthDate();
		Thread.sleep(1000);

		//Assert the error message
		System.out.println("actual errot msg is" +OttonovaPageFactory.pf.uiActualErrorMsg1.getText());
		Assert.assertEquals(expectedErrorMsg1, OttonovaPageFactory.pf.uiActualErrorMsg1.getText());
		
	}

	@Then("I validate the future birth date")
	public void i_validate_the_future_birth_date() throws InterruptedException {
		
		String expectedErrorMsg2 = "Du bist in der Zukunft geboren? Bitte ??berpr??fe deine Eingaben.";
		Beitragsrechner.getBeitragsrechner().enterFutureBirthDate();
		Thread.sleep(1000);

		//Assert the error message
		System.out.println("actual errot msg is" +OttonovaPageFactory.pf.uiActualErrorMsg2.getText());
		Assert.assertEquals(expectedErrorMsg2, OttonovaPageFactory.pf.uiActualErrorMsg2.getText());
	}
	
	

}
