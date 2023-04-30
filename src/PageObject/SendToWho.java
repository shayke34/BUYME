package PageObject;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class SendToWho extends BasePage {
    BaseTest BaseTest;
    public SendToWho(WebDriver driver) {
        super(driver);
        BaseTest=new BaseTest(driver);
    }

    By WhoIsTheGiftForButton= By.cssSelector("div[gtm='למישהו אחר'");
    By receiverGiftNameField= By.cssSelector("input[title='שם מקבל המתנה']");
    By whatCelebratingField= By.cssSelector("span[alt='לאיזה אירוע?']");
    By whatCelebratingDropDown= By.cssSelector("li[value='10']");
    By congratulateField= By.cssSelector("textarea[placeholder='מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים']");
    By addPictureButton= By.cssSelector("input[accept='image/png,image/jpeg,video/quicktime,video/mp4,.mov,.qt']");
    By continueButton = By.cssSelector("button[gtm='המשך']");

    public SendToWho someoneElseButton (){
        clickItem(WhoIsTheGiftForButton);
        return this;
    }
    public SendToWho receiverGiftNameField() throws ParserConfigurationException, IOException, SAXException {
        sendKeys(receiverGiftNameField, BaseTest.readFrom("receiverGiftNameField", BaseTest.getXmlPath()));
        return this;
    }
    public SendToWho whatCelebratingField () {
        clickItem(whatCelebratingField );
        return this;
    }
    public SendToWho whatCelebratingDropDown (){
        clickItem(whatCelebratingDropDown);
        return this;
    }
    public SendToWho congratulateField () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(congratulateField, Test.BaseTest.readFrom("congratulateField", Test.BaseTest.getXmlPath()));
        return this;
    }
    public SendToWho addPictureButton () {
        WebElement addPicture = driver.findElement(addPictureButton);
        addPicture.sendKeys("C:\\Users\\shayg\\OneDrive\\תמונות\\Saved Pictures\\Opel-Corsa-2020.png");
        return this;
    }
    public SendToWho continueButton () throws InterruptedException {
        Thread.sleep(1000);
        clickItem(continueButton);
        return this;
    }
    public SendToWho assertPage () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertText(driver.getCurrentUrl(),BaseTest.readFrom("inviteUrl",BaseTest.getXmlPath()));
        return this;
    }


     }

