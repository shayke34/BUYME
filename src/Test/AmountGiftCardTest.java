package Test;
import Flow.ResultsPageFlow;
import Flow.AmountGiftCardFlow;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AmountGiftCardTest extends BaseTest {
    AmountGiftCardFlow AmountGiftCardFlow;
    ResultsPageFlow ResultsPageFlow;
    public AmountGiftCardTest() {
        super(driver);
        AmountGiftCardFlow  = new AmountGiftCardFlow(driver);
        ResultsPageFlow = new ResultsPageFlow(driver);
    }
    @Test
    public void amountGiftCardClick() throws ParserConfigurationException, IOException, SAXException, InterruptedException{
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTests.log(LogStatus.INFO, "Test Start");
        //RegisterFlow.register();
        Thread.sleep(750);
        SearchPageFlow.search();
        Thread.sleep(750);
        ResultsPageFlow.results();
        Thread.sleep(750);
        AmountGiftCardFlow.clickAmountGiftCardButton();


    }
}
