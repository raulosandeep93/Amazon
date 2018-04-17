package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageObject;

public class AmazonLandingPage extends PageObject {
	
	public AmazonLandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='nav-link-shopall']")
	private WebElement linkShopByCategory;
	
	@FindBy(xpath = "//span[@role='navigation']/span")
	private List<WebElement> listMainCategory;
	
	@FindBy(xpath = "//a[@class='nav-link                                    nav-item']/span")
	private List<WebElement> listSubCategory;
	
	public void selectCategory(String mainCategory, String subCategory) {
		hoverElement(linkShopByCategory);
		selectMainCategory(mainCategory);
		selectSubCategory(subCategory);
	}
	
	public void selectMainCategory(String mainCategory) {
		boolean mainCategoryFlag = false;
		
		for (WebElement mainCategoryItem : listMainCategory) {
			if(mainCategoryItem.getText().trim().toLowerCase().equals(mainCategory.toLowerCase())) {
				hoverElement(mainCategoryItem);
				mainCategoryFlag = true; 
				break;
			}
		}
		
		if(!mainCategoryFlag) {
			System.out.println("Main Category not found!");
		}
	}
	
	public void selectSubCategory(String subCategory) {
		boolean subCategoryFlag = false;
		
		for (WebElement subCategoryItem : listSubCategory) {
			if(subCategoryItem.getText().trim().toLowerCase().equals(subCategory.toLowerCase())) {
				elementClick(subCategoryItem, subCategory);
				subCategoryFlag = true; 
				break;
			}
		}
		
		if(!subCategoryFlag) {
			System.out.println("Sub Category not found!");
		}
	}
}
