package shoppingCartContainer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartBadgeTest {
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
	}

	@Test
	public void BadgeOnCart() {
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		String actualBadge= driver.findElement(By.xpath("//span[@data-test=\"shopping-cart-badge\"]")).getText();
		String expectedBadge ="1";
		
		Assert.assertEquals(actualBadge, expectedBadge);
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		String actualBadge1= driver.findElement(By.xpath("//span[@data-test=\"shopping-cart-badge\"]")).getText();
		String expectedBadge1 ="2";
		Assert.assertEquals(actualBadge1, expectedBadge1);
		
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		
		String actualBadge6= driver.findElement(By.xpath("//span[@data-test=\"shopping-cart-badge\"]")).getText();
		String expectedBadge6 ="6";
		Assert.assertEquals(actualBadge6, expectedBadge6);
		
	}
	
}