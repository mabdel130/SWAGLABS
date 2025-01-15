package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static drivers.DriverHolder.getDriver;
import static testcases.TC04_Add_My_Info.*;

public class TC07_Return_Back_to_Continue_Shopping extends BaseTest {

    @Test(priority = 1, description = "Verify That user can Continue Shopping")
    public void Continue_Shopping_P() throws InterruptedException {
// TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();


        // TODO: select products
        new P02_SelectProductsPage(getDriver()).selectRandomProducts(3, 6).clickOnShoppingCartButton();
        Thread.sleep(500);


        // TODO: select checkout step one
        new P03_Checkout_step_onePage(getDriver()).clickoncheckoutbutton();
        Thread.sleep(500);

        // TODO: Add my caret info
        new P04_Add_My_infoPage(getDriver())
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enter_Zip_Postalcode(zip_Postalcode)
                .clickonCONTINUEbutton();
        Thread.sleep(500);
        //TODO: checkout-step-two
        new P05_checkout_step_twoPage(getDriver()).retrieveTotalPriceBeforeTax().retrieveTax()
                .retrieveTotalPriceAfterTax().printCheckoutSummary();
        // TODO: checkout Return Back
        new P07_Return_Back_to_Continue_ShoppingPage(getDriver()).continue_Shopping();
        Thread.sleep(1000);


        // TODO: select products
        new P02_SelectProductsPage(getDriver()).remove_Products()
                .clickOnShoppingCartButton();


        // TODO: select checkout step one
        new P03_Checkout_step_onePage(getDriver()).clickoncheckoutbutton();
        Thread.sleep(500);

        // TODO: Add my caret info
        new P04_Add_My_infoPage(getDriver())
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enter_Zip_Postalcode(zip_Postalcode)
                .clickonCONTINUEbutton();
        Thread.sleep(500);

        //TODO: checkout-step-two
        new P05_checkout_step_twoPage(getDriver()).retrieveTotalPriceBeforeTax().retrieveTax().retrieveTotalPriceAfterTax().printCheckoutSummary().clickOnFinishButton();


        P06_Complete_checkoutPage checkoutCompletePage = new P06_Complete_checkoutPage(getDriver())
                .Confirm_my_order();
        Thread.sleep(500);

        String actualMessage = checkoutCompletePage.getOrderConfirmationMessage();


        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match!");
        Thread.sleep(500);


    }
}