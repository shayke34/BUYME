package Flow;


import PageObject.SearchPage;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;



public class SearchPageFlow {
     SearchPage SearchPage;
    RegisterFlow RegisterFlow;


    public SearchPageFlow (WebDriver driver) {
        super();
        RegisterFlow=new RegisterFlow(driver);
        SearchPage = new SearchPage(driver);

    }
    public void search () throws ParserConfigurationException, IOException, SAXException, InterruptedException {
        Thread.sleep(1250);
        SearchPage.assertPage();
        Thread.sleep(750);
    SearchPage.amountField();

    SearchPage.amountDropdown();

    SearchPage.regionField();

    SearchPage.regionDropdown();

    SearchPage.categoryfield();

    SearchPage.categoryDropdown();

    SearchPage.findMeGiftButton();
    }

}