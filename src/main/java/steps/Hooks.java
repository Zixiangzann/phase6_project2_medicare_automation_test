package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageFactory.BasePage;
import pageFactory.HomePage;
import pageFactory.SignupPage;
import utils.DriverFactory;

public class Hooks{
	
	public static WebDriver driver;
	public static BasePage basePage;
	public static HomePage homePage;
	public static SignupPage signupPage;
	
	@Before
	public void beforeScenario() throws InterruptedException {
		DriverFactory.setDriver();
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		try {
			if(driver!=null && scenario.isFailed()) {
				scenario.attach(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
			}if(driver!=null) {
				driver.quit();
			}
		}catch(Exception e) {
			System.out.println("Screenshot teardown failed, Exception:" + e.getMessage());
		}
		
			
	}
	
}
