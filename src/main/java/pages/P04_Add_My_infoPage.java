package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_Add_My_infoPage extends BasePage {
    public P04_Add_My_infoPage(WebDriver driver) {
        super(driver);
    }

    static final By firstName = By.id("first-name");
    static final By lastName = By.id("last-name");
    public static final By zip_Postalcode = By.id("postal-code");
    static private final By CONTINUE = By.xpath("//input[@value='CONTINUE']");


    public P04_Add_My_infoPage enterFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
        return new P04_Add_My_infoPage(driver);

    }

    public P04_Add_My_infoPage enterLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
        return new P04_Add_My_infoPage(driver);

    }

    public P04_Add_My_infoPage enter_Zip_Postalcode(String zip_Postalcode) {
        driver.findElement(this.zip_Postalcode).sendKeys(zip_Postalcode);
        return new P04_Add_My_infoPage(driver);

    }

    public P02_SelectProductsPage clickonCONTINUEbutton() {
        driver.findElement(this.CONTINUE).click();
        return new P02_SelectProductsPage(driver);

    }

}