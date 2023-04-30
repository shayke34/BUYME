package PageObject;

import Test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Random;



public class RegisterPage extends BasePage {
    BaseTest BaseTest;
    public RegisterPage(WebDriver driver)
    {super(driver);
        BaseTest=new BaseTest(driver);}
    By registerButton= By.cssSelector("span[class='text-link theme']");
    By firstName = By.cssSelector("input[placeholder='שם פרטי']");
    By email = By.cssSelector("input[placeholder='מייל']");
    By password = By.cssSelector("input[placeholder='סיסמה']");
    By verifyPassword = By.cssSelector("input[placeholder='אימות סיסמה']");
    By agreeCheckBox = By.cssSelector("div.login-options.grid.register-text");
    By submitButton = By.cssSelector("button[gtm='הרשמה ל-BUYME']");

    public RegisterPage registerButtonClick ()
    {
        clickItem(registerButton);
        return this;
    }
    public RegisterPage fillPrivateNameText () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(firstName, BaseTest.readFrom("regFirstName", BaseTest.getXmlPath()));
        return this;
    }
    public RegisterPage fillEmailText () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(email, BaseTest.readFrom("regEmail", BaseTest.getXmlPath()));
        return this;
    }
    public RegisterPage fillPasswordText () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(password , BaseTest.readFrom("regPassword", BaseTest.getXmlPath()));
        return this;
    }
    public RegisterPage checkPasswordText () throws ParserConfigurationException, IOException, SAXException {
        sendKeys(verifyPassword, BaseTest.readFrom("regCheckPassword", BaseTest.getXmlPath()));
        return this;
    }
    public RegisterPage agreeCheckBoxButton ()  {
        clickItem(agreeCheckBox);
        return this;
    }
    public RegisterPage  submitButton () {
        clickItem(submitButton);
        return this;
    }

    public RegisterPage assertMain () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertTitle(driver.getCurrentUrl(),BaseTest.readFrom("homePageUrl",BaseTest.getXmlPath()));
        return this;
    }

    public RegisterPage assertLogin () throws ParserConfigurationException, IOException, SAXException {
        BaseTest.assertTitle(driver.getCurrentUrl(),BaseTest.readFrom("registerUrl",BaseTest.getXmlPath()));
        return this;
    }
}
