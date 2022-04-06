package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

	public SignupPage() throws IOException {
		super();
	}

	//page1
	public @FindBy(id = "firstName") WebElement firstNameField;
	public @FindBy(id = "lastName") WebElement lastNameField;
	public @FindBy(id = "email") WebElement emailField;
	public @FindBy(id = "email.errors") WebElement emailError;
	public @FindBy(id = "contactNumber") WebElement contactNumberField;
	public @FindBy(id = "password") WebElement passwordField;
	public @FindBy(id = "confirmPassword") WebElement confirmPasswordField;
	public @FindBy(id = "confirmPassword.errors") WebElement confirmPasswordError;
	public @FindBy(xpath = "//label[@class='radio-inline']/input[@value='USER']") WebElement userRadioBtn;
	public @FindBy(xpath = "//label[@class='radio-inline']/input[@value='SUPPLIER']") WebElement supplierRadioBtn;
	public @FindBy(xpath = "//button[@type='submit']") WebElement nextBillingBtn;
	
	//page2
	public @FindBy(id = "addressLineOne") WebElement addressOneField;
	public @FindBy(id = "addressLineTwo") WebElement addressTwoField;
	public @FindBy(id = "city") WebElement cityField;
	public @FindBy(id = "postalCode") WebElement postalCodeField;
	public @FindBy(id = "state") WebElement stateField;
	public @FindBy(id = "country") WebElement countryField;
	public @FindBy(xpath = "//button[@class='btn btn-primary'][1]") WebElement backPersonalBtn;
	public @FindBy(xpath = "//button[@class='btn btn-primary'][2]") WebElement nextConfirmBtn;
	
	//page3
	public @FindBy(xpath = "//a[@class='btn btn-lg btn-primary']") WebElement confirmBtn;
	
	//h4 text to see sign up page
	public @FindBy(xpath="//h4") WebElement h4;
	
	
	
	public SignupPage sendFirstNameField(String firstname) throws InterruptedException, IOException {
		sendKeys(firstNameField, firstname);
		return new SignupPage();
	}
	
	public SignupPage sendLastNameField(String lastname) throws InterruptedException, IOException {
		sendKeys(lastNameField, lastname);
		return new SignupPage();
	}
	
	public SignupPage sendEmailField(String email) throws InterruptedException, IOException {
		sendKeys(emailField, email);
		return new SignupPage();
	}
	
	public SignupPage sendContactNumberField(String contactnumber) throws InterruptedException, IOException {
		sendKeys(contactNumberField, contactnumber);
		return new SignupPage();
	}
	
	public SignupPage sendpasswordField(String password) throws InterruptedException, IOException {
		sendKeys(passwordField, password);
		return new SignupPage();
	}
	
	public SignupPage sendConfirmPasswordField(String confirmPassword) throws InterruptedException, IOException {
		sendKeys(confirmPasswordField, confirmPassword);
		return new SignupPage();
	}
	
	public SignupPage sendAddressOneField(String addressone) throws InterruptedException, IOException {
		sendKeys(addressOneField, addressone);
		return new SignupPage();
	}
	
	public SignupPage sendAddressTwoField(String addresstwo) throws InterruptedException, IOException {
		sendKeys(addressTwoField, addresstwo);
		return new SignupPage();
	}
	
	public SignupPage sendCityField(String city) throws InterruptedException, IOException {
		sendKeys(cityField, city);
		return new SignupPage();
	}
	
	public SignupPage sendPostalCodeField(String postalcode) throws InterruptedException, IOException {
		sendKeys(postalCodeField, postalcode);
		return new SignupPage();
	}
	
	public SignupPage sendStateField(String state) throws InterruptedException, IOException {
		sendKeys(stateField, state);
		return new SignupPage();
	}
	
	public SignupPage sendCountryField(String country) throws InterruptedException, IOException {
		sendKeys(countryField, country);
		return new SignupPage();
	}
	
	public SignupPage clickUserRadioBtn() throws InterruptedException, IOException {
		waitAndClickElement(userRadioBtn, 500);
		return new SignupPage();
	}
	
	public SignupPage clickSupplierRadioBtn() throws InterruptedException, IOException {
		waitAndClickElement(supplierRadioBtn, 500);
		return new SignupPage();
	}
	
	public SignupPage clickNextBillingBtn() throws InterruptedException, IOException {
		waitAndClickElement(nextBillingBtn, 500);
		return new SignupPage();
	}
	
	public SignupPage clickBackPersonalBtn() throws InterruptedException, IOException {
		waitAndClickElement(backPersonalBtn, 500);
		return new SignupPage();
	}
	public SignupPage clickNextConfirmBtn() throws InterruptedException, IOException {
		waitAndClickElement(nextConfirmBtn, 500);
		return new SignupPage();
	}
	public SignupPage clickConfirmBtn() throws InterruptedException, IOException {
		waitAndClickElement(confirmBtn, 500);
		return new SignupPage();
	}
	
	public String getEmailError() {
		return getText(emailError);
	}
	
	public String getConfirmPasswordError() {
		return getText(confirmPasswordError);
	}
	
	public String getH4Text() {
		return getText(h4);
	}
	

}
