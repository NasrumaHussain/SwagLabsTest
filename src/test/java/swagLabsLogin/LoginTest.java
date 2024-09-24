package swagLabsLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openApplicationWithChrome() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
    @Test
	public void validLogin() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
		
		}
    @Test
    public void invalidLogin() {
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
    	driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sa0e");
    	driver.findElement(By.id("login-button")).click();
    	
    	String actualerror = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
    	String expectederror = "Epic sadface: Username and password do not match any user in this service";
    	
    	Assert.assertEquals(actualerror, expectederror);
    	Assert.assertTrue(actualerror.contains(expectederror));
    	Assert.assertTrue(actualerror.contains("Epic sadface: Username and password do not match any user in this service"));
    	
    }
    
    @AfterMethod
    public void closeApplication() {
    	driver.quit();
    }
}
