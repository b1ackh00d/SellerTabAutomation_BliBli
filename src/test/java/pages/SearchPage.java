package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

import java.util.List;

import static utils.PropertyReader.prop;

public class SearchPage extends BasePage {

    public SearchPage(AppiumDriver<WebElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "tv_search")
    WebElement homeSearchBox;

    @FindBy(id = "et_search_box")
    WebElement searchBox;

    @FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Seller\"]/android.widget.TextView")
    WebElement sellerTab;

    @FindBy(id = "tv_name")
    List<WebElement> storeName;

    @FindBy(id = "tv_name")
    WebElement storeName1;

    @FindBy(id = "iv_product") WebElement productImage;

    @FindBy(id = "tv_product_name") WebElement productName;

    @FindBy(id = "tv_final_price") WebElement productPrice;


//    @AndroidFindBy()


    public void clickSearchBox() {
        click(homeSearchBox, 5);
        click(searchBox, 5);
    }

    public void sendProductName(){ sendKeys(searchBox, prop.getProperty("productName"), 5); }

    public void clickSellerTab(){ click(sellerTab, 5); }

    public String returnFirstElement(){ return getTextWithIndex(storeName, 4, 5); }

    public void clickStore(){ clickWithIndex(storeName, 4,5); }

    public String returnStore(){ return getText(storeName1,  5); }

    public void clickProduct(){ click(productImage, 5);}

    public String returnProductName(){ return getText(productName,  5); }

    public String returnProdCost(){ return getText(productPrice,  5); }

//    public void clickSearchBtn() {
//        click(searchBtn, 5);
//    }


}
