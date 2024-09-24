package swagLabsProductPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest {
	 WebDriver driver;

	@BeforeMethod
	public void openApplicationWithChrome() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
		//driver.getTitle("Products");
		
}
	@Test
	public void products() {
		
		driver.findElement(By.xpath("//div[@class=\"inventory_item_name \"]")).click();
		driver.findElement(By.id("back-to-products")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//div[@class=\"inventory_item_name \"])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.xpath("(//div[@class=\"inventory_item_name \"])[3]")).click();
		driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.xpath("(//div[@class=\"inventory_item_name \"])[4]")).click();
		driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.xpath("(//div[@class=\"inventory_item_name \"])[5]")).click();
		driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.xpath("(//div[@class=\"inventory_item_name \"])[6]")).click();
	}

}
