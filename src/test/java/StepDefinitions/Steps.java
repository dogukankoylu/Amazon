package StepDefinitions;
import Pages.Login;
import Utilities.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Steps {

    private WebDriver driver;
    private Login login;
    private MyDriver myDriver;
    @Given("test options")
    public void testOptions() {
        myDriver = new MyDriver();
        driver = myDriver.getDriver();
    }
    @Given("go to amazon")
    public void goToAmazon() {
        login = new Login(driver);
        login.getAmazon("https://www.amazon.com.tr/ref=nav_logo");
        login.closeCookie();
    }
    @And("searches for a product on the homepage")
    public void searchesForAProductOnTheHomepage() {
        login.searchBox("iphone");
    }
    @Then("selects a product in the search results and navigates to the product page")
    public void selectsAProductInTheSearchResultsAndNavigatesToTheProductPage() {
        login.scrollProduct();
        login.productClick();
    }
    @And("adds the product to the cart")
    public void addsTheProductToTheCart() {
        login.addToCart();
        login.goToCart();
    }
    @Then("checks the product by going to the cart page")
    public void checksTheProductByGoingToTheCartPage() {
        login.assertProduct();
        myDriver.closeDriver();
    }
}


