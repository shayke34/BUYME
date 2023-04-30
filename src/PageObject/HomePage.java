package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {super(driver);}

    By registerButton = By.cssSelector("li[class='notSigned']");

     public HomePage buttonClick()
     {
          clickItem(registerButton);
         return this;
     }

}
