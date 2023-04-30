package Flow;

import PageObject.HowToSend;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class HowToSendFlow {
    RegisterFlow RegisterFlow;
    SearchPageFlow SearchPageFlow;
    ResultsPageFlow ResultsPageFlow;
    AmountGiftCardFlow AmountGiftCardFlow;
    SendToWhoFlow SendToWhoFlow;
    HowToSend HowToSend;

    public HowToSendFlow (WebDriver driver){
        super();
        RegisterFlow =new RegisterFlow(driver);
        SearchPageFlow =new SearchPageFlow(driver);
        ResultsPageFlow =new ResultsPageFlow(driver);
        AmountGiftCardFlow =new AmountGiftCardFlow(driver);
        SendToWhoFlow =new SendToWhoFlow(driver);
        HowToSend = new HowToSend(driver);
    }
    public void howToSend () throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        HowToSend.assertPage();
        HowToSend.whenToSendButton();
        HowToSend.howTosendMethod();
        HowToSend.phoneReceiverField();
        HowToSend.whoIsTheGiftFromField();
        HowToSend.SenderGiftPhoneField();
        HowToSend.continueToPurchaseButton();
        Thread.sleep(750);
        HowToSend.assertConfirmPage();
    }
}
