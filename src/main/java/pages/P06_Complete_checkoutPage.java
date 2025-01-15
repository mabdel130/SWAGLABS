package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_Complete_checkoutPage extends BasePage {

    public P06_Complete_checkoutPage(WebDriver driver) {
        super(driver);
    }

    private final By order_confirmation = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

    // Method to confirm the order and allow chaining
    public P06_Complete_checkoutPage Confirm_my_order() {
        String confirmationMessage = driver.findElement(this.order_confirmation).getText();
        System.out.println("Order Confirmation Message: " + confirmationMessage);
        return this; // Return the current instance for chaining
    }


    public String getOrderConfirmationMessage() {
        return driver.findElement(order_confirmation).getText();
    }
}
