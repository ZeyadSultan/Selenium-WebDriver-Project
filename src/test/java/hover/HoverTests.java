package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        var hoversPage = homePage.clickHovers();
        var captions = hoversPage.hoverOverFigure(1);
        assertTrue("Captions is not Displayed", captions.isCaptionDisplayed());
        assertEquals("Captions title is not equal",captions.getTitle(), "name: user1");
        assertEquals("Captions link is not equal",captions.getLinkText(),"View profile");
        assertTrue("link incorrect", captions.getLink().endsWith("/users/1"));

    }

}
