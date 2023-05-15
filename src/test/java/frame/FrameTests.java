package frame;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FrameTests extends BaseTests {
    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWYSIWYG();
        editorPage.clearTextArea();

        String text1 = "Hello, ";
        String text2 = "Zeyad!";
        editorPage.clearTextArea();
        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals("Text from editor is incorrect", editorPage.getTextArea(), text1+text2);
    }
}
