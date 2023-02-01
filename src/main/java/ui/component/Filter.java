package ui.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.AbstractPage;
import ui.pages.ProductListPage;

public class Filter extends AbstractPage {
    @FindBy(xpath = "//button[@class='iwc-finder-category'and contains(text(), 'Taille du boîtier')]")
    private WebElement filterBySizeBtn;

    @FindBy(xpath = "//div[@id='iwc-finder-case-size']//button[1]")
    private WebElement acceptSizeBtn;

    public Filter(WebDriver driver) {
        super(driver);
    }

    public Size getSizeCategorieBtn(){
        Size size = new Size(driver);
        filterBySizeBtn.click();
        PageFactory.initElements(filterBySizeBtn, size);
        return size;
    }

    public ProductListPage clickSizeAcceptBtn(){
        acceptSizeBtn.click();
        return new ProductListPage(driver);
    }



}
