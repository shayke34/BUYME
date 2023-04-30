package Test;

import Flow.RegisterFlow;
import Flow.ResultsPageFlow;
import Flow.SearchPageFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Flow.ResultsPageFlow;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ResultPageTest extends BaseTest {
    ResultsPageFlow ResultsPageFlow;
    public ResultPageTest() {
        super(driver);
        ResultsPageFlow=new ResultsPageFlow(driver);
    }

@Test
    public void resultPage() throws ParserConfigurationException, IOException, SAXException, InterruptedException {
    myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
    myTests.log(LogStatus.INFO, "Test Start");
    RegisterFlow.register();
    Thread.sleep(750);
       SearchPageFlow.search();
    Thread.sleep(750);
        ResultsPageFlow.results();


}

}
