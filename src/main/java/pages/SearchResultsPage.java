package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
        WebDriver driver;

        By productTitles = By.cssSelector("span.a-size-medium");
        By allProducts = By.cssSelector("div[data-component-type='s-search-result']");


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

        public boolean isNoResultsDisplayed () {
        return driver.getPageSource().contains("did not match any products");
    }

        public boolean isResultRelevant (String keyword){
        List<WebElement> titles = driver.findElements(productTitles);
        return titles.stream().anyMatch(e -> e.getText().toLowerCase().contains(keyword.toLowerCase()));
    }

        public void clickProduct ( int index){
        List<WebElement> products = driver.findElements(allProducts);
        if (index < products.size()) {
            products.get(index).click();
        }
    }
    }
