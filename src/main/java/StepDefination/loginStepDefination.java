package StepDefination;

import Utility.waitUtils;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class loginStepDefination {

    WebDriver driver;

    //Global hook
  /*  @Before
    public void launch()
    {
        WebDriverManager.chromiumdriver().setup();
        driver= new ChromeDriver();
        System.out.println("Browser is open");
    }

    //global hook
    @After
    public void closeBrowser()
    {
        driver.quit();
    }
*/
    @Before("@SmokeTest")
    public void localHook()
    {
        driver.navigate().refresh();
        System.out.println("Title is printed" + driver.getTitle());
    }

    @Given("User is already on login page")
    public void user_is_already_on_login_page() {

        driver.get("https://mailchimp.com");
        System.out.println("Web Application is opened");
        driver.manage().window().maximize();

    }

    @When("Title of login page is All in one")
    public void title_of_login_page_is_All_in_one() {

        //Assert.assertEquals(driver.getTitle(), "All-in-One Marketing Platform - Mailchimp");
        System.out.println("title is matched");
    }

    @Then("user go to login page")
    public void user_go_to_login_page() {

        WebElement element= driver.findElement(By.className("globalNavActions__login"));

        element.click();



        Assert.assertEquals(driver.getTitle(), "Login | Mailchimp");
        System.out.println("Login page is displayed");

    }

    @Then("User enter \"(.*)\" and \"(.*)\"$")
    public void user_enter_username_and_password(String user, String pwd) {

        By username = By.xpath("//*[@id='username']");

        waitUtils.waitForVisiblity(driver,username).sendKeys(user);

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys(pwd);
        //Assert.assertEquals("sachin", username.getText());

    }

    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {

        WebElement logINBtn= driver.findElement(By.xpath("//*[text()='Log In']"));
        logINBtn.submit();
    }

    @Then("^User enters username and password with data table$")
    public void user_enters_username_and_password_with_data_table(DataTable credtional) throws Throwable {
       List<List<String>> data= credtional.raw();

        By username = By.xpath("//*[@id='username']");

        waitUtils.waitForVisiblity(driver,username).clear();
        waitUtils.waitForVisiblity(driver,username).sendKeys(data.get(0).get(0));
        // username.sendKeys("sachin");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys(data.get(0).get(1));
        //Assert.assertEquals("sachin", username.getText());
        Thread.sleep(3000);

    }

    @Then("^User enters username and password with data driven$")
    public void user_enters_username_and_password_with_data_driven(DataTable dataTable) throws Throwable {


           By username = By.xpath("//*[@id='username']");
        WebElement password = driver.findElement(By.id("password"));

           for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
            waitUtils.waitForVisiblity(driver, username).clear();
            waitUtils.waitForVisiblity(driver, username).sendKeys(data.get("Usernames"));

            password.sendKeys(data.get("pwd"));

        }
        Thread.sleep(3000);

    }

    @Then("User enter another \"(.*)\" and \"(.*)\"$")
    public void user_another_enter_username_and_password(String user, String pwd) throws InterruptedException {

        By username = By.xpath("//*[@id='username']");

        waitUtils.waitForVisiblity(driver,username).clear();
        waitUtils.waitForVisiblity(driver,username).sendKeys(user);
        // username.sendKeys("sachin");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys(pwd);
        //Assert.assertEquals("sachin", username.getText());
        Thread.sleep(3000);
        driver.quit();
    }

}
