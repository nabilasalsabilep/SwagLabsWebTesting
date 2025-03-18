package ObjectRepository.Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find Cart title page
    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement carttitlepage;

    //find QTY label name
    @FindBy(xpath = "//div[@class='cart_quantity_label']")
    private WebElement qtylabelname;

    //find Description label name
    @FindBy(xpath = "//div[@class='cart_desc_label']")
    private WebElement desclabelname;

    //find table size
    @FindBy(xpath = "//div[@class='cart_item']")
    private List <WebElement> tablesize;

    //find quantity data
    @FindBy(xpath = "//div[@class='cart_quantity']")
    private List <WebElement> cartqty;

    //find cart item name
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List <WebElement> productname;

    //find cart item description
    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    private List <WebElement> productdesc;

    //find cart item price
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List <WebElement> productprice;

    //find remove button
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    private List <WebElement> removebutton;

    //find checkout button
    @FindBy(id="checkout")
    private WebElement checkoutbutton;

    //find continue shopping button
    @FindBy(id="continue-shopping")
    private WebElement continueshoppingbutton;

    //declare method

    //validate cart page
    public void validatecartpage(){
        AssertJUnit.assertEquals("Your Cart", carttitlepage.getText());
        AssertJUnit.assertEquals("QTY", qtylabelname.getText());
        AssertJUnit.assertEquals("Description", desclabelname.getText());
        AssertJUnit.assertEquals("Checkout", checkoutbutton.getText());
        AssertJUnit.assertEquals("Continue Shopping", continueshoppingbutton.getText());
    }

    //validate product name
    public void validateproductname(String[] name) {
        List<WebElement> elements = tablesize;
        List<WebElement> productnamecart = productname;

        // Loop through the elements
        for (int i = 0; i < elements.size(); i++) {
            String expectedName = name[i];
            String actualName = productnamecart.get(i).getText();

            // Assert if the expected name matches the actual name
            try {
                AssertJUnit.assertEquals("Product name mismatch at row " + (i + 1), expectedName, actualName);
                System.out.println("Row " + (i + 1) + ": Product name matches: " + actualName);
            } catch (AssertionError e) {
                System.out.println("Row " + (i + 1) + ": Product name mismatch! Expected: " + expectedName + ", Found: " + actualName);
            }
        }
    }

    //validate product description
    public void validateproductdesc(String[] desc) {
        List<WebElement> elements = tablesize;
        List<WebElement> productdesccart = productdesc;

        // Loop through the elements
        for (int i = 0; i < elements.size(); i++) {
            String expectedName = desc[i];
            String actualName = productdesccart.get(i).getText();

            // Assert if the expected desc matches the actual desc
            try {
                AssertJUnit.assertEquals("Product desc mismatch at row " + (i + 1), expectedName, actualName);
                System.out.println("Row " + (i + 1) + ": Product desc matches: " + actualName);
            } catch (AssertionError e) {
                System.out.println("Row " + (i + 1) + ": Product desc mismatch! Expected: " + expectedName + ", Found: " + actualName);
            }
        }
    }

    //validate product price
    public void validateproductprice(String[] price) {
        List<WebElement> elements = tablesize;
        List<WebElement> productdpricecart = productprice;

        // Loop through the elements
        for (int i = 0; i < elements.size(); i++) {
            String expectedName = price[i];
            String actualName = productdpricecart.get(i).getText();

            // Assert if the expected price matches the actual price
            try {
                AssertJUnit.assertEquals("Product price mismatch at row " + (i + 1), expectedName, actualName);
                System.out.println("Row " + (i + 1) + ": Product price matches: " + actualName);
            } catch (AssertionError e) {
                System.out.println("Row " + (i + 1) + ": Product price mismatch! Expected: " + expectedName + ", Found: " + actualName);
            }
        }
    }

    //validate product quantity
    public void validateproductqty() {
        List<WebElement> elements = tablesize;
        List<WebElement> productqtycart = cartqty;

        // Loop through the elements
        for (int i = 0; i < elements.size(); i++) {
            String expectedName = "1";
            String actualName = productqtycart.get(i).getText();

            // Assert if the expected qty matches the actual qty
            try {
                AssertJUnit.assertEquals("Product qty mismatch at row " + (i + 1), expectedName, actualName);
                System.out.println("Row " + (i + 1) + ": Product qty matches: " + actualName);
            } catch (AssertionError e) {
                System.out.println("Row " + (i + 1) + ": Product qty mismatch! Expected: " + expectedName + ", Found: " + actualName);
            }
        }
    }

    //validate remove product button
    public void validateandclickremovebutton(int count) {
        List<WebElement> elements = tablesize;
        List<WebElement> removeproductfromcart = removebutton;

        // Loop through the elements
        for (int i = 0; i < elements.size(); i++) {
            String expectedName = "Remove";
            String actualName = removeproductfromcart.get(i).getText();

            // Assert if the expected result matches the actual result
            try {
                AssertJUnit.assertEquals("Remove button mismatch at row " + (i + 1), expectedName, actualName);
                System.out.println("Row " + (i + 1) + ": Remove button matches: " + actualName);
            } catch (AssertionError e) {
                System.out.println("Row " + (i + 1) + ": Remove button mismatch! Expected: " + expectedName + ", Found: " + actualName);
            }
            //Click remove button
            removeproductfromcart.get(i).click();
        }
    }

    //click checkout button
    public void clickcheckout(){
        checkoutbutton.click();
    }

}
