package shoppingCartContainer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YourCartTest {
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
 public void yourCart() {
	 driver.findElement(By.xpath("//a[@data-test=\"shopping-cart-link\"]")).click();
	 driver.findElement(By.id("checkout")).click();
	 //the user is taken to another page
	
	 
 }
	@Test
	 public void yourCart1() {
		 driver.findElement(By.xpath("//a[@data-test=\"shopping-cart-link\"]")).click();
		 driver.findElement(By.id("continue-shopping")).click();
		 //User is taken to the all product page
	}
	

	
	

}
