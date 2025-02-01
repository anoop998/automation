package testng;



import java.beans.Visibility;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Asserssion {
	WebDriver driver;
	WebDriverWait wait;

	@Test
public void login() {
	
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.findElement(By.name("username")).sendKeys("Admin");
  	  driver.findElement(By.name("password")).sendKeys("admin123");
  	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
  	  
  	  WebElement ad = driver.findElement(By.xpath("//span[.='Admin']"));
  	  String expectedtext="Admin";
  	  String Actualtext= ad.getText();
  	 Assert.assertEquals(expectedtext, Actualtext);
  	System.out.println("Login successfully");
	  	
	}
	@Test
	public void logout() {
        //wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.findElement(By.xpath("(//img[@alt=\"profile picture\"])[1]")).click();
    WebElement logout = driver.findElement(By.linkText("Logout"));
  // wait.until(ExpectedConditions.visibilityOf(logout));
	logout.click();
	   WebElement logot = driver.findElement(By.xpath("//p[.='Forgot your password? ']"));	
       String expectedtextString ="Forgot your password?";
       String actualtextString =logot.getText();
       Assert.assertEquals(expectedtextString, actualtextString);
	  
    }
	



}