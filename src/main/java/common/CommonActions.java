package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static common.Config.PLATFORM_AND_BROWSER;

public class CommonActions {

    protected static WebDriver driver;

        @BeforeMethod
        public WebDriver getDriver(){
            switch (PLATFORM_AND_BROWSER){
                case"macOS_chrome":
                    System.setProperty("webdriver.chrome.driver", "/Users/adriankostya/browsersDrivers/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "win_chrome":
                    System.out.println("win");
                default:
                    Assert.fail("Platform of browser is incorrect :"+PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            return driver;
        }

        @AfterMethod
    public void afterMethod(){
            driver.quit();
        }





}
