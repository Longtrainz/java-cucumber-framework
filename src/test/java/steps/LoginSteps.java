package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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



    @Given("^User access webdriveruniversity website$")
    public void user_access_webdriverunivesity_website() throws Throwable {
        driver.get("http://www.webdriveruniversity.com/");
    }

    @When("^User clicks on Login Portal link$")
    public void user_clicks_on_Login_Portal_link() throws Throwable {
        driver.findElement(By.xpath("//h1[text() ='LOGIN PORTAL']")).click();
    }

    @When("^User enters a username$")
    public void user_enters_a_username() throws Throwable {
        @SuppressWarnings("unused")
        String windowHandleBefore = driver.getWindowHandle();
        //Iterate over window handles and switch to new window
        for(String windowHandle:driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.id("text")).sendKeys("Tom");
    }

    //accept all Character Upper, Lower and numbers and special characters
    //send to the variable
    //saves repeating same method
    @When("^User enters a \"([^\"]*)\" password$")
    public void user_enters_a_password(String password) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^User clicks on the Login button$")
    public void user_clicks_on_the_Login_button() throws Throwable {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^User should be presented with a successful validation alert$")
    public void user_should_be_presented_with_a_successful_validation_alert() throws Throwable {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("validation failed", alert.getText());
    }

    @Then("^User should be presented with an unsuccessful validation alert$")
    public void user_should_be_presented_with_a_unsuccessful_validation_alert() throws Throwable {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("validation failed", alert.getText());
    }

}
