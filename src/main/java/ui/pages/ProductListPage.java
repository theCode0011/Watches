package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.component.Filter;
import ui.component.ProductItem;

import java.util.List;

public class ProductListPage extends AbstractPage{

    @FindBy(xpath = "//button[@class='iwc-finder-category' and contains(text(), 'Taille du boîtier')]")
    private WebElement caseSizeBtn;

     @FindBy(xpath = "//li[contains(@class,'iwc-finder-result-product')and contains(@class,'iwc-show')]")
    private List<WebElement> productItems;

    @FindBy(className = "iwc-finder-categories")
    private WebElement filter;

    @FindBy(xpath = "//h2[@class='all-sub-col']")
    private WebElement title;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return title.isDisplayed();
    }

    public Filter getFilter(){
        Filter filterComponent = new Filter(driver);
        PageFactory.initElements(filter, filterComponent);
        return filterComponent;
    }

    public ProductItem getProductItemByIndex(int index){
        ProductItem productItem = new ProductItem(driver);
        int scrollCount= 20;
        for (int i =0;i<scrollCount;i++) {
            try { PageFactory.initElements(productItems.get(index),productItem);
                break;
            } catch (Exception e) {
                scrollBy("800");
            }
        }
        return productItem;
    }
}
