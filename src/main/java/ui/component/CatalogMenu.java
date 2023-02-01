package ui.component;

import enumes.MenuCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.AbstractPage;

public class CatalogMenu extends AbstractPage {
    Actions actions = new Actions(driver);
    WatchSubcat watchComp = new WatchSubcat(driver);

    @FindBy(xpath = "//a[@data-link='%s']")
    private WebElement menuItem;

    String menuItemS= "//a[@data-link='%s']";

    @FindBy(className = "iwc-megamenu-container-inner")
    private WebElement subcatalogItem;


    public CatalogMenu(WebDriver driver) {
        super(driver);
    }

    public void hoverCatalogMenuEl(MenuCategories enumProductCategories){
        String finalElem = concatinateEl(menuItemS, enumProductCategories.getValue());
        actions.moveToElement(driver.findElement(By.xpath(finalElem))).perform();
    }

    public WatchSubcat openWatchSubcategory(){
        hoverCatalogMenuEl(MenuCategories.WATCHES);
        PageFactory.initElements(subcatalogItem, watchComp);
        return new WatchSubcat(driver);
    }

    public AccessoriesSubCat openAccesoriesSubcategory(){
        hoverCatalogMenuEl(MenuCategories.ACCESSORIES);
        PageFactory.initElements(subcatalogItem, watchComp);
        return new AccessoriesSubCat(driver);
    }

}
