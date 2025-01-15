package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_SelectProductsPage;
import pages.P03_Checkout_step_onePage;
import pages.P04_Add_My_infoPage;

import static drivers.DriverHolder.getDriver;
import static util.Utlity.*;


public class TC04_Add_My_Info extends BaseTest {


    static String firstname = generateRandomCapitalizedFirstName();
    static String lastname = generateRandomCapitalizedLastName();
    static String zip_Postalcode = generateRandomPostalCode();


    @Test(priority = 1, description = "Checkout my cart")
    public void verify_Mycart_info_P() throws InterruptedException {
        // TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();


        // TODO: select products
        new P02_SelectProductsPage(getDriver()).selectRandomProducts(3,5)
                .clickOnShoppingCartButton();



        // TODO: select checkout
        new P03_Checkout_step_onePage(getDriver()).clickoncheckoutbutton();
        // TODO: Add my care info
        new P04_Add_My_infoPage(getDriver()).enterFirstName(firstname).enterLastName(lastname).enter_Zip_Postalcode(zip_Postalcode).clickonCONTINUEbutton();
    }
}
