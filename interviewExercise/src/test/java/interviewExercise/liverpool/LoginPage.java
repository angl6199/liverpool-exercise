package interviewExercise.liverpool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	private WebDriver webdriver;
	
	private By loginTitle = By.xpath("/html/body/main/section/div/div/header/h1");
	
	public LoginPage(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public void validatePage() {
		WebDriverWait wait = new  WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginTitle));
		String title = webdriver.findElement(loginTitle).getText();
		Assert.assertEquals(title, "Inicia sesión");
	}
}
