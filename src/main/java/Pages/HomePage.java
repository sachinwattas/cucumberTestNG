package Pages;

import Utility.TestBase;
import Utility.waitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

    //Page Factory
    By LogIN = By.className("globalNavActions__login");

    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage() throws IOException {
        waitUtils.waitForVisiblity(driver, LogIN).click();
        return new LoginPage();
    }

    public String getTitle()
    {
       return driver.getTitle();
    }
}
