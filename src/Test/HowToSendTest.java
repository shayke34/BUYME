package Test;
import Flow.*;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class HowToSendTest extends BaseTest {
        HowToSendFlow HowToSendFlow;
        RegisterFlow RegisterFlow;
        SearchPageFlow SearchPageFlow;
        ResultsPageFlow ResultsPageFlow;
        AmountGiftCardFlow AmountGiftCardFlow;
        SendToWhoFlow SendToWhoFlow;

    public HowToSendTest() {
        super(driver);
        HowToSendFlow =new HowToSendFlow(driver);
        RegisterFlow =new RegisterFlow(driver);
        SearchPageFlow =new SearchPageFlow(driver);
        ResultsPageFlow =new ResultsPageFlow(driver);
        AmountGiftCardFlow =new AmountGiftCardFlow(driver);
        SendToWhoFlow =new SendToWhoFlow(driver);
    }

@Test
    public void howToSendClick () throws ParserConfigurationException, IOException, SAXException, InterruptedException {
            myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            myTests.log(LogStatus.INFO, "Test Start");
            RegisterFlow.register();
            SearchPageFlow.search();
            ResultsPageFlow.results();
            AmountGiftCardFlow.clickAmountGiftCardButton();
            SendToWhoFlow.sendToWho();
            HowToSendFlow.howToSend();

            }
}