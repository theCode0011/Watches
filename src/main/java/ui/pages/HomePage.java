package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.component.CatalogMenu;

public class HomePage extends AbstractPage{
    @FindBy(xpath = "//nav[@role='navigation']")
    private WebElement catalogMenuNav;

    @FindBy(id = "popin_tc_privacy_button")
    private WebElement popupAcceptirenBtn;

    @FindBy(className = "iwc-msg-bar")
    private WebElement msgBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptPopup(){
        popupAcceptirenBtn.click();
    }

    public CatalogMenu getCatalogMenu(){
        CatalogMenu catalogMenu = new CatalogMenu(driver);
        PageFactory.initElements(catalogMenuNav, catalogMenu);
        return catalogMenu;
    }

    public boolean isPageOpened(){
        return msgBar.isDisplayed();
    }



}
