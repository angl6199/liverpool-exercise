package interviewExercise.liverpool;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	private WebDriver webdriver;
	
	private By addToCart = By.xpath("//*[@id=\"sticky__button-addToMyBag\"]");
	private By bag = By.xpath("//*[@id=\"__next\"]/header/div[4]/div[1]/div/div/div/div[6]/button/span");
	
	
	public ProductPage(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public void addToCart() throws InterruptedException{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		js.executeScript("window.scrollBy(0,910)", "");
		WebDriverWait wait = new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sticky__button-addToMyBag")));
		webdriver.findElement(addToCart).click();
	}
	
	public void goToBag() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		Thread.sleep(1500);
		webdriver.findElement(bag).click();
	}
}
