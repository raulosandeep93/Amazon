package base;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject extends PageTest {

	public void launchUrl(String url) {
		try {
			driver.get(url);
		} catch(Exception ex) {
			System.out.println("Exception in launchUrl method:" + ex.toString());
		}
	}
	
	public void hoverElement(WebElement element) {
		try {
			Actions action = new Actions(driver);
			waitForElementToClickable(element);
			action.moveToElement(element).perform();
		} catch(Exception ex) {
			System.out.println("Exception in hoverElement method:" + ex.toString());
		}
	}
	
	public void waitForElementToClickable(WebElement element) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, 10);
			explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		} catch(Exception ex) {
			System.out.println("Exception in waitForElementToClickable method:" + ex.toString());
		} 
	}
	
	public void elementClick(WebElement element, String elementName) {
		try {
			waitForElementToClickable(element);
			element.click();
		} catch(Exception ex) {
			System.out.println("Exception in clicking:" + elementName + ":" + ex.toString());
		}
	}
	
	public void switchWindow(String windowName) {
		boolean windowFound = false;
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Number of open windows:" + allWindows.size());
		
		if(allWindows.size() > 1) {
			for (String window : allWindows) {
				driver.switchTo().window(window);
				if(driver.getTitle().equals(windowName) || driver.getTitle().contains(windowName)) {
					windowFound = true;
					break;
				}
			}
		}
			
		if (!windowFound) {
			System.out.println("Unable to switch to:" + windowName + "window.");
		}
	}
	
	public boolean verifyDisplay(WebElement element) {
		boolean elementPresent = false;
		if(element.isDisplayed()) {
			elementPresent = true;
		}
		return elementPresent;
	}
}
