package beans;

public class ProductBean {

	String productName;
	String productPrice;
	
	public ProductBean(String productName, String productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}
}
