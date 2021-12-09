package interviewExercise.liverpool;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

/* This Test Case verifies that when adding some products to the bag
 * and going to the order screen, the total price is correctly calculated.
 */
public class TestCase1 {
	
	WebDriver driver;
	HomePage homePageController;
	SearchResultsPage resultsPageController;
	ProductPage productPageController;
	OrderPage orderPageController;

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/WebDrivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.liverpool.com.mx/tienda/home");
  }
  
  @Test(priority = 1)
  public void closeRegionPopUp() {
	  homePageController = new HomePage(driver);
	  homePageController.closeRegion();
  }
  
  @Test(priority = 2)
  public void searchForProduct() {
	  homePageController = new HomePage(driver);
	  homePageController.searchProduct("Perfume");
  }
  
  @Test(priority = 3)
  public void selectResult() {
	  resultsPageController = new SearchResultsPage(driver);
	  resultsPageController.selectFirstProduct();
  }
  
  @Test(priority = 4)
  public void addToCart() throws InterruptedException{
	  productPageController = new ProductPage(driver);
	  productPageController.addToCart();
  }
  
  @Test(priority = 5)
  public void goToBag() throws InterruptedException {
	  productPageController = new ProductPage(driver);
	  productPageController.goToBag();
  }
  
  @Test(priority = 6)
  public void validatePrices() {
	  orderPageController = new OrderPage(driver);
	  orderPageController.validateprices();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
