package Pages;

import java.util.Iterator;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class HomePage {
	
	      WebDriver driver;

		public HomePage(WebDriver driver) {
		        this.driver = driver;
		    }
	    private By addProductButton = By.xpath("//a[contains(@href,'add')]");
	    private By editProductButton = By.xpath("//div[@class='card-actions']//button[1]");
	    private By deleteProductButton = By.xpath("//div[@class='card-actions']//button[2]");
	    private By noProduuctFound = By.xpath("//p[contains(text(),'Found')]");

		
		
		//KIB products contains list of name of products to use it to verify the added product name 
	    private By KIBproducts = By.xpath("//div[contains(@class,'cursor-pointer')]");
	    private By searchField = By.xpath("//input[contains(@placeholder,'Search')]");
	    
	    
	    public WebElement getNoProduuctFound() {
			return driver.findElement(noProduuctFound)  ;
		}
	    public WebElement getDeleteProductButton() {
			return driver.findElement(deleteProductButton) ;
		}
	    public WebElement getEditProductButton() {
			return driver.findElement(editProductButton);
		}
	    public WebElement getSearchField() {
			return driver.findElement(searchField);
		}


		public WebElement getAddProductButton() {
			return driver.findElement(addProductButton) ;
		}

	    public void clickOnElement(WebElement element) {
	       
	        element.click();
	        
	    }
	    public void searchProduct(String productName) {
		       
	        getSearchField().sendKeys(productName);;
	        
	    }
	    public String addedProductName() {
		       
	    	List <WebElement> products =  driver.findElements(KIBproducts);	
	    	System.out.println("*****"+products.size());
	    	String addedProductName = products.get((products.size())-1).getText();
	    	System.out.println("*****"+addedProductName);

	    	return addedProductName;
	    }
	    
	    public List <WebElement> seachedProduct() {
		       
	    	List <WebElement> products =  (List<WebElement>) driver.findElements(KIBproducts);	
	    	System.out.println("*****"+products.size());
	    	return products;
	    	
	    }
	 
}
