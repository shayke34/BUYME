package Test;

import Flow.SearchPageFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import PageObject.SearchPage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SearchPageTest extends BaseTest{

    SearchPage SearchPage;

    public SearchPageTest() {
        super(driver);
        SearchPage=new SearchPage(driver);
    }
    @Test
    public void searchPage () throws InterruptedException, ParserConfigurationException, IOException, SAXException {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");
        RegisterFlow.register();
        Thread.sleep(750);

        SearchPageFlow.search();

    }
}
