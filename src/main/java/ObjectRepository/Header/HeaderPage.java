package ObjectRepository.Header;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.AssertJUnit;

public class HeaderPage {
    WebDriver driver;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find dashboard title page
    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement headertitlepage;

    //find burger menu button
    @FindBy(id="react-burger-menu-btn")
    private WebElement burgermenu;

    //find close burger menu
    @FindBy(id="react-burger-cross-btn")
    private WebElement closeburgermenu;

    //find All Items sub menu
    @FindBy(id="inventory_sidebar_link")
    private WebElement allitemssubmenu;

    //find About sub menu
    @FindBy(id="about_sidebar_link")
    private WebElement aboutsubmenu;

    //find Logout sub menu
    @FindBy(id="logout_sidebar_link")
    private WebElement logoutsubmenu;

    //find Reset App Stroe sub menu
    @FindBy(id="reset_sidebar_link")
    private WebElement resetappstoresubmenu;

    //find cart button
    @FindBy(id="shopping_cart_container")
    private WebElement cart;

    //declare method
    //validate header page
    public void validateheader(){
        AssertJUnit.assertEquals("Swag Labs", headertitlepage.getText());
        burgermenu.isDisplayed();
        cart.isDisplayed();
    }

    //click burger menu button
    public void clickburgermenu(){
        burgermenu.click();
        closeburgermenu.isDisplayed();
        AssertJUnit.assertEquals("All Items", allitemssubmenu.getText());
        AssertJUnit.assertEquals("About", aboutsubmenu.getText());
        AssertJUnit.assertEquals("Logout", logoutsubmenu.getText());
        AssertJUnit.assertEquals("Reset App Store", resetappstoresubmenu.getText());
    }

    //click close burger menu button
    public void clickcloseburgermenu(){
        closeburgermenu.click();
    }

    //click cart button
    public void clickcart(){
        cart.click();
    }
}
