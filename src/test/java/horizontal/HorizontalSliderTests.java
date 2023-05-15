package horizontal;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends BaseTests {
    @Test
    public void testSlider() {
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setRangeValue("4");
        Assert.assertEquals(sliderPage.getRangeValue(), "4", "Slider value is incorrect");
    }
}
