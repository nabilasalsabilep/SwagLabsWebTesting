package TestCases.Checkout;

import ObjectRepository.Cart.CartPage;
import ObjectRepository.Cart.CheckoutPage;
import ObjectRepository.Dashboard.DashboardPage;
import ObjectRepository.Header.HeaderPage;
import ObjectRepository.Login.LoginPage;
import Utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Checkout extends Util {
    public static WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public static void setup(String browser){
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
//			options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//		driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @AfterTest
    public static void tearDown(){
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public static void checkout(HashMap<String, String> input) throws InterruptedException {
        driver.get("https://saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.validateloginpage();
        loginPage.setUsername(input.get("username"));
        loginPage.setPassword(input.get("password"));
        loginPage.clickloginbutton();

        int amountofproducts = 2;
        String[] productname = dashboardPage.getproductname(amountofproducts);
        String[] productdesc = dashboardPage.getproductdesc(amountofproducts);
        String[] productprice = dashboardPage.getproductprice(amountofproducts);
        dashboardPage.clickaddtocartbutton(amountofproducts);

        headerPage.clickcart();

        cartPage.validatecartpage();
        cartPage.validateproductqty();
        cartPage.validateproductname(productname);
        cartPage.validateproductdesc(productdesc);
        cartPage.validateproductprice(productprice);
        cartPage.clickcheckout();

        checkoutPage.validatecheckoutpage();

        RandomData randomData = new RandomData();
        checkoutPage.setfirstname(randomData.generateRandomFirstName());
        checkoutPage.setlastname(randomData.generateRandomLastName());
        checkoutPage.setpostalcode(randomData.generateRandomPostalCode());
        checkoutPage.clickcontinue();

        checkoutPage.validatecheckoutoverviewpage();
        checkoutPage.validateproductname(productname);
        checkoutPage.validateproductqty();
        checkoutPage.validateproductdesc(productdesc);
        checkoutPage.validateproductprice(productprice);
        checkoutPage.validatetax();
        checkoutPage.validatetotal();
        checkoutPage.clickfinish();
        checkoutPage.validatefinisheddcheckout();
        checkoutPage.clickbackhome();

        headerPage.validateheader();
        dashboardPage.validatedashboardpage();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getjsonData("/Users/salsa/IdeaProjects/SwagLabsWebTesting/src/test/java/TestData/UserAccount.json");
        return new Object[][] { {data.get(0)}};
    }
}
