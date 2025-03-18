package ObjectRepository.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find Products title page
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productstitlepage;

    //find sorting button
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortproduct;

    //find sort by Name (A to Z)
    @FindBy(xpath = "//option[@value='az']")
    private WebElement sortingoptionbynameaz;

    //find sort by Name (Z to A)
    @FindBy(xpath = "//option[@value='za']")
    private WebElement sortingoptionbynameza;

    //find sort by Price (low to high)
    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement sortingoptionlohi;

    //find sort by Price (high to low)
    @FindBy(xpath = "//option[@value='hilo']")
    private WebElement sortingoptionhilo;

    //find product name
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private List <WebElement> productname;

    //find product description
    @FindBy(xpath = "//div[@data-test='inventory-item-desc']")
    private List <WebElement> productdescription;

    //find product price
    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private List <WebElement> productprice;

    //find product Add to Cart button
    @FindBy(xpath = "//div/button[@class='btn btn_primary btn_small btn_inventory ']")
    private List <WebElement> addtocartbutton;

    //declare method
    //validate dashboard page
    public void validatedashboardpage(){
        AssertJUnit.assertEquals("Products", productstitlepage.getText());
    }

    public String[] getproductname(int size) {
        List<WebElement> elements = productname;
        List<String> itemNames = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            itemNames.add(elements.get(i).getText());
        }
        return itemNames.toArray(new String[1]);
    }

    // Get product description list with selected amount
    public String[] getproductdesc(int size) {
        List<WebElement> elements = productdescription;
        List<String> itemDesc = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            itemDesc.add(elements.get(i).getText());
        }
        return itemDesc.toArray(new String[1]);
    }

    // Get product price list with selected amount
    public String[] getproductprice(int size) {
        List<WebElement> elements = productprice;
        List<String> itemPrice = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            itemPrice.add(elements.get(i).getText());
        }
        return itemPrice.toArray(new String[1]);
    }

    //click add to cart button
    public void clickaddtocartbutton(int size) throws InterruptedException {
        List<WebElement> elements = productname;

        List<String> itemNames = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            itemNames.add(elements.get(i).getText());
        }

        for (int i = 0; i < size; i++) {
            String productName = itemNames.get(i);

            String formattedProductName = productName.toLowerCase().replace(" ", "-");

            WebElement addToCartButton = driver.findElement(By.xpath("//button[@name='add-to-cart-" + formattedProductName + "']"));

            addToCartButton.click();
        }
    }

    //click product name
    public void clickproductname(int size){
        List<WebElement> elements = productname;

        elements.get(size-1).click();
    }
}
