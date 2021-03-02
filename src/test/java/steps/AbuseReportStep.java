package steps;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.BasePage;

import java.net.MalformedURLException;

import static utils.Driver.driver;
import static utils.Driver.setupDriver;
import static utils.PropertyReader.prop;

public class AbuseReportStep extends BasePage {

    @BeforeTest
    public void setUpDriverTest() throws MalformedURLException {
        setupDriver();
    }

    @Test(priority=1)

    public void searchBoxClick(){
        SearchPage searchPage = new SearchPage(driver);
        waitABit(5000);
        searchPage.clickSearchBox();
        searchPage.sendProductName();
        searchPage.clickSellerTab();

        Assert.assertTrue(searchPage.returnFirstElement().contains(prop.getProperty("store")));
        searchPage.clickStore();

        Assert.assertTrue(searchPage.returnStore().contains(prop.getProperty("store")));
        searchPage.clickProduct();

        Assert.assertTrue(searchPage.returnProductName().contains(prop.getProperty("searchedProduct")));
        Assert.assertTrue(searchPage.returnProdCost().contains(prop.getProperty("productCost")));



    }

}
