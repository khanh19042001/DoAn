package page.OBJ;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.UI.HomePageAddProductUI;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HomePageAddProductObj extends BasePage {
    WebDriver driver;

    public HomePageAddProductObj(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkThemSanPham() {
        waitForElementVisible(driver, HomePageAddProductUI.A_THEMSANPHAM);
        clickElementByXpath(driver, HomePageAddProductUI.A_THEMSANPHAM);
    }

    public void selectDanhMuc() {
        WebElement btnSelect = waitForElementVisible(driver, HomePageAddProductUI.SEl_DANHMUC);
        btnSelect.click();
        List<WebElement> danhmuc = waitForAllElementPresence(driver, HomePageAddProductUI.CATEGORY_LIST);
        Random random = new Random();
        int index = random.nextInt(danhmuc.size() - 1);
        WebElement option = danhmuc.get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        option.click();
    }

    public void clickSanPhamNoiBat() {
        clickElementByXpath(driver, HomePageAddProductUI.CHECKBOX_SPNOIBAT);
    }

    public void sanPham(String tenSP, String gioiThieu, String chiTiet, String gia, String phanTramGia) {
        sendKeyElementByXpath(driver, HomePageAddProductUI.TXT_TENSP, tenSP);
        selectDanhMuc();
        sendKeyElementByXpath(driver, HomePageAddProductUI.TXT_GIOITHIEU, gioiThieu);
        sendKeyElementByXpath(driver, HomePageAddProductUI.TXT_CHiTIET, chiTiet);
        sendKeyElementByXpath(driver, HomePageAddProductUI.TXT_GIA, gia);
        sendKeyElementByXpath(driver, HomePageAddProductUI.TXT_PHANTRAMGIA, phanTramGia);
    }

    public void importImage(String file) {
        String path = System.getProperty("user.dir");
        String img = path + file;
        WebElement inputFile = getFindElementByXpath(driver, HomePageAddProductUI.FILE_ANH);
        inputFile.sendKeys(img);
    }

    public void clickBtnThemSanPham() {
        clickElementByXpath(driver, HomePageAddProductUI.BTN_THEMSANPHAM);
    }

    public void addProduct(String tenSP, String gioiThieu, String chiTiet, String gia, String phanTramGia, String file) {
        clickLinkThemSanPham();
        sanPham(tenSP, gioiThieu, chiTiet, gia, phanTramGia);
        importImage(file);
        clickBtnThemSanPham();
    }

    public void addProductFeatured(String tenSP, String gioiThieu, String chiTiet, String gia, String phanTramGia, String file) {
        clickLinkThemSanPham();
        sanPham(tenSP, gioiThieu, chiTiet, gia, phanTramGia);
        clickSanPhamNoiBat();
        importImage(file);
        clickBtnThemSanPham();
    }
}
