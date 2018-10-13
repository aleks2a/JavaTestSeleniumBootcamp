package uiAutomation.test.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uiAutomation.test.BaseTest;
import uiAutomation.test.pages.google.MainPage;
import uiAutomation.test.pages.google.ResultPage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void test001() {
        String queryString = "Portnov";

        MainPage mainPage = new MainPage(driver);
        ResultPage resultPage = new ResultPage(driver);

        mainPage.open();
        mainPage.typeRequestInSearchInput(queryString);


        mainPage.submitSearch();
        resultPage.printOutResutls();

        String actualPageTitle = resultPage.getPageTitle();
        String expectedPageTitle = "Portnov - Google Search";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }
}
