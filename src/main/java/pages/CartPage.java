package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    By addToCartButton = By.id("add-to-cart-button");
    By cartButton = By.id("nav-cart");
    By quantityDropdown = By.xpath("//span[@class='a-dropdown-container']//select");
    By deleteButton = By.xpath("//input[@value='Delete' or @aria-label='Delete']");
    By cartEmptyText = By.cssSelector("h1");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        } catch (TimeoutException e) {
            System.out.println("Add to Cart button not found.");
            throw e;
        }
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public void updateQuantity(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));
        dropdown.sendKeys(quantity);
    }

    public void deleteItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        delete.click();
    }

    public boolean isCartEmpty() {
        return driver.findElement(cartEmptyText).getText().toLowerCase().contains("your amazon cart is empty");
    }
}
