package Stepdefination;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Regression_Testing {
	public WebDriver driver;
			
	@After
	public void close() {
		driver.quit();
		
		
	}
	@Given("navigate to the login url")
	public void navigate_to_the_login_url() {
		
		driver = new ChromeDriver();
	    driver.get("https://v2dev.epikdev.org/auth");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
	    Window win = driver.manage().window();
        Dimension s = win.getSize();
        System.out.println("Window Size is :"+ s);
        System.out.println(s.getHeight());
        System.out.println(s.getWidth());
	    
	}
	
    
    @When("i enter (.*) and (.*)$")
	public void i_enter_email_and_password(String email, String pass) {
    	driver.findElement(By.xpath("(//input[@type=\"email\"])")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
    
	}
    @And("click on the show hide password")
    public void click_on_the_show_hide_password() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/div/span[2]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/div/span[2]")).click();

    }
    
    @And("click on the Remember me")
    public void click_on_the_Remember_me() {
    	driver.findElement(By.xpath("//input[@id=\"Remember\"]")).click();
    }
	
	@And("click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-lg fs-16 w-100\"]")).click();	
		Thread.sleep(10000);
		
	}
	
	
	@Then("user should redirect to the dashbard page")
	public void user_should_redirect_to_the_dashbard_page() throws InterruptedException {
		WebElement dash = driver.findElement(By.xpath("//a[.='Dashboard']"));
		 String expectedtextString ="Dashboard";
		 String actualtextString =dash.getText();
		 Assert.assertEquals(expectedtextString, actualtextString);

	    
	}
	
	
}
	


	

	