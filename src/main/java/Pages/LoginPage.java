package Pages;

import Utility.TestBase;
import Utility.waitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {
    //Page Factory OR



    By Username= By.id("username");

    By Password= By.id("password");

    By Login= By.xpath("//*[text()='Log in']");

    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username)
    {
        waitUtils.waitForVisiblity(driver, Username).sendKeys(username);
    }

    public void enterPassword(String paswword)
    {
        waitUtils.waitForVisiblity(driver,Password).sendKeys(paswword);
    }

    public void clickOnLoginBtn()
    {
        waitUtils.waitForVisiblity(driver, Login);
    }


}


