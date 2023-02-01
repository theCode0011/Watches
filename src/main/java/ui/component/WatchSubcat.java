package ui.component;

import enumes.WatchesSubcat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.OldCollectionPage;
import ui.pages.ProductListPage;

public class WatchSubcat extends AbstractPage {

    @FindBy(xpath = "//font[normalize-space(text())='%s']")
    private WebElement watchSubcategory;

    String watchSubcategoryS = "//a[normalize-space(text())='%s']";

    public WatchSubcat(WebDriver driver) {
        super(driver);
    }

    public ProductListPage clickWatchSubcategoryBtn(WatchesSubcat watchesSubcategory){
        String elem = concatinateEl(watchSubcategoryS, watchesSubcategory.getValue());
        driver.findElement(By.xpath(elem)).click();
        return new ProductListPage(driver);
    }

    public OldCollectionPage clickOldCollectionBtn(){
        String elem = concatinateEl(watchSubcategoryS, WatchesSubcat.OLD_COLLECTION.getValue());
        driver.findElement(By.xpath(elem)).click();
        return new OldCollectionPage(driver);
    }

}
