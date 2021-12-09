package interviewExercise.liverpool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	private WebDriver webdriver;
	
	private By productHasResult = By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/main/div[1]/div/div/div[2]/p/span");
	private By productDoesNotHaveResult = By.xpath("//*[@id=\"__next\"]/div[1]/div/div[2]/div/div[1]/div/h1/strong[2]");
	private By productsResult = By.xpath("//*[@id=\"__next\"]/div[1]/div/div[3]/main/div[2]/div/div/ul/li");
	
	public SearchResultsPage(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public void selectFirstProduct() {
		WebDriverWait wait = new WebDriverWait(webdriver,7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(productHasResult));
		
		if (!webdriver.findElements(productHasResult).isEmpty()){
			List<WebElement> products = webdriver.findElements(productsResult);
			products.get(0).click();
		}
		
	}
}
