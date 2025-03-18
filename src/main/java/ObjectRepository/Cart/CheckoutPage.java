package ObjectRepository.Cart;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find checkout title page
    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    private WebElement checkouttitlepage;

    //find input first name field
    @FindBy(id="first-name")
    private WebElement inputfirstname;

    //find input last name field
    @FindBy(id="last-name")
    private WebElement inputlastname;

    //find input postal code field
    @FindBy(id="postal-code")
    private WebElement inputpostalcode;

    //find cancel button
    @FindBy(id="cancel")
    private WebElement cancelbutton;

    //find continue button
    @FindBy(id="continue")
    private WebElement continuebutton;

    //find error message
    @FindBy(xpath = "//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3")
    private WebElement errormessage;

    //find close error message
    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement closeerrormessage;

    //find checkout overview title page
    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement checkoutoverviewtitlepage;

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

    //find Payment Information label name
    @FindBy(xpath = "//div[@data-test='payment-info-label']")
    private WebElement paymentinformationlabel;

    //find Payment Information data
    @FindBy(xpath = "//div[@data-test='payment-info-value']")
    private WebElement paymentinformationdata;

    //find Shipping Information label
    @FindBy(xpath = "//div[@data-test='shipping-info-label']")
    private WebElement shippinginformationlabel;

    //find Shipping Information data
    @FindBy(xpath = "//div[@data-test='shipping-info-value']")
    private WebElement shippinginformationdata;

    //find Price Total label
    @FindBy(xpath = "//div[@data-test='total-info-label']")
    private WebElement pricetotallabel;

    //find Price Total data
    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    private WebElement pricetotaldata;

    //find Tax data
    @FindBy(xpath = "//div[@data-test='tax-label']")
    private WebElement tax;

    //find Total data
    @FindBy(xpath = "//div[@data-test='total-label']")
    private WebElement total;

    //find Finish button
    @FindBy(id="finish")
    private WebElement finishbutton;

    //find finished checkout title page
    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    private WebElement finishedcheckedouttitlepage;

    //find success icon after checked out
    @FindBy(xpath = "//img[@data-test='pony-express']")
    private WebElement iconsuccess;

    //find header of success message after checked out
    @FindBy(xpath = "//h2[@data-test='complete-header']")
    private WebElement headersuccessmessage;

    //find success message after checked out
    @FindBy(xpath = "//div[@data-test='complete-text']")
    private WebElement successmessage;

    //find back to home button after checked out
    @FindBy(id="back-to-products")
    private WebElement backtohomebutton;

    //declare method
    //validate checkout page
    public void validatecheckoutpage(){
        AssertJUnit.assertEquals("Checkout: Your Information", checkouttitlepage.getText());
        AssertJUnit.assertEquals("First Name", inputfirstname.getAttribute("placeholder"));
        AssertJUnit.assertEquals("Last Name", inputlastname.getAttribute("placeholder"));
        AssertJUnit.assertEquals("Zip/Postal Code", inputpostalcode.getAttribute("placeholder"));
        AssertJUnit.assertEquals("Cancel", cancelbutton.getText());
        AssertJUnit.assertEquals("Continue", continuebutton.getAttribute("value"));
    }

    //input first name
    public void setfirstname(String firstname){
        inputfirstname.sendKeys(firstname);
    }

    //input last name
    public void setlastname(String lastname){
        inputlastname.sendKeys(lastname);
    }

    //input postal code
    public void setpostalcode(String postalcode){
        inputpostalcode.sendKeys(postalcode);
    }

    //click cancel button
    public void clickcancel(){
        cancelbutton.click();
    }

    //click continue button
    public void clickcontinue(){
        continuebutton.click();
    }

    //validate error message when first name is empty
    public void validateerrormessage1(){
        AssertJUnit.assertEquals("Error: First Name is required", errormessage.getText());
    }

    //validate error message when last name is empty
    public void validateerrormessage2(){
        AssertJUnit.assertEquals("Error: Last Name is required", errormessage.getText());
    }

    //validate error message when postal code is empty
    public void validateerrormessage3(){
        AssertJUnit.assertEquals("Error: Postal Code is required", errormessage.getText());
    }

    //click close error message
    public void closeerrormessage(){
        closeerrormessage.click();
    }

    //validate checkout overview page
    public void validatecheckoutoverviewpage(){
        AssertJUnit.assertEquals("Checkout: Overview", checkoutoverviewtitlepage.getText());
        AssertJUnit.assertEquals("QTY", qtylabelname.getText());
        AssertJUnit.assertEquals("Description", desclabelname.getText());
        AssertJUnit.assertEquals("Payment Information:", paymentinformationlabel.getText());
        AssertJUnit.assertEquals("SauceCard #31337", paymentinformationdata.getText());
        AssertJUnit.assertEquals("Shipping Information:", shippinginformationlabel.getText());
        AssertJUnit.assertEquals("Free Pony Express Delivery!", shippinginformationdata.getText());
        AssertJUnit.assertEquals("Price Total", pricetotallabel.getText());
        AssertJUnit.assertEquals("Cancel", cancelbutton.getText());
        AssertJUnit.assertEquals("Finish", finishbutton.getText());
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

    //validate tax data
    public void validatetax(){
        String totalPriceText = pricetotaldata.getText();
        String totalPriceValue = totalPriceText.replaceAll("[^0-9.]", "");
        double totalPrice = Double.parseDouble(totalPriceValue);
        double taxAmount = totalPrice * 0.08;
        double roundedTaxAmount = Math.ceil(taxAmount * 100.0) / 100.0;
        String formattedTax = String.format("%.2f", roundedTaxAmount);
        AssertJUnit.assertEquals(tax.getText(), "Tax: $" + formattedTax);
    }

    //validate total
    public void validatetotal(){
        String itemTotalText = pricetotaldata.getText().replaceAll("[^0-9.]", "").trim();
        String taxText = tax.getText().replaceAll("[^0-9.]", "").trim();
        String totalText = total.getText().replaceAll("[^0-9.]", "").trim();

        double itemTotal = Double.parseDouble(itemTotalText);
        double tax = Double.parseDouble(taxText);
        double total = Double.parseDouble(totalText);

        double expectedTotal = itemTotal + tax;

        if (Math.abs(expectedTotal - total) < 0.01) {
            System.out.println("Validation Passed: Total matches the sum of Item Total and Tax.");
        } else {
            System.out.println("Validation Failed: Total does not match the sum of Item Total and Tax.");
        }
    }

    //click Finish button
    public void clickfinish(){
        finishbutton.click();
    }

    //validate completed check out
    public void validatefinisheddcheckout(){
        AssertJUnit.assertEquals("Checkout: Complete!", finishedcheckedouttitlepage.getText());
        iconsuccess.isDisplayed();
        AssertJUnit.assertEquals("Thank you for your order!", headersuccessmessage.getText());
        AssertJUnit.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", successmessage.getText());
        AssertJUnit.assertEquals("Back Home", backtohomebutton.getText());
        System.out.println("Order placed successfully");
    }

    //click Back Home button on finished check out
    public void clickbackhome(){
        backtohomebutton.click();
    }
}
