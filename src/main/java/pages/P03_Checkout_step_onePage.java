package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_Checkout_step_onePage extends BasePage {
    public P03_Checkout_step_onePage(WebDriver driver) {
        super(driver);
    }

    private final By Checkoutbutton = By.cssSelector(".btn_action.checkout_button");

    public P02_SelectProductsPage clickoncheckoutbutton() {
        driver.findElement(this.Checkoutbutton).click();
        return new P02_SelectProductsPage(driver);

    }


}
