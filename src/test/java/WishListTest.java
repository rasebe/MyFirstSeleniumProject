import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void wishListSaleTest(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement viewDetailsLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewDetailsLink.click();
        WebElement addToWishlistButton = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a"));
        Assert.assertTrue(addToWishlistButton.isDisplayed());
        WebElement addToWishlist = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a"));
        addToWishlist.click();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
