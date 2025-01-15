package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class P02_SelectProductsPage extends BasePage {

    static int numberOfProducts;

    public P02_SelectProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final By productNames = By.className("inventory_item_name");
    private static final By productPrices = By.className("inventory_item_price");
    private static final By addToCartButtons = By.cssSelector(".btn_inventory");
    private static final By shoppingCartIcon = By.xpath("//*[name()='path' and contains(@fill,'currentCol')]");
    private static final By removeButtons = By.cssSelector(".btn_secondary.btn_inventory");

    private final Map<String, Double> selectedProductDetails = new HashMap<>();
    private final List<Integer> selectedProductIndexes = new ArrayList<>();

    public List<WebElement> getAllProducts() {
        return driver.findElements(productNames);
    }
    private int getProductCount() {

        List<WebElement> productsInCart = driver.findElements(By.cssSelector(".cart_item"));
        return productsInCart.size();
    }

    public List<WebElement> getAllPrices() {
        return driver.findElements(productPrices);
    }

    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(addToCartButtons);
    }

    public P02_SelectProductsPage selectRandomProducts(int minProducts, int maxProducts) {
        Random random = new Random();
        numberOfProducts = random.nextInt(maxProducts - minProducts + 1) + minProducts;
        System.out.println("Random number of products to select: " + numberOfProducts);

        List<WebElement> products = getAllProducts();
        List<WebElement> prices = getAllPrices();
        List<WebElement> addToCartButtons = getAddToCartButtons();

        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < numberOfProducts) {
            int randomIndex = random.nextInt(products.size());
            if (!selectedIndexes.contains(randomIndex)) {
                selectedIndexes.add(randomIndex);
                String productName = products.get(randomIndex).getText();
                double productPrice = Double.parseDouble(prices.get(randomIndex).getText().replace("$", ""));
                selectedProductDetails.put(productName, productPrice);
                selectedProductIndexes.add(randomIndex);

                System.out.println("Selected Product: " + productName + " | Price: $" + productPrice);

                addToCartButtons.get(randomIndex).click();
            }
        }
        return new P02_SelectProductsPage(driver);
    }
    public P02_SelectProductsPage remove_Products() {
        String productName = removeButtons.findElement(driver).getText();
        int productCountBefore = getProductCount();

        removeButtons.findElement(driver).click();

        return new P02_SelectProductsPage(driver);
    }

    public P02_SelectProductsPage clickOnShoppingCartButton() {
        driver.findElement(shoppingCartIcon).click();
        return new P02_SelectProductsPage(driver);
    }


}
