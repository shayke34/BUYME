package Flow;


import PageObject.ResultsPage;

import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ResultsPageFlow {
     ResultsPage ResultsPage;
    SearchPageFlow SearchPageFlow;
    RegisterFlow RegisterFlow;

    public ResultsPageFlow(WebDriver driver) {
        super();
        ResultsPage = new ResultsPage(driver);
        SearchPageFlow=new SearchPageFlow(driver);
        RegisterFlow=new RegisterFlow(driver);
    }
    public  void results() throws ParserConfigurationException, IOException, SAXException {
        ResultsPage.assertPage();
        ResultsPage.resultTitle();
    }
}
