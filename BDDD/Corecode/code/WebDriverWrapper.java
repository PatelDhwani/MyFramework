package code;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {

	WebDriver driver;

	public WebDriverWrapper(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public  WebElement waitForElementToBeClickable(final By by, int timeOut) {
		WebDriverWait webDriverWait= new WebDriverWait(driver,20);
		webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
		return webDriverWait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				try {
					WebElement element = driver.findElement(by);
					if (element.isEnabled() && element.isDisplayed())
						return element;
					else
						return null;
				} 
				catch (NoSuchElementException ex) {
					return null;
				} 
				catch (StaleElementReferenceException ex) {
					return null;
				} 
				catch (NullPointerException ex) {
					return null;
	}

}
		});
	}

	public static WebElement waitForElementToBeEnabled(By by, int timeOut) {
	
		return null;
	}

	public static WebElement waitForElementToBeDisplayed(By by, int timeOut) {
		
		return null;
	}

	public WebElement waitForElementToBePresent(By by) {
		// TODO Auto-generated method stub
		return null;
	}
	}
