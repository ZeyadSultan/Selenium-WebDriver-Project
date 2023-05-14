package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.selectFromDropdown("Option 1");
        var selectedOptions = dropdownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1,"size is not the same");
    }

}
