package interviewExercise.liverpool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver webdriver;
	private By closeRegionIcon = By.xpath("//*[@id=\"selectStore-modal\"]/div/div/div[1]/button/i");
	private By searchBar = By.xpath("//*[@id=\"mainSearchbar\"]");
	private By submitSearchButton = By.xpath("//*[@id=\"__next\"]/header/div[5]/div[2]/div/div/div/div[3]/div/div/div/button/i");
	
	public HomePage(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public void closeRegion() {
		WebDriverWait wait = new WebDriverWait(webdriver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeRegionIcon));
		webdriver.findElement(closeRegionIcon).click();
	}
	
	public void searchProduct(String product) {
		webdriver.findElement(searchBar).sendKeys(product);
		webdriver.findElement(submitSearchButton).click();
	}
	
}
