package StepDefination;

import Pages.HomePage;
import Utility.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


import java.io.IOException;

import static Utility.TestBase.homePage;

public class loginWithPageFactoryConcept extends TestBase{

    //HomePage homePage= new HomePage();

    @Before
     public void setup()
    {
       TestBase.intilization();
    }

    @After
    public  void tearDown()
    {
     driver.quit();
    }

    @Given("^User is already on Home page$")
    public void user_is_already_on_Home_page() throws Throwable{

        Assert.assertEquals(homePage.getTitle(), "All-in-One Marketing Platform - Mailchimp");

    }

    @When("^User click on login button$")
    public void user_click_on_login_button() throws Throwable {

        loginPage = homePage.goToLoginPage();

    }

    @Then("^User enters another \"(.*)\" and \"(.*)\"$")
    public void user_enters_another_username_and_password(String username, String password) throws Throwable {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("^User submit on login button$")
    public void user_submit_on_login_button() throws Throwable {
        loginPage.clickOnLoginBtn();

    }
}
