package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultsPage;

public class tests {

    WebDriver driver;
    HomePage home;
    SearchResultsPage searchResults;
    CartPage cart;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        home = new HomePage(driver);
        searchResults = new SearchResultsPage(driver);
        cart = new CartPage(driver);
    }

    @Test(priority = 1)
    public void testSearchNonExistingProduct() {
        home.search("ld345tsxslfer");
        Assert.assertTrue(searchResults.isNoResultsDisplayed());
    }

    @Test(priority = 2)
    public void testSearchExistingProduct() {
        home.search("Laptop");
        Assert.assertTrue(searchResults.isResultRelevant("Laptop"));
    }

    @Test(priority = 3)
    public void testAddProductToCart() {
        home.search("Laptop");
        searchResults.clickProduct(3); // 4th result
        cart.addToCart();
        cart.openCart();
    }

    @Test(priority = 4)
    public void testUpdateQuantity() {
        cart.openCart();
        cart.updateQuantity("2");
    }

    @Test(priority = 5)
    public void testRemoveProduct() {
        cart.openCart();
        cart.deleteItem();
        Assert.assertTrue(cart.isCartEmpty());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
    }
