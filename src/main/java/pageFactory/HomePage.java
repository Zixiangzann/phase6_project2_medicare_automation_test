package pageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

public class HomePage extends DriverFactory{
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(getDriver(), this);
	}
	
	public @FindBy(id="about") WebElement aboutBtn;
	public @FindBy(id="contact") WebElement contactBtn;
	public @FindBy(id="listProducts") WebElement listProductsBtn;
	public @FindBy(id="signup") WebElement signupBtn;
	public @FindBy(id="login") WebElement loginBtn;
	public @FindBy(className="navbar-brand") WebElement homePageBtn;
	public @FindBy(xpath="//ul[contains(@class,'nav navbar-nav')]/li") List<WebElement> navigationBarItems;
	public @FindBy(xpath="//h3") List<WebElement> headerItems;
	
	public void clickAboutBtn() throws IOException, InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(aboutBtn));
		aboutBtn.click();
		Thread.sleep(500);
	}
	
	public void clickContactBtn() throws IOException, InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(contactBtn));
		contactBtn.click();
		Thread.sleep(500);
	}
	
	public void clickListProductsBtn() throws IOException, InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(listProductsBtn));
		listProductsBtn.click();
		Thread.sleep(500);
	}
	
	public void clickSignUpBtn() throws IOException, InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(signupBtn));
		signupBtn.click();
		Thread.sleep(500);
	}
	
	public void clickLoginBtn() throws IOException, InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		Thread.sleep(500);
	}
	
	public void clickHomePageBtn() throws IOException, InterruptedException {
		getWait().until(ExpectedConditions.elementToBeClickable(homePageBtn));
		homePageBtn.click();
		Thread.sleep(500);
	}

	
	public ArrayList<String> getNavBarItems() throws IOException, InterruptedException {
		
		ArrayList<String> itemList = new ArrayList<String>();
				
				for(WebElement WebElement : navigationBarItems) {
					itemList.add(WebElement.getText());
				}
				return itemList;
		    }
		
	
	public ArrayList<String> getHeaderItems() throws IOException, InterruptedException {
		
		ArrayList<String> itemList = new ArrayList<String>();
		
		for(WebElement WebElement : headerItems) {
			itemList.add(WebElement.getText());
		}
		return itemList;
    }

}
