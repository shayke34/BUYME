package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Test.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    static BaseTest BaseTest;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        BaseTest=new BaseTest(driver);
    }

    public void sendKeys(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void clickItem(By by)  {
        waitElement(by);
        driver.findElement(by).click();
    }

    public  void adClose(By by)
    {
        if (driver.findElement(by).isDisplayed())
            clickItem(by);
    }

    public static void waitElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
