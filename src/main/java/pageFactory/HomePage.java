package pageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage() throws IOException {
		super();
	}
	
	public @FindBy(id="about") WebElement aboutBtn;
	public @FindBy(id="contact") WebElement contactBtn;
	public @FindBy(id="listProducts") WebElement listProductsBtn;
	public @FindBy(id="signup") WebElement signupBtn;
	public @FindBy(id="login") WebElement loginBtn;
	public @FindBy(className="navbar-brand") WebElement homePageBtn;
	public @FindBy(xpath="//ul[contains(@class,'nav navbar-nav')]/li") List<WebElement> navigationBarItems;
	public @FindBy(xpath="//h3") List<WebElement> headerItems;
	
	public HomePage clickAboutBtn() throws IOException, InterruptedException {
		waitAndClickElement(aboutBtn, 500);
		return new HomePage();
	}
	
	public HomePage clickContactBtn() throws IOException, InterruptedException {
		waitAndClickElement(contactBtn, 500);
		return new HomePage();
	}
	
	public HomePage clickListProductsBtn() throws IOException, InterruptedException {
		waitAndClickElement(listProductsBtn, 500);
		return new HomePage();
	}
	
	public HomePage clickSignUpBtn() throws IOException, InterruptedException {
		waitAndClickElement(signupBtn, 500);
		return new HomePage();
	}
	
	public HomePage clickLoginBtn() throws IOException, InterruptedException {
		waitAndClickElement(loginBtn, 500);
		return new HomePage();
	}
	
	public HomePage clickHomePageBtn() throws IOException, InterruptedException {
		waitAndClickElement(homePageBtn, 500);
		return new HomePage();
	}

	
	public ArrayList<String> getNavBarItems() throws IOException, InterruptedException {
		return getItemListByText(navigationBarItems);
		
	}
	
	public ArrayList<String> getHeaderItems() throws IOException, InterruptedException {
		return getItemListByText(headerItems);
		
	}
	

}
