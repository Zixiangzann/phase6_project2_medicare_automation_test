package steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DriverFactory;

public class HomePageNavigationTest extends DriverFactory {

	@Given("User is at Home page")
	public void user_is_at_home_page() throws InterruptedException {
		basePage.goToUrl("http://localhost:8082/medicare/home");
		//Some load time
		Thread.sleep(1000);

	}

	@Then("user should see the following navigation bar item")
	public void user_should_see_the_following_navigation_bar_item(List<String> navigationBarItem)
			throws IOException, InterruptedException {
		List<String> expected = navigationBarItem;
		ArrayList<String> actual = homePage.getNavBarItems();
		Assert.assertEquals(actual, expected, "Navigation list of item is different from expected.");
	}

	@Then("user should see the following header for easy access of purchase")
	public void user_should_see_the_following_header_for_easy_access_of_purchase(List<String> headerItem)
			throws IOException, InterruptedException {
		List<String> expected = headerItem;
		ArrayList<String> actual = homePage.getHeaderItems();
		Assert.assertEquals(actual, expected, "Navigation list of item is different from expected.");

	}

	@Given("user click on About button")
	public void user_click_on_about_button() throws IOException, InterruptedException {
		homePage.clickAboutBtn();

	}

	@Then("user should be directed to About Page")
	public void user_should_be_directed_to_about_page() {
		String actual = basePage.getCurrentUrl();
		String expected = "/medicare/about";
		Assert.assertEquals(actual.contains(expected), true,"Incorrect URL");
	}

	@Given("user click on Contact button")
	public void user_click_on_contact_button() throws IOException, InterruptedException {
		homePage.clickContactBtn();

	}

	@Then("user should be directed to Contact Page")
	public void user_should_be_directed_to_contact_page() {
		String actual = basePage.getCurrentUrl();
		String expected = "/medicare/contact";
		Assert.assertEquals(actual.contains(expected), true,"Incorrect URL");
	}

	@Given("user click on View Products button")
	public void user_click_on_view_products_button() throws IOException, InterruptedException {
		homePage.clickListProductsBtn();
	}

	@Then("user should be directed to View Products Page")
	public void user_should_be_directed_to_view_products_page() {
		String actual = basePage.getCurrentUrl();
		String expected = "/medicare/show/all/products";
		Assert.assertEquals(actual.contains(expected), true,"Incorrect URL");
	}

	@Given("user click on Sign Up button")
	public void user_click_on_sign_up_button() throws IOException, InterruptedException {
		homePage.clickSignUpBtn();
	}

	@Then("user should be directed to Sign Up Page")
	public void user_should_be_directed_to_sign_up_page() {
		String actual = basePage.getCurrentUrl();
		String expected = "/medicare/membership?execution";
		Assert.assertEquals(actual.contains(expected), true,"Incorrect URL");

	}

	@Given("user click on Login button")
	public void user_click_on_login_button() throws IOException, InterruptedException {
		homePage.clickLoginBtn();
	}

	@Then("user should be directed to Login Page")
	public void user_should_be_directed_to_login_page() {
		String actual = basePage.getCurrentUrl();
		String expected = "/medicare/login";
		Assert.assertEquals(actual.contains(expected), true,"Incorrect URL");

	}

	@Then("user click on Home Page button")
	public void user_click_on_home_page_button() throws IOException, InterruptedException {
		homePage.clickHomePageBtn();
	}

	@Then("user should be directed to Home Page")
	public void user_should_be_directed_to_home_page() {
		String actual = basePage.getCurrentUrl();
		String expected = "/medicare/home";
		Assert.assertEquals(actual.contains(expected), true,"Incorrect URL");

	}

}
