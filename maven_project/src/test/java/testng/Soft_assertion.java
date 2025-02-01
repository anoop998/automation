package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_assertion {
	WebDriver driver;
	WebDriverWait wait;
	SoftAssert soft;
	@Test
 public void setup() {
		 driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.findElement(By.name("username")).sendKeys("Admin");
	  	  driver.findElement(By.name("password")).sendKeys("admin123");
	  	  String expectedtext ="Login2";
	  String actual = driver.findElement(By.xpath("//button[.=' Login ']")).getText();
	  	  	SoftAssert soft = new SoftAssert();
	  	  	soft.assertEquals(expectedtext, actual);
	  	 
	  	  	driver.findElement(By.xpath("//button[.=' Login ']")).click();
	  	  	soft.assertAll();
		
		
	
}
}
