package steps;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DriverFactory;
import utils.MySqlQueryFunction;

public class SignUpTest  extends DriverFactory {
	
	@Given("User navigate to Sign Up page")
	public void user_navigate_to_sign_up_page() throws InterruptedException, IOException {
		basePage.goToUrl("http://localhost:8082/medicare/home");
		//navigate to sign up page
		Thread.sleep(1000);
		homePage.clickSignUpBtn();
		Thread.sleep(5000);
		
	}
	
	@And("User enter First_Name as {string}")
	public void user_enter_first_name_as(String string) throws InterruptedException, IOException {
	    signupPage.sendFirstNameField(string);
	}

	@And("User enter Last_Name as {string}")
	public void user_enter_last_name_as(String string) throws InterruptedException, IOException {
	    signupPage.sendLastNameField(string);
	}

	@And("User enter Email as {string}")
	public void user_enter_email_as(String string) throws InterruptedException, IOException {
	   signupPage.sendEmailField(string);
	}

	@And("User enter Contact Number as {string}")
	public void user_enter_contact_number_as(String string) throws InterruptedException, IOException {
	    signupPage.sendContactNumberField(string);
	}

	@And("User enter Password as {string}")
	public void user_enter_password_as(String string) throws InterruptedException, IOException {
	    signupPage.sendpasswordField(string);
	}

	@And("User enter Confirm Password as {string}")
	public void user_enter_confirm_password_as(String string) throws InterruptedException, IOException {
	    signupPage.sendConfirmPasswordField(string);
	}

	@And("User select Role as {string}")
	public void user_select_role_as(String string) throws InterruptedException, IOException {
		switch (string) {
		case "User": 
			signupPage.clickUserRadioBtn();
			break;
		case "Supplier":
			signupPage.clickSupplierRadioBtn();
		}
			
	}

	@Then("User click on Next - Billing button")
	public void user_click_on_next_billing_button() throws InterruptedException, IOException {
	    signupPage.clickNextBillingBtn();
	    Thread.sleep(3000);
	}

	@Then("User enter Address one as {string}")
	public void user_enter_address_one_as(String string) throws InterruptedException, IOException {
	    signupPage.sendAddressOneField(string);
	}

	@Then("User enter Address two as {string}")
	public void user_enter_address_two_as(String string) throws InterruptedException, IOException {
		signupPage.sendAddressTwoField(string);
	}

	@Then("User enter City as {string}")
	public void user_enter_city_as(String string) throws InterruptedException, IOException {
		signupPage.sendCityField(string);
	}

	@Then("User enter Postal Code as {string}")
	public void user_enter_postal_code_as(String string) throws InterruptedException, IOException {
		signupPage.sendPostalCodeField(string);
	}

	@Then("User enter State as {string}")
	public void user_enter_state_as(String string) throws InterruptedException, IOException {
		signupPage.sendStateField(string);
	}

	@Then("User enter Country as {string}")
	public void user_enter_country_as(String string) throws InterruptedException, IOException {
		signupPage.sendCountryField(string);
	}

	@Then("User click on Next-Confirm button")
	public void user_click_on_next_confirm_button() throws InterruptedException, IOException {
	   signupPage.clickNextConfirmBtn();
	}

	@Then("User click on Confirm button")
	public void user_click_on_confirm_button() throws InterruptedException, IOException {
		//this is the last page confirm button
	    signupPage.clickConfirmBtn();
	}

	@Then("Account should be created {string}")
	public void account_should_be_created(String string) throws ClassNotFoundException, SQLException {
		//to query DB 
		int actual = MySqlQueryFunction.getCount("SELECT COUNT(*) FROM User_detail WHERE email = " +'"' + string + '"' );
		int expected = 1;
		
		// 1 mean can find = account is created
		System.out.println(actual);
		Assert.assertEquals(actual, expected,"Account not created");
	}

	@Then("confirm password field should prompt {string}")
	public void confirm_password_field_should_prompt_message(String string) {
		String actual = signupPage.getConfirmPasswordError();
		String expected = string;
		Assert.assertEquals(actual, expected,"Message prompt is different from expected");
	    
	}

	@And("User enter Email as {string} but the email have been used")
	public void user_enter_email_as_but_the_email_have_been_used(String string) throws InterruptedException, IOException {
	    //Using a email that have been used before
		signupPage.sendEmailField("vk@gmail.com");
	}

	@Then("email field should prompt {string}")
	public void email_field_should_prompt_message(String string) {
		String actual = signupPage.getEmailError();
		String expected = string;
		Assert.assertEquals(actual, expected,"Message prompt is different from expected");
	}

	@Then("User click on Back - Personal button")
	public void user_click_on_back_personal_button() throws InterruptedException, IOException {
	    signupPage.clickBackPersonalBtn();
	}

	@Then("It should bring user back to Sign Up - Personal page")
	public void it_should_bring_user_back_to_sign_up_personal_page() {
	    String actual = signupPage.getH4Text();
	    String expected = "Sign Up - Personal";
	    Assert.assertEquals(actual, expected,"Did not go back to Sign Up - Personal page");
	}

	@Then("User did NOT click on Confirm button")
	public void user_did_not_click_on_confirm_button() throws IOException, InterruptedException {
		Thread.sleep(5000);
	    homePage.clickHomePageBtn();
	}

	@Then("Account should not be created {string}")
	public void account_should_not_be_created(String string) throws ClassNotFoundException, SQLException {
		//to query DB 
		int actual = MySqlQueryFunction.getCount("SELECT COUNT(*) FROM User_detail WHERE email = " +'"' + string + '"' );
		int expected = 0;
		
		// 0 mean cannot find = account NOT created
		System.out.println(actual);
		Assert.assertEquals(actual, expected,"Account not created"); 

	}
	

}
