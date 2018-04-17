package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageObject;
import beans.ProductBean;

public class SearchProductsPage extends PageObject {

	public SearchProductsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='a-size-base s-inline  s-access-title  a-text-normal']")
	private List<WebElement> listLblProductName;
	
	@FindBy(xpath = "//span[@class='a-size-base a-color-price s-price a-text-bold']")
	private List<WebElement> listLblProductPrice;

	public void printAllProductDetails() {
		System.out.println("Number of Product Name found:" + listLblProductName.size());
		System.out.println("Number of Product Price found:" + listLblProductPrice.size());
		
		for (int i = 0; i < listLblProductName.size(); i++) {
			System.out.println("Product Name:" + listLblProductName.get(i).getAttribute("data-attribute"));
			System.out.println("Product Price:" + listLblProductPrice.get(i).getText());
			System.out.println("*************************************************************************");
		}
	}

	public ProductBean selectProductByName(String expectedProductName) {
		boolean productFound = false;
		ProductBean productBean = null;
		try {
			for (int i = 0; i < listLblProductName.size(); i++) {
				String actualProductName = listLblProductName.get(i).getAttribute("data-attribute").trim();
				String actualProductPrice = listLblProductPrice.get(i).getText().trim();
				if(expectedProductName.equals(actualProductName)) {
					productFound = true;
					productBean = new ProductBean(actualProductName,actualProductPrice);
					listLblProductName.get(i).click();
					break;
				}
			}
			
			if(!productFound) {
				System.out.println("Required product " + expectedProductName + " not found!");
			}
		} catch(Exception ex) {
			System.out.println("Exception in selectProductByName method:" + ex.toString());
		}
		return productBean;
	}
}
