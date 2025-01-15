package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_SelectProductsPage;
import pages.P03_Checkout_step_onePage;

import static drivers.DriverHolder.getDriver;

public class TC03_Checkout_step_one extends BaseTest {

    @Test(priority = 1, description = "Checkout my cart")
    public void verifyUser_checkout_Successfully_P() throws InterruptedException {
        // TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();


        // TODO: select products
        new P02_SelectProductsPage(getDriver()).selectRandomProducts(3,5).clickOnShoppingCartButton();



        // TODO: select checkout
        new P03_Checkout_step_onePage(getDriver()).clickoncheckoutbutton();
        Thread.sleep(4000);
    }
}
