package interviewExercise.liverpool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderPage {
	private WebDriver webdriver;
	
	private By comprar = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[2]/div/div/div[3]/div/button");
	private By subtotal = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]/p");
	private By descuento = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/p");
	private By cupones = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div[3]/p");
	private By envio = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div[4]/p");
	private By total = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div/p");
	
	private By totalTarjeta = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[1]/div/div[2]/div[4]/div/p");
	private By cantidad = By.xpath("//*[@id=\"mainSearchbar\"]");
	private By precioTarjeta = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[1]/div/div[2]/div[2]/div[2]/p");
	private By eliminar = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[1]/div/div[2]/div[1]/div[2]/div[2]/button[3]");
	
	private By emptyBagMessage = By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div[1]/div/p");
	
	public OrderPage(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
	
	public void buy() {
		WebDriverWait wait = new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(comprar));
		webdriver.findElement(comprar).click();
	}
	
	public void dropUniqueItem() {
		WebDriverWait wait = new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(eliminar));
		webdriver.findElement(eliminar).click();
	}
	
	public void validateEmptyMessage() {
		WebDriverWait wait = new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emptyBagMessage));
		String message = webdriver.findElement(emptyBagMessage).getText();
		Assert.assertEquals(message, "No hay artículos en tu bolsa");
	}
	
	public void validateprices() {
		WebDriverWait wait = new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(total));
		
		double subtotal2, descuento2, cupones2, envio2, total2;
		subtotal2 = Double.parseDouble(webdriver.findElement(subtotal).getText().replace("$", "").replace(",", ""));
		descuento2 = Double.parseDouble(webdriver.findElement(descuento).getText().replace("$", "").replace(",", ""));
		cupones2 = Double.parseDouble(webdriver.findElement(cupones).getText().replace("$", "").replace(",", ""));
		envio2 = Double.parseDouble(webdriver.findElement(envio).getText().replace("$", "").replace(",", ""));
		total2 = Double.parseDouble(webdriver.findElement(total).getText().replace("$", "").replace(",", ""));
		
		boolean result;
		if (((subtotal2 + envio2)-(descuento2 + cupones2) == total2)) {
			result = true;
		} else {
			result = false;
		}
		Assert.assertTrue(result);
	}
	
}
