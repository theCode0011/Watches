package ui.component;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.WatchesPDP;

import java.util.List;

public class ProductItem extends AbstractPage {

    @FindBy(xpath = ".//div[@class='iwc-product-fromprice']")
    private List<WebElement> prices;

    @FindBy(xpath = ".//a")
    private WebElement prodItem;

    @FindBy(className = "iwc-finder-product-title")
    private WebElement title;

    public ProductItem(WebDriver driver) {
        super(driver);
    }

    public WatchesPDP clickItem(){
        js.executeScript("arguments[0].click();", prodItem);
        return new WatchesPDP(driver);
    }

    public String getTitle(){
        return title.getText();
    }

}
