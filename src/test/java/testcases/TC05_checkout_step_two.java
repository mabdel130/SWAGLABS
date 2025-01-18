package testcases;

import org.testng.annotations.Test;
import pages.*;
import static drivers.DriverHolder.getDriver;
import static testcases.TC04_Add_My_Info.*;
public class TC05_checkout_step_two extends BaseTest {
    @Test(priority = 1, description = "checkout_step_two")
    public void verifyUser_checkout_Successfully_step_two_P() throws InterruptedException {
        // TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();


        // TODO: select products
        new P02_SelectProductsPage(getDriver()).selectRandomProducts(3,5)
                .clickOnShoppingCartButton();

        // TODO: select checkout step one
        new P03_Checkout_step_onePage(getDriver()).clickoncheckoutbutton();

        // TODO: Add my care info
        new P04_Add_My_infoPage(getDriver())
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enter_Zip_Postalcode(zip_Postalcode)
                .clickonCONTINUEbutton();
        // TODO: checkout-step-two
        new P05_checkout_step_twoPage(getDriver()).retrieveTotalPriceBeforeTax().retrieveTax()
                .retrieveTotalPriceAfterTax().printCheckoutSummary().clickOnFinishButton();




    }
}
