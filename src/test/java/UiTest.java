import common.CommonActions;
import enumes.Size;
import enumes.WatchesSubcat;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.component.ProductItem;
import ui.pages.HomePage;
import ui.pages.ProductListPage;
import ui.pages.WatchesPDP;


public class UiTest extends CommonActions {

@Test
    public void titlesMatchOnPLPAndPDPCheck(){
    HomePage homePage = new HomePage(driver);
    homePage.open();
    homePage.acceptPopup();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    ProductListPage productListPage =homePage.getCatalogMenu().openWatchSubcategory().clickWatchSubcategoryBtn(WatchesSubcat.PILOTS_WATCHES);
    Assert.assertTrue(productListPage.isPageOpened());
    ProductItem prodItem = productListPage.getProductItemByIndex(30);
    String watchNamePLP =prodItem.getTitle();
    WatchesPDP watchesPDP =prodItem.clickItem();
    Assert.assertTrue(watchesPDP.isPageOpened());
    String watchNamePDP = watchesPDP.getWatchName();
    Assert.assertTrue(watchNamePLP.equalsIgnoreCase(watchNamePDP),"titles are not equals");
}

@Test
    public void isSizeBtwRange(){
    HomePage homePage = new HomePage(driver);
    homePage.open();
    homePage.acceptPopup();
    Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    ProductListPage productListPage = homePage.getCatalogMenu().openWatchSubcategory().clickWatchSubcategoryBtn(WatchesSubcat.PILOTS_WATCHES);
    Assert.assertTrue(productListPage.isPageOpened(), "PLP page is not opened");
    productListPage.getFilter().getSizeCategorieBtn().clickSizeNumberBtn(Size.SIZE_40_43mm).clickSizeAcceptBtn();
    WatchesPDP watchesPDP =productListPage.getProductItemByIndex(1).clickItem();
    Assert.assertTrue(watchesPDP.isPageOpened(), "Watches PDP");
    int actualSize = watchesPDP.getWatchSize();
    Assert.assertTrue(watchesPDP.isSiseBtwRange(actualSize, Size.SIZE_40_43mm), "Size is not equals");
    }

}
