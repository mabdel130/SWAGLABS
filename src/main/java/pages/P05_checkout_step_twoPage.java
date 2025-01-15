package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_checkout_step_twoPage extends BasePage {


    public P05_checkout_step_twoPage(WebDriver driver) {
        super(driver);
    }


    private static final By totalPrice_Before_Tax = By.cssSelector(".summary_subtotal_label");
    private static final By tax = By.cssSelector(".summary_tax_label");
    private static final By totalPrice_After_Tax = By.cssSelector(".summary_total_label");
    private static final By finishButton = By.cssSelector(".btn_action.cart_button");


    static private String totalPriceBeforeTax;
    static private String taxValue;
    static private String totalAfterTax;


    public P05_checkout_step_twoPage retrieveTotalPriceBeforeTax() {
        totalPriceBeforeTax = driver.findElement(totalPrice_Before_Tax).getText();
        return this;
    }


    public P05_checkout_step_twoPage retrieveTax() {
        taxValue = driver.findElement(tax).getText();
        return this;
    }


    public P05_checkout_step_twoPage retrieveTotalPriceAfterTax() {
        totalAfterTax = driver.findElement(totalPrice_After_Tax).getText();
        return this;
    }


    public P05_checkout_step_twoPage printCheckoutSummary() {
        System.out.println("Checkout Summary:");
        System.out.println("Total Price Before Tax: " + totalPriceBeforeTax);
        System.out.println("Tax: " + taxValue);
        System.out.println("Total Price After Tax: " + totalAfterTax);
        return new P05_checkout_step_twoPage(driver);
    }


    public P05_checkout_step_twoPage clickOnFinishButton() {
        driver.findElement(finishButton).click();
        return this;
    }
}
