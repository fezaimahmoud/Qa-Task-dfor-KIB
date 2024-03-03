package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;

public class ProductPage {
      WebDriver driver;
    private By titleField = By.xpath("//input[@name='title']");
    private By descriptionField = By.xpath("//input[@name='description']");
    private By priceField = By.xpath("//input[@name='price']");
    private By createButton = By.xpath("//button[@type='submit']");
    public WebElement getTitleField() {
		return driver.findElement(titleField);
	}
	
	public WebElement getDescriptionField() {
		return driver.findElement(descriptionField);
	}
	
	public WebElement getPriceField() {
		return driver.findElement(priceField);
	}
	
	public WebElement getCreateButton() {
		return driver.findElement(createButton);
	}
	
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void fillnRequiredFields(String text1,String text2,String text3) throws InterruptedException {
	     Thread.sleep(2000);  
       getTitleField().sendKeys(text1);
       getDescriptionField().sendKeys(text2);      
       getPriceField().sendKeys(text3);
       Thread.sleep(3000);
    }
    public void editProductName(String text1) throws InterruptedException {
	     Thread.sleep(2000);
	     getTitleField().click();
	     getTitleField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
         getTitleField().sendKeys(text1);
     
   }
}

