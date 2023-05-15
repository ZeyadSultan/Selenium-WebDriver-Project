package javascript;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFourthParagraph() {
        homePage.clickInfiniteScroll().scrollToParagraph(4);
    }

    @Test
    public void testAddMultipleAttributeToDropdown() {
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDropdown);

        var selectedOptions = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        Assert.assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
}