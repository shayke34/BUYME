package Flow;

import PageObject.AmountGiftCard;
import PageObject.SendToWho;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SendToWhoFlow {
    RegisterFlow RegisterFlow;
    SearchPageFlow SearchPageFlow;
    ResultsPageFlow ResultsPageFlow;
    AmountGiftCardFlow AmountGiftCardFlow;
    SendToWho SendToWho;

    public SendToWhoFlow (WebDriver driver){
        super();
        RegisterFlow = new RegisterFlow(driver);
        SearchPageFlow = new SearchPageFlow(driver);
        ResultsPageFlow = new ResultsPageFlow(driver);
        AmountGiftCardFlow =new AmountGiftCardFlow(driver);
        SendToWho =new SendToWho(driver);
    }
    public void sendToWho () throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        SendToWho.assertPage();
        SendToWho.someoneElseButton();
        SendToWho.receiverGiftNameField();
        SendToWho.whatCelebratingField();
        SendToWho.whatCelebratingDropDown();
        SendToWho.congratulateField();
        SendToWho.addPictureButton();
        SendToWho.continueButton();
    }
}
