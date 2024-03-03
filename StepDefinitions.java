package StepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.BasePage;
import Pages.HomePage;
import Pages.ProductPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions{
	 WebDriver driver;
	 HomePage homePage ;
	 ProductPage productPage ;
	  @Before
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        homePage = new HomePage(driver); // Initialize homePage with WebDriver
	        productPage = new ProductPage(driver); // Initialize productPage with WebDriver
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            driver.close();
	        }
	    }

	   
       public static String addedProductName="";
	    @Given("I am on kibe-commerce website")
	    public void iAmOnTheECommerceWebsite() {
	        driver.get("https://e-commerce-kib.netlify.app/");
	        driver.manage().window().maximize();
	    }


		@When("^User click on add button$")
		public void userClickOnAddButton() throws Throwable {
		 homePage.clickOnElement(homePage.getAddProductButton());
		 }

		@And("^User fill in required fields \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
		public void userFillInRequiredFields(String title, String description, String price) throws Throwable {
			
			productPage.fillnRequiredFields(title, description, price);
			addedProductName=title;
			
		}



		@And("^User click on create button$")
		public void userClickOnCreateButton() throws Throwable {
			homePage.clickOnElement(productPage.getCreateButton());
			Thread.sleep(5000);

		}



		@Then("^User checks the availability of the product with his \"([^\"]*)\"$")
		public void userChecksTheAvailabilityOfTheProductWithHis(String productName) throws Throwable 
		{
			 JavascriptExecutor js = (JavascriptExecutor) driver;

		        // Execute JavaScript code to scroll to the bottom of the page
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(10000);

			assertTrue("added product is not correct", homePage.addedProductName().equalsIgnoreCase(productName));
		}

		

		@When("^User search for product with its \"([^\"]*)\"$")
		public void userSearchForProductWithIts(String name) throws Throwable {
			
			homePage.searchProduct(name);
			Thread.sleep(3000);
			
		}

		@And("^User click on edit product name with \"([^\"]*)\"and save$")
		public void userClickOnEditProductNameWithAndSave(String name) throws Throwable {
			homePage.clickOnElement(homePage.getEditProductButton());
			productPage.editProductName(name);
			Thread.sleep(5000);
			homePage.clickOnElement(productPage.getCreateButton());
			Thread.sleep(5000);

		}

		@Then("^User checks  \"([^\"]*)\" is saved successfully$")
		public void userChecksIsSavedSuccessfully(String newName) throws Throwable {
			JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Execute JavaScript code to scroll to the bottom of the page
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(10000);

		assertTrue("added product is not correct", homePage.addedProductName().equalsIgnoreCase(newName));		}

		@And("^User click on delete button$")
		public void userClickOnDeleteButton() throws Throwable {
			homePage.clickOnElement(homePage.getDeleteProductButton());
		}

		@Then("^User checks  product with \"([^\"]*)\" is saved successfully$")
		public void userChecksProductWithIsSavedSuccessfully(String name) throws Throwable {
			JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Execute JavaScript code to scroll to the bottom of the page
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(10000);

		assertTrue("product is not deleted", !(homePage.addedProductName().equalsIgnoreCase(name)));
		}

		@Then("^User checks search result contains \"([^\"]*)\"$")
		public void userChecksSearchResult(String text) throws Throwable {
			for (WebElement webElement : homePage.seachedProduct()) {
				assertTrue("product is not available", webElement.getText().contains(text));
				
			}
		}

		@Then("^User checks that search tresult contains is empty$")
		public void userChecksThatSearchTresultContainsIsEmpty() throws Throwable {
			assertTrue("product is available", homePage.getNoProduuctFound().isDisplayed());
		}





}
