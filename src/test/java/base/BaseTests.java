package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import utils.WindowManager;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass // will run before each of the test classes
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/"); // getting the link we will work on

        homePage = new HomePage(driver);

    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
