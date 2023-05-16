package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class alertTests extends BaseTests {
    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        assertEquals("Results text incorrect", alertPage.getResult(), "You successfully clicked an alert");
    }
    @Test
    public void testGetTextFromAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerConfirm();
        String text = alertPage.alert_getText();
        alertPage.alert_clickToDismiss();
        assertEquals("Alert text incorrect", text, "I am a JS Confirm");
    }

    @Test
    public void testSetInputInAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerPrompt();
        String text = "Echo!";
        alertPage.alert_setInput(text);
        alertPage.alert_clickToAccept();
        assertEquals( "Results text incorrect", alertPage.getResult(), "You entered: " + text);
    }
}
