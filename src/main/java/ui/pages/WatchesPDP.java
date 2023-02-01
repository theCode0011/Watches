package ui.pages;

import enumes.Size;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class WatchesPDP extends AbstractPage{

    @FindBy(className = "iwc-buying-options-summary")
    private WebElement productSummary;

    @FindBy(xpath = "//span[@class='iwc-buying-options-title ']")
    private WebElement watchName;

    @FindBy(xpath = "//li[contains(text(), 'Diamètre')]")
    private WebElement diameter;

    public WatchesPDP(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        return productSummary.isDisplayed();
    }

    public String getWatchName(){
        return watchName.getAttribute("data-product-name").toUpperCase(Locale.ROOT);
    }

    public int getWatchSize(){
        String sizeActual = diameter.getText().substring(8);
        sizeActual = sizeActual.replaceAll("m", "")
                .replace(".","")
                .replaceAll("0", "")
                .replace(" ", "");
        int sizeActualInt = Integer.valueOf(sizeActual);
        return sizeActualInt;
    }

    public boolean isSiseBtwRange( int actualS, Size size){
        boolean isBtwRange = true;
            isBtwRange=true;
            String sizeExpected = size.getValue().replace("m", "").replace(" ", "");
            String values[] = sizeExpected.split("-");
        System.out.println("min"+values[0]+" "+"max"+values[1]);
            int min = Integer.valueOf(values[0]);
            int max = Integer.valueOf(values[1]);
            if (actualS < min || actualS > max) {
                isBtwRange= false;
            }
        return isBtwRange;
    }


}
