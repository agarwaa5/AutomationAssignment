package StepDefinition;

import Webpages.BackendClass;
import io.cucumber.java.en.*;


public class BackendStepDefinition {
	
	@Given("I send the GET request and validate the response")
	public void i_send_the_GET_request_and_validate_the_response() {
		BackendClass.getBackendClass().getResponseBody();
	}

}
