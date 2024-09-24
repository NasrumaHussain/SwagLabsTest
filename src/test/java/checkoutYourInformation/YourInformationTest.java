package checkoutYourInformation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourInformationTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openApplicationWithChrome() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		String actualBadge1= driver.findElement(By.xpath("//span[@data-test=\"shopping-cart-badge\"]")).getText();
		String expectedBadge1 ="2";
		
		Assert.assertEquals(actualBadge1, expectedBadge1);
	}

@Test
public void yourInformation() {
 driver.findElement(By.xpath("//a[@data-test=\"shopping-cart-link\"]")).click();
 driver.findElement(By.id("checkout")).click();
 //the user is taken to another page
 driver.findElement(By.id("first-name")).sendKeys("April");
 driver.findElement(By.id("last-name")).sendKeys("Lee");
 driver.findElement(By.name("postalCode")).sendKeys("0044");
 driver.findElement(By.id("continue")).click();
}

}
