package PageObject;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



public class HowToSend extends BasePage {
    BaseTest BaseTest;
    public HowToSend (WebDriver driver) {
        super(driver);
        BaseTest = new BaseTest(driver);
    }

    By whenToSendButton= By.cssSelector("div[gtm='עכשיו']");
    By howToSendButton= By.cssSelector("svg[gtm='method-sms']");
    By phoneReceiverField = By.cssSelector("input[id='sms']");
    By whoIsTheGiftFromField = By.cssSelector("input[placeholder='שם שולח המתנה']");
    By SenderGiftPhoneField = By.cssSelector("input[placeholder='מספר נייד']");
    By continueToPurchaseButton = By.cssSelector("button[gtm='המשך לתשלום']");

    public HowToSend whenToSendButton () {
        clickItem(whenToSendButton);
        return this;
    }
    public HowToSend howTosendMethod (){
        clickItem(howToSendButton);
        return this;
    }
    public HowToSend phoneReceiverField () throws ParserConfigurationException, IOException, SAXException {
    sendKeys(phoneReceiverField,BaseTest.readFrom("phoneReceiverField", BaseTest.getXmlPath()));
    return this;
    }
    public HowToSend whoIsTheGiftFromField () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(whoIsTheGiftFromField, BaseTest.readFrom("whoIsTheGiftFromField", BaseTest.getXmlPath()));
        return this;
    }
    public HowToSend SenderGiftPhoneField () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(SenderGiftPhoneField, BaseTest.readFrom("SenderGiftPhoneField", BaseTest.getXmlPath()));
        return this;
    }
    public HowToSend continueToPurchaseButton (){
        clickItem(continueToPurchaseButton);
        return this;
    }
    public HowToSend assertPage () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertText(driver.getCurrentUrl(), BaseTest.readFrom("invite2Url",BaseTest.getXmlPath()));
        return this;
    }
    public HowToSend assertConfirmPage() throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertText(driver.getCurrentUrl(),BaseTest.readFrom("confirmUrl",BaseTest.getXmlPath()));

        return this;
    }
}
