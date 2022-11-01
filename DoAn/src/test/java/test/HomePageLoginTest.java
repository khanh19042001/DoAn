package test;

import Utils.Helps.CaptureHelpers;
import Utils.Listener.ReportListener;
import core.BaseTest;
import Utils.Logs.Log;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.OBJ.HomePageLoginObj;

@Listeners(ReportListener.class)
@Feature("HomePageLoginTest") // để chạy allure
public class HomePageLoginTest extends BaseTest {
    HomePageLoginObj objHomePageLogin;

    @Parameters("url")
    @BeforeMethod
    public void beforeMethod(String url) {
        objHomePageLogin = new HomePageLoginObj(driver);
        driver.get(url);
    }

    @Test(dataProvider = "test_data_login", dataProviderClass = FromDataProvider.class)
    @Step("Login in page")
    public void TC_Login(String email, String pass) {
        Log.info("Chạy test case: TC_LOGIN");
        objHomePageLogin.Login(email, pass);
        objHomePageLogin.clickBtnLogin();

    }
}
