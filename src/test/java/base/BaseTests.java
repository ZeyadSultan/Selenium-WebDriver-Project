package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.File;
import java.io.IOException;

public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass // will run before each of the test classes
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        setCookie();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult test) {
        if(ITestResult.FAILURE == test.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + test.getName() + ".png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie(){
        var cookie = new org.openqa.selenium.Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
