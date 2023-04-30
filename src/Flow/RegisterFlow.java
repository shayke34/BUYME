package Flow;

import Test.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import PageObject.RegisterPage;
import PageObject.HomePage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RegisterFlow {
     HomePage HomePage;
     RegisterPage RegisterPage;
    BaseTest BaseTest;

    public RegisterFlow(WebDriver driver) {
        super();
        HomePage=new HomePage(driver);
        RegisterPage=new RegisterPage(driver);
        BaseTest=new BaseTest(driver);
    }


    public void register() throws ParserConfigurationException, IOException, SAXException {

        RegisterPage.assertMain();
        HomePage.buttonClick();

        RegisterPage.registerButtonClick();
        RegisterPage.assertLogin();

        RegisterPage.fillPrivateNameText();
        RegisterPage.fillEmailText();
        RegisterPage.fillPasswordText();
        RegisterPage.checkPasswordText();
        RegisterPage.agreeCheckBoxButton();
        RegisterPage.submitButton();
    }
}
