package Utility;
import Pages.HomePage;
import Pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties properties;
    public static WebDriver driver;
    public  static HomePage homePage;
    public static LoginPage loginPage;
    public static FileInputStream file;

    public  TestBase()  {
        try {

            properties = new Properties();
            file = new FileInputStream("./src/main/java/config/configuration.properties");
            properties.load(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static WebDriver launchBrowser() {

        String browser= properties.getProperty("Browser");
        if (browser.equals("Chrome")) {
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver","chromedriver");
            return new ChromeDriver();
        }
        else if (browser.equals("Safari")) {

            return new SafariDriver();
        } else if (browser.equals("FireFox")) {
            //WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            return driver=null;
        }
    }

    public static void intilization() {

        driver= launchBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(properties.getProperty("Url"));
        homePage= new HomePage();
    }

}
