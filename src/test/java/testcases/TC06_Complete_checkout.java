package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static drivers.DriverHolder.driver;
import static drivers.DriverHolder.getDriver;

import static pages.BasePage.captureScreenshot;
import static testcases.TC04_Add_My_Info.*;

public class TC06_Complete_checkout extends BaseTest {

    @Test(priority = 1, description = "Verify order confirmation message")
    public void confirmationOrder_P() throws InterruptedException {
        // TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();
        captureScreenshot(getDriver(), "login");
        // TODO: select products
        new P02_SelectProductsPage(getDriver()).selectRandomProducts(3, 5)
                .clickOnShoppingCartButton();


        // TODO: select checkout step one
        new P03_Checkout_step_onePage(getDriver()).clickoncheckoutbutton();

        // TODO: Add my care info
        new P04_Add_My_infoPage(getDriver())
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enter_Zip_Postalcode(zip_Postalcode)
                .clickonCONTINUEbutton();
        captureScreenshot(getDriver(), "Add my care info");
        //TODO: checkout-step-two
        new P05_checkout_step_twoPage(getDriver()).retrieveTotalPriceBeforeTax().retrieveTax()
                .retrieveTotalPriceAfterTax().printCheckoutSummary().clickOnFinishButton();

        captureScreenshot(getDriver(), "checkout_step_twoPage");
        P06_Complete_checkoutPage checkoutCompletePage = new P06_Complete_checkoutPage(getDriver())
                .Confirm_my_order();


        String actualMessage = checkoutCompletePage.getOrderConfirmationMessage();


        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match!");


    }
}
