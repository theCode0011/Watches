package ui.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pages.AbstractPage;

public class Size extends AbstractPage {

    String sizeBtn= ".//label[@data-text='%s']";

    public Size(WebDriver driver) {
        super(driver);
    }

    public Filter clickSizeNumberBtn(enumes.Size size){
        String s = concatinateEl(sizeBtn, size.getValue());
        driver.findElement(By.xpath(s)).click();
        return new Filter(driver);
    }

}
