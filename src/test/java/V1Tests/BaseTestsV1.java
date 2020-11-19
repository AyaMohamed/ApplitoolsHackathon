package V1Tests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import Pages.FilteredProductPage;
import Pages.ProductDetalisPage;

public class BaseTestsV1 {

    protected static WebDriver driver;
    protected static Eyes eyes;
    protected static FilteredProductPage FilteredPage;
    protected static ProductDetalisPage ProductPage;

    @BeforeClass
    public static void setUp() {

        Properties props = System.getProperties();
        try
        {
            props.load(new FileInputStream(new File("resources/test.properties")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new ChromeDriver();
        initiateEyes();
        FilteredPage=new FilteredProductPage(driver);
        ProductPage=new ProductDetalisPage(driver);
        goHome();

    }
    @BeforeMethod
    public static void goHome(){

        //part one
        driver.get("https://demo.applitools.com/tlcHackathonMasterV1.html");
    }


    @AfterClass
    public static void tearDown()
    {
        driver.quit();
        eyes.close();
        eyes.abortIfNotClosed();
    }

    private static void initiateEyes()
    {
        VisualGridRunner runner = new VisualGridRunner(10);
        eyes = new Eyes(runner);
        eyes.setApiKey(System.getProperty("applitools.api.key"));
        Configuration suiteConfig = (Configuration) new Configuration()
                .addBrowser(new DesktopBrowserInfo(1200, 800, BrowserType.CHROME))
                .setViewportSize( new RectangleSize(1200, 800)) ;
        suiteConfig.setBatch(new BatchInfo("Testing Lifecycle"));
        eyes.setConfiguration(suiteConfig);
    }

    public void validateWindow()
    {
        eyes.open(driver,"APPLIFASHION","Test 1");
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow("main page");
       eyes.close();
    }
    public void validateFilterByColor()
    {
        eyes.open(driver,"APPLIFASHION","Test 2");
        eyes.checkRegion(By.id("product_grid"));
        eyes.checkWindow("filter by color");
        eyes.close();
    }
    public void validateProductDetailsPage()
    {
        eyes.open(driver,"APPLIFASHION","Test 3");
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow("product details");
        eyes.close();
    }



}