package Flow;

import PageObject.AmountGiftCard;
import PageObject.RegisterPage;
import PageObject.ResultsPage;
import PageObject.SearchPage;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AmountGiftCardFlow {
    ResultsPageFlow ResultsPageFlow;
    SearchPageFlow SearchPageFlow;
    RegisterFlow RegisterFlow;
    AmountGiftCard AmountGiftCard;

    public AmountGiftCardFlow (WebDriver driver){
        super();
        SearchPageFlow  = new SearchPageFlow(driver);
        RegisterFlow  = new RegisterFlow(driver);
        ResultsPageFlow  =new ResultsPageFlow(driver);
        AmountGiftCard=new AmountGiftCard();
    }
    public void clickAmountGiftCardButton () throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        Thread.sleep(750);
        AmountGiftCard.assertPage();
        AmountGiftCard.enterAmountGiftCard();
        AmountGiftCard.clickAmountGiftCard();
    }
}
