package page.OBJ;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import page.UI.HomePageLoginUI;

public class HomePageLoginObj extends BasePage {
    public WebDriver driver;
    public HomePageLoginObj(WebDriver driver)
    {
        this.driver=driver;
    }
    public void Login(String email, String pass)
    {
        sendKeyElementByXpath(driver, HomePageLoginUI.TXT_EMAIL,email);
        sendKeyElementByXpath(driver,HomePageLoginUI.TXT_PASS,pass);
    }
    public void clickBtnLogin()
    {
        clickElementByXpath(driver,HomePageLoginUI.BTN_LOGIN);
    }
}
