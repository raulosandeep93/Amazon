package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.PageObject;

public class AddedToCartPage extends PageObject {

	public AddedToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='huc-v2-order-row-inner']")
	private WebElement divAddedToCartBar;
	
	@FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
	private WebElement btnCart;
	
	@FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
	private WebElement btnProceedToCheckout;
	
	public void verifyAddedToCart() {
		Reporter.log("Verify for item added to cart bar.");
		verifyDisplay(divAddedToCartBar);
	}
}
