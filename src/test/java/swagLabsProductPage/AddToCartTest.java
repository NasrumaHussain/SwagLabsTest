package swagLabsProductPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddToCartTest extends  ProductPageTest {
	
	
	@Test 
	public void addToCart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
				
		driver.findElement(By.name("remove-sauce-labs-backpack")).click();
		driver.findElement(By.name("remove-sauce-labs-bike-light")).click();
		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
		
		
	}

}
