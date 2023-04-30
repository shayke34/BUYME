package PageObject;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



public class ResultsPage extends BasePage{
    BaseTest BaseTest;
        public ResultsPage (WebDriver driver)
        {super(driver);
            BaseTest=new BaseTest(driver);}
    By resultTitle= By.partialLinkText("AZRIELI GIFTCARD");

    public ResultsPage assertPage () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertTitle(driver.getCurrentUrl(),BaseTest.readFrom("resultUrl",BaseTest.getXmlPath()));
        return this;
    }

    public ResultsPage resultTitle (){
        clickItem(resultTitle);
        return this;
    }





}

