package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.DriverFactory;

public class SignupPage extends DriverFactory{

	public SignupPage(WebDriver driver){
		PageFactory.initElements(getDriver(), this);
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
	
	
	
	public void sendFirstNameField(String firstname) throws InterruptedException, IOException {
		firstNameField.sendKeys(firstname);
		
	}
	
	public void sendLastNameField(String lastname) throws InterruptedException, IOException {
		lastNameField.sendKeys(lastname);
	}
	
	public void sendEmailField(String email) throws InterruptedException, IOException {
		emailField.sendKeys(email);
	}
	
	public void sendContactNumberField(String contactnumber) throws InterruptedException, IOException {
		contactNumberField.sendKeys(contactnumber);
	}
	
	public void sendpasswordField(String password) throws InterruptedException, IOException {
		passwordField.sendKeys(password);
	}
	
	public void sendConfirmPasswordField(String confirmPassword) throws InterruptedException, IOException {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void sendAddressOneField(String addressone) throws InterruptedException, IOException {
		addressOneField.sendKeys(addressone);
	}
	
	public void sendAddressTwoField(String addresstwo) throws InterruptedException, IOException {
		addressTwoField.sendKeys(addresstwo);
	}
	
	public void sendCityField(String city) throws InterruptedException, IOException {
		cityField.sendKeys(city);
	}
	
	public void sendPostalCodeField(String postalcode) throws InterruptedException, IOException {
		postalCodeField.sendKeys(postalcode);
	}
	
	public void sendStateField(String state) throws InterruptedException, IOException {
		stateField.sendKeys(state);
	}
	
	public void sendCountryField(String country) throws InterruptedException, IOException {
		countryField.sendKeys(country);
	}
	
	public void clickUserRadioBtn() throws InterruptedException, IOException {
		getWait().until(ExpectedConditions.elementToBeClickable(userRadioBtn));
		userRadioBtn.click();
		Thread.sleep(500);
	}
	
	public void clickSupplierRadioBtn() throws InterruptedException, IOException {
		getWait().until(ExpectedConditions.elementToBeClickable(supplierRadioBtn));
		supplierRadioBtn.click();
		Thread.sleep(500);
	}
	
	public void clickNextBillingBtn() throws InterruptedException, IOException {
		getWait().until(ExpectedConditions.elementToBeClickable(nextBillingBtn));
		nextBillingBtn.click();
		Thread.sleep(500);
	}
	
	public void clickBackPersonalBtn() throws InterruptedException, IOException {
		getWait().until(ExpectedConditions.elementToBeClickable(backPersonalBtn));
		backPersonalBtn.click();
		Thread.sleep(500);
	}
	public void clickNextConfirmBtn() throws InterruptedException, IOException {
		getWait().until(ExpectedConditions.elementToBeClickable(nextConfirmBtn));
		nextConfirmBtn.click();
		Thread.sleep(500);
	}
	public void clickConfirmBtn() throws InterruptedException, IOException {
		getWait().until(ExpectedConditions.elementToBeClickable(confirmBtn));
		confirmBtn.click();
		Thread.sleep(500);
	}
	
	public String getEmailError() {
		return emailError.getText();
	}
	
	public String getConfirmPasswordError() {
		return confirmPasswordError.getText();
	}
	
	public String getH4Text() {
		return h4.getText();
	}
	

}
