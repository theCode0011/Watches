package ui.pages;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constant.Constant.Url.BASE_URL;

public class AbstractPage extends CommonActions {
   public JavascriptExecutor js = (JavascriptExecutor) driver;

    public AbstractPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementIsVisible(WebElement el, int sec){
        new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(el));
        return el;
    }

    public String concatinateEl(String prodCat, Object productCategories){
        return String.format(prodCat, productCategories.toString());
    }

    public void scrollBy(String pxl){
        js.executeScript("window.scrollBy(0,"+pxl+")");
    }

    public void scrollIntoView(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void open(){
        driver.get(BASE_URL);
    }


}
