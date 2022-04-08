package utils;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.BasePage;
import pageFactory.HomePage;
import pageFactory.SignupPage;


public class DriverFactory {

	//initialize driver and Page Object Variable
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions actions;

	public static void setDriver() {

		try {
			// Read Config
			ReadProperties config = new ReadProperties();
			config.loadProperties("config.properties");
			String browser = config.get("browser");
			String localOrGrid = config.get("localorgrid");
			String gridURL = config.get("gridurl");

			switch (browser) {

			case "firefox": {
				
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				
				if(localOrGrid.equalsIgnoreCase("local")) {
					driver = new FirefoxDriver(options);
				}else if(localOrGrid.equalsIgnoreCase("grid")) {
					//run on grid
					driver = new RemoteWebDriver(new URL(gridURL),options);
				}else {
					System.out.println("please indicate local or grid in the config file");
				}
				
				
			}
				break;

			case "chrome": {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--no-sandbox");
				if(localOrGrid.equalsIgnoreCase("local")) {
					driver = new ChromeDriver(options);
				}else if(localOrGrid.equalsIgnoreCase("grid")) {
					//run on grid
					driver = new RemoteWebDriver(new URL(gridURL),options);
				}else {
					System.out.println("please indicate local or grid in the config file");
				}
				
				
			}
				break;
			case "edge": {
				
				WebDriverManager.edgedriver().setup();
				EdgeOptions options = new EdgeOptions();

				if(localOrGrid.equalsIgnoreCase("local")) {
					driver = new EdgeDriver(options);
				}else if(localOrGrid.equalsIgnoreCase("grid")) {
					//run on grid
					driver = new RemoteWebDriver(new URL(gridURL),options);
				}else {
					System.out.println("please indicate local or grid in the config file");
				}	
				
				
			}//TO DO - to add Safari browser if required
				break;
			}
		} catch (Exception e) {
			System.out.println("Fail to setup browser: " + e.getMessage());
		} finally {

		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static WebDriverWait getWait() {
    	wait = new WebDriverWait(getDriver(), 15);
		return wait;
	}

	public static Actions getActions() {
    	actions = new Actions(getDriver());
		return actions;
	}

	

}