package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_Return_Back_to_Continue_ShoppingPage extends BasePage {
    public P07_Return_Back_to_Continue_ShoppingPage(WebDriver driver) {
        super(driver);
    }

    private final By returnBack_to_shopping_cart = By.xpath("//a[text()='CANCEL']");

    public P07_Return_Back_to_Continue_ShoppingPage continue_Shopping() {
        driver.findElement(this.returnBack_to_shopping_cart).click();
        return new P07_Return_Back_to_Continue_ShoppingPage(driver);
    }
}