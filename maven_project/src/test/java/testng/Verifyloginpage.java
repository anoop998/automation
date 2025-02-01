package testng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Verifyloginpage {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(groups = "smoke",priority=0)
	public void setup() {
		
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(groups = "smoke", priority =1)
    public void navigatetowebsite() {
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    
     }
	@Test(groups = "smoke",priority=2)
    public void usercredentilas() {
    	driver.findElement(By.name("username")).sendKeys("Admin");
    	driver.findElement(By.name("password")).sendKeys("admin123");
    	
    }
	@Test(groups = "smoke",priority=3)
    public void clickonloginbutton() {
    	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
	@Test(groups = "Regression",priority=4)
    public void logout() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	//driver.findElement(By.xpath("(//img[@alt=\"profile picture\"])[1]")).click();
    WebElement logout = driver.findElement(By.linkText("Logout"));
    wait.until(ExpectedConditions.visibilityOf(logout));
	
	logout.click();
    }
	@Test(groups = "Regression",priority=5)
    public void tardown() {
		
    	driver.quit();
	}
		
	}
    
    
	

