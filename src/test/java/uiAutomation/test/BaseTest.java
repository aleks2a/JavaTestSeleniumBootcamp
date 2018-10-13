package uiAutomation.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        if(System.getProperty("os.name").startsWith("Windows")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\win64\\geckodriver.exe");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\win64\\chromedriver.exe");
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\win64\\IEDriver.exe");

        }

        if(System.getProperty("os.name").startsWith("Mac")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/macOS/geckodriver");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/macOS/chromedriver");
        }
    }

    @Parameters(value = "browser")
    @BeforeMethod
    public void setupBroswer(@Optional("FF") String browser){
        switch (browser){
            case "FF" : driver = new FirefoxDriver(); break;
            case "Chrome" : driver = new ChromeDriver(); break;
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(!result.isSuccess()){
            takeScreenshot(result);
        }

        driver.quit();
    }

    private void takeScreenshot(ITestResult result){
        try {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String fileName = "/" + result.getInstanceName() + "/" + result.getName() + ".png";
            String filePath = System.getProperty("user.dir")
                    + "/screenshots/" + fileName.replace(" ", "");
            File destFile = new File(filePath);
            FileUtils.copyFile(screenshot,destFile);
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sleepFor(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitFor(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
