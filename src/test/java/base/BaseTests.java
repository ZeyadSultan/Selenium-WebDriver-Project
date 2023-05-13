package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/"); // getting the link we will work on
        driver.manage().window().maximize(); // maximize the window
        //driver.manage().window().fullscreen(); // setting it to full screen
        //driver.manage().window().setSize(new Dimension(375, 812)); // setting size
        System.out.println(driver.getTitle()); // getting the page title
        driver.quit(); // closing the session of the whole browser
    }

    public static void main(String args[]) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
