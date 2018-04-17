package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.PageTest;
import beans.ProductBean;
import pages.AmazonLandingPage;
import pages.ProductDescriptionPage;
import pages.SearchProductsPage;

public class Earphones extends PageTest {

	AmazonLandingPage amazonLandingPage;
	SearchProductsPage searchProductsPage;
	ProductDescriptionPage productDescriptionPage;
	ProductBean productBean;
	
	String mainCategory = "TV, Appliances, Electronics";
	String subCategory = "Headphones";
	String productToBeSelected = "Philips SHE1350 In-Ear Headphones (Black)";
	
	@BeforeMethod
	public void beforeMethod() {
		amazonLandingPage = new AmazonLandingPage();
		searchProductsPage = new SearchProductsPage();
		productDescriptionPage = new ProductDescriptionPage();
	}
	
	@Test
	public void purchaseEarphones() {		
//		To select Main Category and Sub Catogory from home page
		amazonLandingPage.selectCategory(mainCategory, subCategory);
		
//		Print all the product details from the Search Product page
		searchProductsPage.printAllProductDetails();
		
//		Select a product using Product Name
		productBean = searchProductsPage.selectProductByName(productToBeSelected);
		 
		productDescriptionPage.waitForPageToLoad(productToBeSelected);
		
		assertEquals(productBean.getProductName(), productDescriptionPage.verifyProductName());
		assertEquals(productBean.getProductPrice(), productDescriptionPage.verifyProductPrice());
		
		productDescriptionPage.addToCart();
	}
}
