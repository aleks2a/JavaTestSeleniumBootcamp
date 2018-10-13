package uiAutomation.test.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static uiAutomation.test.BaseTest.sleepFor;

public class MainPage {

    WebDriver driver;

    public static By searchInput =  By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input");
    public static By submitButton = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div/centeadsdr/input[1]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        driver.get("http://google.com");
    }

    public void typeRequestInSearchInput(String queryString) {
        driver.findElement(searchInput).sendKeys(queryString);
        sleepFor(5);
    }



    public void submitSearch() {
        driver.findElement(submitButton).click();
    }
}
