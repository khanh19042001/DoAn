package test;

import Utils.Helps.CaptureHelpers;
import Utils.Listener.ReportListener;
import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import org.testng.annotations.*;
import page.OBJ.HomePageAddProductObj;
import page.OBJ.HomePageLoginObj;


@Listeners(ReportListener.class)
@Feature("HomePageAddProductTest")

public class HomePageAddProductTest extends BaseTest {
    HomePageAddProductObj objHomePageAddProduct;
    HomePageLoginObj objHomePageLogin;

    public void DangNhap() {
        objHomePageLogin.Login("admin@gmail.com", "123456");
        objHomePageLogin.clickBtnLogin();
    }

    @BeforeClass
    public void beforeClass() {
        DangNhap();
    }

    @Parameters("url")
    @BeforeMethod
    public void beforeMethod(String url) {
        objHomePageLogin = new HomePageLoginObj(driver);
        objHomePageAddProduct = new HomePageAddProductObj(driver);
        driver.get(url);
    }

    @Test(dataProvider = "test_data_add_product", dataProviderClass = FromDataProvider.class)
    @Step("Add Product")
    public void TC_AddProduct(String tenSP, String gioiThieu, String chiTiet, String gia, String phanTramGia, String file) {
        objHomePageAddProduct.addProduct(tenSP, gioiThieu, chiTiet, gia, phanTramGia, file);

    }

    @Test(dataProvider = "test_data_add_product", dataProviderClass = FromDataProvider.class)
    @Step("Thêm Sản Phẩm Nổi Bật")
    public void TC_AddProductFeatured(String tenSP, String gioiThieu, String chiTiet, String gia, String phanTramGia, String file) {
        objHomePageAddProduct.addProductFeatured(tenSP, gioiThieu, chiTiet, gia, phanTramGia, file);
    }
}
