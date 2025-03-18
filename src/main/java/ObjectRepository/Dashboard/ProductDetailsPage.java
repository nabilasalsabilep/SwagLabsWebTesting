package ObjectRepository.Dashboard;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find Back to Products button
    @FindBy(id="back-to-products")
    private WebElement backtoproductsbutton;

    //find product name
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement productname;

    //find product description
    @FindBy(xpath = "//div[@data-test='inventory-item-desc']")
    private WebElement productdescription;

    //find product price
    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productprice;

    //find product Add to Cart button
    @FindBy(id="add-to-cart")
    private WebElement addtocartbutton;

    //find product image
    @FindBy(xpath = "//img[@class='inventory_details_img']")
    private WebElement productimage;

    //declare method
    //click back to products button
    public void clickbacktoproducts(){
        AssertJUnit.assertEquals("Back to products", backtoproductsbutton.getText());
        backtoproductsbutton.click();
    }

    //validate book detail page
    public void validatebookdetailimage(){
        productimage.isDisplayed();
    }

    //validate product name
    public void validateproductname(String[] productnames, int i){
        if (i >= 0 && i < productnames.length) {
            String expectedProductName = productnames[i];
            String actualProductName = productname.getText();
            AssertJUnit.assertEquals("Product name mismatch!", expectedProductName, actualProductName);

            if (expectedProductName.equals(actualProductName)) {
                System.out.println("Validation Passed: Product name matches: " + actualProductName);
            } else {
                System.out.println("Validation Failed: Product name mismatch! Expected: " + expectedProductName + ", Found: " + actualProductName);
            }
        } else {
            System.out.println("Invalid index: " + i);
        }
    }

    //validate product desc
    public void validateproductdesc(String[] productsdesc, int i){
        String expectedProductDesc = productsdesc[i];
        String actualProductDesc = productdescription.getText();
        AssertJUnit.assertEquals("Product desc mismatch!", expectedProductDesc, actualProductDesc);

        if (expectedProductDesc.equals(actualProductDesc)) {
            System.out.println("Validation Passed: Product desc matches: " + actualProductDesc);
        } else {
            System.out.println("Validation Failed: Product desc mismatch! Expected: " + expectedProductDesc + ", Found: " + actualProductDesc);
        }
    }

    //validate product price
    public void validateproductprice(String[] productsprice, int i){
        String expectedProductPrice = productsprice[i];
        String actualProductPrice = productprice.getText();
        AssertJUnit.assertEquals("Product price mismatch!", expectedProductPrice, actualProductPrice);

        if (expectedProductPrice.equals(actualProductPrice)) {
            System.out.println("Validation Passed: Product price matches: " + actualProductPrice);
        } else {
            System.out.println("Validation Failed: Product price mismatch! Expected: " + expectedProductPrice + ", Found: " + actualProductPrice);
        }
    }

    //click add to cart button
    public void clickaddtocart(){
        AssertJUnit.assertEquals("Add to cart", addtocartbutton.getText());
        addtocartbutton.click();
    }
}
