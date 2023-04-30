package PageObject;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static Test.BaseTest.readFrom;

public class AmountGiftCard extends BasePage {
    public AmountGiftCard() {
        super(driver);
    }
    By amountGiftCard = By.cssSelector("input[placeholder='הכנס סכום']");
    By amountGiftCardButton = By.cssSelector("div.mx-12.money-btn");

    public AmountGiftCard enterAmountGiftCard() throws ParserConfigurationException, IOException, SAXException {
        sendKeys(amountGiftCard,BaseTest.readFrom("amountGiftCard",BaseTest.getXmlPath()));
        return this;
    }
    public AmountGiftCard assertPage () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertTitle(driver.getCurrentUrl(),readFrom("productUrl",BaseTest.getXmlPath()));
        return this;
    }
    public AmountGiftCard clickAmountGiftCard (){
        clickItem(amountGiftCardButton);
        return this;
    }
}
