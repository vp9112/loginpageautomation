package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.loginpage;

public class LoginTest {

    public WebDriver driver;
    public loginpage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/venkat/eclipse-workspace/loginpageautomation/driver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Initialize login page object
        loginPage = new loginpage(driver);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Navigate to the login page
        driver.get("https://dev.smartodr.in/login");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        // Enter username and password
        loginPage.enterUsername("venkatexam2mailinator.com");
        loginPage.enterPassword("Examtest@1");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        // Click on the login button
        loginPage.clickSubmit();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        // You can add validation here for successful login
    }

    @After
    public void close() {
        // Close WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create an instance of LoginTest
        LoginTest loginTest = new LoginTest();

        // Setting up WebDriver and logging in
        loginTest.setUp();
        loginTest.the_user_is_on_the_login_page();
        loginTest.the_user_enters_valid_credentials();
        loginTest.the_user_clicks_the_login_button();

        // Adding a delay to see the results (for demonstration purposes)
        Thread.sleep(5000);

        // Assuming you want to check some post-login functionality
        loginTest.the_user_should_be_logged_in_successfully();

        // Cleaning up WebDriver resources
        loginTest.close();
    }
}
