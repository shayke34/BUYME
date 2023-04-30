package Test;


import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RegisterTest extends BaseTest{
    public RegisterTest() {
        super(driver);
    }

    @Test
    public void registerTest() throws ParserConfigurationException, IOException, SAXException {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");
        RegisterFlow.register();

    }
}