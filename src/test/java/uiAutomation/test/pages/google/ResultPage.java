package uiAutomation.test.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    WebDriver driver;

    public static By resultStats = By.xpath("//*[@id=\"resultStats\"]");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void printOutResutls() {
        System.out.println(driver.findElement(resultStats).getText());
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
