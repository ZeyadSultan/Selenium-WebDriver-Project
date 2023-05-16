package navigation;

import base.BaseTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample2();
        getWindowManager().goBack();
        getWindowManager().goForward();
        getWindowManager().refresh();
        getWindowManager().goToUrl("https://www.linkedin.com/in/zeyadsultan/");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindowsPage().clickHere();
        getWindowManager().swithToTab("New Window");
    }
}
