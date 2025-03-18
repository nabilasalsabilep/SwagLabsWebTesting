package ObjectRepository.Login;

import com.beust.ah.A;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory((SearchContext) driver, 120), this);
    }

    //find login title page
    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement logintitlepage;

    //find input Username field
    @FindBy(id="user-name")
    private WebElement inputusername;

    //find input Password field
    @FindBy(id="password")
    private WebElement inputpassword;

    //find Login button
    @FindBy(id="login-button")
    private WebElement loginbutton;

    //validate wording on Login Page
    public void validateloginpage(){
        AssertJUnit.assertEquals("Swag Labs", logintitlepage.getText());
        AssertJUnit.assertEquals("Username", inputusername.getCssValue("placeholder"));
        AssertJUnit.assertEquals("Password", inputpassword.getCssValue("placeholder"));
        AssertJUnit.assertEquals("Login", loginbutton.getText());
    }

    //input username
    public void setUsername(String username){
        inputusername.sendKeys(username);
    }

    //input password
    public void setPassword(String password){
        inputpassword.sendKeys(password);
    }

    //click Login button
    public void clickloginbutton(){
        loginbutton.click();
    }
}
