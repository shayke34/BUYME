package Test;

import Flow.SearchPageFlow;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import PageObject.BasePage;
import PageObject.LoginPage;
import PageObject.RegisterPage;
import PageObject.HomePage;
import PageObject.ResultsPage;
import PageObject.HowToSend;
import PageObject.SendToWho;
import PageObject.SearchPage;

import Flow.RegisterFlow;

import static org.junit.Assert.assertEquals;


public class BaseTest {
    static BasePage BasePage;
    static HomePage HomePage;
    static HowToSend HowToSend;
    static LoginPage LoginPage;
    static RegisterPage RegisterPage;
    static ResultsPage ResultsPage;
    static SendToWho SendToWho;
    static SearchPage SearchPage;
    static RegisterFlow RegisterFlow;
    static SearchPageFlow SearchPageFlow;
    public String getXmlPath;
    static String reportPath="C:\\Users\\shayg\\IdeaProjects\\BUYME\\src\\data\\testReport.html";
    static String imagePath="C:\\Users\\shayg\\IdeaProjects\\BUYME\\images\\";
    static ExtentTest myTests;
    static ExtentReports extent;

    public static void initalPage (){
        BasePage =new BasePage(driver);
        HomePage =new HomePage(driver);
        HowToSend =new HowToSend(driver);
        LoginPage =new LoginPage(driver);
        RegisterPage =new RegisterPage(driver);
        ResultsPage =new ResultsPage(driver);
        SendToWho =new SendToWho(driver);
        SearchPage =new SearchPage(driver);
        RegisterFlow=new RegisterFlow(driver);
        SearchPageFlow=new SearchPageFlow(driver);
    }
    private static String xmlPath="C:\\Users\\shayg\\IdeaProjects\\BUYME\\src\\data\\config.xml";
public static WebDriver driver;
public BaseTest (WebDriver driver)
{
    this.driver = driver;
}
public static String getXmlPath()
{
    return xmlPath;
}
@BeforeClass
    public  static void beforeTest () throws ParserConfigurationException, IOException, SAXException {
    extent = new ExtentReports(reportPath);
    myTests = extent.startTest("Buyme.co.il - Test Report");
    String browser = BaseTest.readFrom("browser",getXmlPath());
    startBroswer(browser);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    initalPage();
    driver.get("https://www.buyme.co.il");

    }

    public String getiPath()
    {
        return imagePath;
    }
    public static String  readFrom(String keyData, String path) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(path);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
        Document doc = dbBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyData).item(0).getTextContent();
    }
    public static void startBroswer (String startBrowser)
    {
        if(startBrowser.equals("Chrome")){
            System.setProperty("webdriver.Chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("disable-popup-blocking");
            driver =new ChromeDriver(options);
        }else {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.33.0-win32\\geckodriver.exe");
            driver =new FirefoxDriver();
        }
    }
public void assertTitle(String actual,String excepted) throws IOException {myTests.log(LogStatus.INFO, "screen:" + myTests.addScreenCapture(takeScreenShot(getiPath() + "\\" + System.currentTimeMillis())));

    if (BaseTest.asserTitle(actual,excepted))
    {
        myTests.log(LogStatus.INFO, "current url:" +actual);
        myTests.log(LogStatus.INFO, "excepted url:" +excepted); // + myTests.addScreenCapture(takeScreenShot(imagePath + "\\" + System.currentTimeMillis())));
        myTests.log(LogStatus.PASS, "Test Pass");
    }
    else
    { myTests.log(LogStatus.INFO, "current url:" +actual);
        myTests.log(LogStatus.INFO, "excepted url:" +excepted);
        myTests.log(LogStatus.FAIL, "Test Fail");
    }
}

    public  void assertText(String actual, String excepted) throws IOException { myTests.log(LogStatus.INFO, "screen:" + myTests.addScreenCapture(takeScreenShot(getiPath() + "\\" + System.currentTimeMillis())));

        if (actual.contains(excepted))
        {
            myTests.log(LogStatus.INFO, "current text:" +actual);
            myTests.log(LogStatus.INFO, "excepted text:" +excepted); // + myTests.addScreenCapture(takeScreenShot(imagePath + "\\" + System.currentTimeMillis())));
            myTests.log(LogStatus.PASS, "Test Pass");
        }
        else
        { myTests.log(LogStatus.INFO, "current text:" +actual);
            myTests.log(LogStatus.INFO, "excepted text:" +excepted);
            myTests.log(LogStatus.FAIL, "Test Fail");
        }
    }

    public static boolean asserTitle(String actual, String excepted)
    {
        try{
            assertEquals(actual, excepted);
            return true;
        }catch(AssertionError e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static String  takeScreenShot(String ImagePath) throws IOException
    {


        TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagePath+".png");
        try
        {
            FileUtils.copyFile(screenShotFile,destinationFile);

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return ImagePath+".png";
    }

    @After
    public void afterEachTest()
    {
        extent.endTest(myTests);
    }

    @AfterClass
    public static void afterAllTest()
    {
        driver.close();
        driver.quit();
        extent.flush();
    }
}
