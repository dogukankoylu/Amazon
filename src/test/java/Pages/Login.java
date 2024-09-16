package Pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class Login {
    public Login(WebDriver drv) {
        this.drv = drv;
    }

    WebDriver drv;
    public void getAmazon(String adress) {
        drv.get(adress);
    }
    public void closeCookie() {
        drv.findElement(By.id("sp-cc-rejectall-link")).click();
    }
    public void searchBox(String productName) {
        drv.findElement(By.id("twotabsearchtextbox")).sendKeys(productName + Keys.ENTER);
    }
    public void scrollProduct() {
        JavascriptExecutor scroll = (JavascriptExecutor)drv;
        WebElement xpath = drv.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[11]/div/div/span/div/div/div[2]/div[2]/h2/a/span"));
        scroll.executeScript("arguments[0].scrollIntoView();",xpath);
    }
    public void productClick() {
        drv.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[11]/div/div/span/div/div/div[2]/div[2]/h2/a/span")).click();
    }
    public void addToCart() {
        drv.findElement(By.id("add-to-cart-button")).click();
    }
    public void goToCart() {
        drv.findElement(By.id("nav-cart-count-container")).click();
    }
    public void assertProduct() {
        WebElement assertXpath = drv.findElement(By.className("a-truncate-cut"));
        Assert.assertTrue(assertXpath.isDisplayed());
    }

}
