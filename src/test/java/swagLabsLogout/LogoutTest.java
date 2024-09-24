package swagLabsLogout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {
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
    public void logout() {
    	driver.findElement(By.id("react-burger-menu-btn")).click();
    	driver.findElement(By.id("logout_sidebar_link")).click();
    	
    	driver.findElement(By.xpath("//div[@class=\"login_logo\"]")).getText();
    }

}
