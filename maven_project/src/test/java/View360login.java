import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View360login {

    WebDriver driver;

    // Setup WebDriver
    public void LoginSteps() {
        driver = new ChromeDriver();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("http://example.com/login");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("validUser");
        passwordField.sendKeys("validPassword");
        loginButton.click();
    }

    @Then("User should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://example.com/home", currentUrl);
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("invalidPassword");
        loginButton.click();
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @When("User leaves username and password blank")
    public void user_leaves_username_and_password_blank() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("User should see a validation message")
    public void user_should_see_a_validation_message() {
        WebElement validationMessage = driver.findElement(By.id("validationMessage"));
        assertTrue(validationMessage.isDisplayed());
    }

    // Tear down WebDriver
    @After
    public void tearDown() {
        driver.quit();
    }
}
