package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
        WebDriver driver;

        By addToCartButton = By.id("add-to-cart-button");
        By cartButton = By.id("nav-cart");
        By quantityDropdown = By.name("quantity");
        By deleteButton = By.xpath("//input[@value='Delete']");
        By cartEmptyText = By.cssSelector("h1");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

        public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

        public void openCart() {
        driver.findElement(cartButton).click();
    }

        public void updateQuantity(String quantity) {
        driver.findElement(quantityDropdown).sendKeys(quantity);
    }

        public void deleteItem() {
        driver.findElement(deleteButton).click();
    }

        public boolean isCartEmpty() {
        return driver.findElement(cartEmptyText).getText().contains("Your Amazon Cart is empty");
    }
    }
