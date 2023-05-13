package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/"); // getting the link we will work on
        driver.manage().window().maximize(); // maximize the window
        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content")); // getting the element
        shiftingContent.click(); // clicking on it
        WebElement ex1 = driver.findElement(By.linkText("Example 1: Menu Element"));
        ex1.click();
        System.out.println(driver.findElements(By.tagName("li")).size()); // getting the size of the list
        driver.quit(); // closing the session of the whole browser
    }

    public static void main(String args[]) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
