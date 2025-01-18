package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_SelectProductsPage;

import static drivers.DriverHolder.getDriver;

public class TC02_SelectProducts extends BaseTest {
    private static Object input;


    @Test(priority = 1, description = "Add Product from product page")
    public void verifyUserCanAddProductSuccessfully_P() throws InterruptedException {
        // TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();

        // TODO: select products
        new P02_SelectProductsPage(getDriver()).selectRandomProducts(3,5).clickOnShoppingCartButton();






    }
}
