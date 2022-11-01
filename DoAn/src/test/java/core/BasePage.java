package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.List;

public class BasePage {
    private long TIME_OUT = 30;
    private WebDriverWait wait;



    public WebElement getFindElementByXpath(WebDriver driver, String element) {
        return driver.findElement(By.xpath(element));
    }

    public WebElement getFindElementById(WebDriver driver, String element) {
        return driver.findElement(By.id(element));
    }

    public void clickElementByXpath(WebDriver driver, String element) {
        getFindElementByXpath(driver, element).click();
    }

    public void clickElementById(WebDriver driver, String element) {
        getFindElementById(driver, element).click();
    }

    public void sendKeyElementByXpath(WebDriver driver, String element, String value) {
        getFindElementByXpath(driver, element).sendKeys(value);
    }

    public WebElement waitForElementVisible(WebDriver driver, String element) {
        wait = new WebDriverWait(driver, TIME_OUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getTimeLocatorByXpath(driver, element)));
    }

    public List<WebElement> waitForAllElementPresence(WebDriver driver,String element)
    {
        wait = new WebDriverWait(driver, TIME_OUT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getTimeLocatorByXpath(driver,element)));
    }
    public By getTimeLocatorByXpath(WebDriver driver, String element) {
        return By.xpath(element);
    }
}
