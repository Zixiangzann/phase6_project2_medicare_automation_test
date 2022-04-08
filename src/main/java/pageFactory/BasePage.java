package pageFactory;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import utils.DriverFactory;

public class BasePage extends DriverFactory{
	
	public JavascriptExecutor jsExecutor =((JavascriptExecutor)getDriver());
	
    
    public String getCurrentUrl() {
    	return getDriver().getCurrentUrl();
    }
    
    public void goToUrl(String url) {
    	getDriver().get(url);
    }
    
    
    public Cookie getCookies(String cookiesName) {
    	return getDriver().manage().getCookieNamed(cookiesName);
    }
    
    
	public void executeJS(String script) {
		jsExecutor.executeScript(script);
	}

	public Object returnExecuteJS(String script) {
		Object js = jsExecutor.executeScript("return " + script);
		return js;
	}

    

}
