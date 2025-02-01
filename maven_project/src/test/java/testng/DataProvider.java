package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProvider {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(dataProvider = "logindata", dataProviderClass = Dataproviderstorlogin.class)
	public void logintest(String username, String password) throws InterruptedException {
		driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.findElement(By.name("username")).sendKeys(username);
	  	  driver.findElement(By.name("password")).sendKeys(password);
		
	  	driver.findElement(By.xpath("//button[.=' Login ']")).click();
	  	String Url="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  			
	  	SoftAssert soft = new SoftAssert();
	  	soft.assertTrue(Url.equals(driver.getCurrentUrl()));
	  	soft.assertAll();
	  	Thread.sleep(3000);
	  	driver.quit();
	  	
	  	
	}
}
