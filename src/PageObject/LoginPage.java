package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver)
    {super(driver);}
    By loginEmail = By.cssSelector("input[placeholder='מייל']");
    By loginPassword = By.cssSelector("input[placeholder='סיסמה']");
    By loginSubmitButton = By.cssSelector("button[gtm='כניסה ל-BUYME']");


}
