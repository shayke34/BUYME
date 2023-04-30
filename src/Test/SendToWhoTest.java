package Test;

import Flow.AmountGiftCardFlow;
import Flow.ResultsPageFlow;
import Flow.SearchPageFlow;
import Flow.SendToWhoFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SendToWhoTest extends BaseTest {
    SendToWhoFlow SendToWhoFlow;
    ResultsPageFlow ResultsPageFlow;
    AmountGiftCardFlow AmountGiftCardFlow;
    public SendToWhoTest() {
        super(driver);
        SendToWhoFlow =new SendToWhoFlow(driver);
        ResultsPageFlow=new ResultsPageFlow(driver);
        AmountGiftCardFlow=new AmountGiftCardFlow(driver);
    }
    @Test
    public void SendToWhoClick () throws ParserConfigurationException, IOException, SAXException, InterruptedException{
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");
        RegisterFlow.register();
        SearchPageFlow.search();
        ResultsPageFlow.results();
        AmountGiftCardFlow.clickAmountGiftCardButton();
        SendToWhoFlow.sendToWho();

    }
}
