package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.PageObject;

public class ProductDescriptionPage extends PageObject {
	
	public ProductDescriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement lblProductName;
	
	@FindBy(xpath = "//span[@id='priceblock_ourprice']")
	private WebElement lblProductPrice;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement btnAddToCart;

	public void waitForPageToLoad(String productToBeSelected) {
		switchWindow(productToBeSelected);
	}
	
	public String verifyProductName() {
		String productName = lblProductName.getText().trim();
		return productName;
	}
	
	public String verifyProductPrice() {
		String productPrice = lblProductPrice.getText().trim();
		if(productPrice.contains(".00")) {
			productPrice = productPrice.replaceAll(".00", "");
		}
 		return productPrice;
	}
	
	public void addToCart() {
		try {
			Reporter.log("Clicking on Add to Cart button.");
			elementClick(btnAddToCart, "Add to Cart button.");
			Reporter.log("Add to Cart button has been clicked successfully.");
		} catch(Exception ex) {
			Reporter.log("Exception in addToCart method:" + ex.toString());
		}
	}
}
