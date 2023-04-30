package PageObject;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



public class SearchPage extends BasePage {
    BaseTest BaseTest;
    public SearchPage (WebDriver driver) {super(driver);
        BaseTest=new BaseTest(driver);}

    By amountField = By.cssSelector("span[alt='סכום']");
    By regionField = By.cssSelector("span[alt='אזור']");
    By categoryfield = By.cssSelector("span[alt='קטגוריה']");
    By amountDropdown = By.cssSelector("li[value='3']");
    By regionDropdown = By.cssSelector("li[value='9']");
    By categoryDropdown = By.cssSelector("li[value='22']");
    By advertisment = By.cssSelector("div.adoric_element.element-shape.closeLightboxButton");
    By findMeGiftButton = By.cssSelector("a[rel='nofollow']");

    public By account=By.partialLinkText("החשבון שלי");

    public SearchPage assertPage () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertTitle(driver.getCurrentUrl(),BaseTest.readFrom("homePageUrl",BaseTest.getXmlPath()));
        return this;
    }

    public SearchPage amountField (){
        adClose(advertisment);
    clickItem(amountField);
    return this;
}
    public SearchPage amountDropdown(){
        adClose(advertisment);
    clickItem(amountDropdown);
    return this;
}
    public SearchPage regionField(){
        adClose(advertisment);
    clickItem (regionField);
    return this;
}
    public SearchPage regionDropdown (){
        adClose(advertisment);
    clickItem(regionDropdown);
    return this;
    }
    public SearchPage categoryfield (){
        adClose(advertisment);
    clickItem(categoryfield);
    return this;
    }
    public SearchPage categoryDropdown(){
        adClose(advertisment);
    clickItem(categoryDropdown);
    return this;
    }
    public SearchPage findMeGiftButton(){
        adClose(advertisment);
    clickItem(findMeGiftButton);
        return this;
    }
}

