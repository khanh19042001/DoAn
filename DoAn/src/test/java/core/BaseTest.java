package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.annotation.Contract;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void intiBrowser(String browser) throws InterruptedException {
        if (browser.equals("Chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equals("Firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else {
            throw new InterruptedException("Error");
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
