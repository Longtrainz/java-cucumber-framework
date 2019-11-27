package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/resources/geckodriver.exe");
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @After()
    public void teardown() {
      driver.quit();
    }


    @Given("^User navigates to stackoverflow website$")
    public void user_navigates_to_stackoverflow_website() throws Throwable {
        driver.get("https://stackoverflow.com/");
    }

    @Given("^User clicks on the login button on homepage$")
    public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
    }

    @Given("^User enters a valid username$")
    public void user_enters_a_valid_username() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("testedflow@gmail.com");
    }

    @Given("^User enters a valid password$")
    public void user_enters_a_valid_password() throws Throwable {
        driver.findElement(By.id("password")).sendKeys("123qwe123");
    }

    @When("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        driver.findElement(By.id("submit-button")).click();
    }

    @Then("^User should be taken to the successful login page$")
    public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
        WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(),'Ask Question')]"));
        Assert.assertTrue(askQuestionButton.isDisplayed());
        Assert.assertEquals(askQuestionButton.getText(), "Ask Question");
    }




    @Given("^User navigates to stackoverflow website(\\d+)$")
    public void user_navigates_to_stackoverflow_website(int arg1) throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @Given("^User clicks on the login button on homepage(\\d+)$")
    public void user_clicks_on_the_login_button_on_homepage(int arg1) throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @Given("^User enters a valid username(\\d+)$")
    public void user_enters_a_valid_username(int arg1) throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @Given("^User enters a valid password(\\d+)$")
    public void user_enters_a_valid_password(int arg1) throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @When("^User clicks on the login button(\\d+)$")
    public void user_clicks_on_the_login_button(int arg1) throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @Then("^User should be taken to the successful login page(\\d+)$")
    public void user_should_be_taken_to_the_successful_login_page(int arg1) throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }
}
