package test;

import Util.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.ObjectInput;

public class FromDataProvider {
    @DataProvider(name = "test_data_login")
    public Object[][] dataForm() throws IOException
    {
        String path=System.getProperty("user.dir");
        String file=path+"\\src\\test\\resources\\DoAn.xlsx";
        Object[][] testDataLogin= ExcelUtil.getTableArray(file,"Login");
        return testDataLogin;
    }
    @DataProvider(name = "test_data_add_product")
    public Object[][] dataProduct() throws IOException
    {
        String path=System.getProperty("user.dir");
        String file=path+"\\src\\test\\resources\\DoAn.xlsx";
        Object[][] testDataAddProduct=ExcelUtil.getTableArray(file,"ThemSanPham");
        return  testDataAddProduct;
    }
}
