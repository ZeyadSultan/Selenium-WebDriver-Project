package fileUpload;
import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class fileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/zeyad/Desktop/ZeyadSultanResume.pdf");
        assertEquals( "Uploaded files incorrect","ZeyadSultanResume.pdf",uploadPage.getUploadedFiles());
    }

}
