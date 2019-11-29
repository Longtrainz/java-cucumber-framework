package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactUsSteps {
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

    @Given("^I access webdriveruniversity contact us form$")
    public void i_access_webdriveruniversity_contact_us_form() throws Throwable {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("^I enter a valid first name$")
    public void i_enter_a_valid_first_name() throws Throwable {
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("user");
    }

    @When("^I enter a valid last name$")
    public void i_enter_a_valid_last_name(DataTable dataTable) throws Throwable {
        List<List<String>> lastName = dataTable.raw();
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(lastName.get(0).get(2));
    }

    @When("^I enter a valid email address$")
    public void i_enter_a_valid_email_address() throws Throwable {
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("johnson@mail.com");
    }

    @And("^I enter comments$")
    public void i_enter_comments(DataTable dataTable) throws Exception {
        List<List<String>> data = dataTable.raw();
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0) + "\n");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1));
    }

    @When("^I click on the submit button$")
    public void i_click_on_the_submit_button() throws Throwable {
        driver.findElement(By.cssSelector("input[value='SUBMIT']")).click();
    }

    @Then("^the information should successfully be submitted via the contact us form$")
    public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
        Assert.assertTrue(driver.findElement(By.cssSelector("#contact_reply > h1")).isDisplayed());
    }

    @Given("^I access webdriveruniversity$")
    public void i_access_webdriveruniversity() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @When("^I click on the contact us button$")
    public void i_click_on_the_contact_us_button() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @When("^I enter an invalid first name$")
    public void i_enter_an_invalid_first_name() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @When("^I enter an invalid last name$")
    public void i_enter_an_invalid_last_name() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @When("^I enter an email address$")
    public void i_enter_an_email_address() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @When("^I click on the reset button$")
    public void i_click_on_the_reset_button() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }

    @Then("^all information that was listed on the contact form will be removed$")
    public void all_information_that_was_listed_on_the_contact_form_will_be_removed() throws Throwable {
        System.out.println("User navigates to stackoverflow website2");
    }
}
