package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        this.navigate = driver.navigate();
    }

    public void goForward() {
        this.navigate.forward();
    }

    public void goBack() {
        this.navigate.back();
    }

    public void refresh() {
        this.navigate.refresh();
    }

    public void goToUrl(String url) {
        this.navigate.to(url);
    }

    public void swithToTab(String tabTitle) {
        var windows = driver.getWindowHandles();

        System.out.println("No of Tabs: " + windows.size());
        System.out.println("Handles");
        windows.forEach(System.out::println);

        for(String window: windows) {
            System.out.println("Switching to: " + window);

            driver.switchTo().window(window);

            System.out.println("Current Window Title: "+ driver.getTitle());

            if(tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }
}
