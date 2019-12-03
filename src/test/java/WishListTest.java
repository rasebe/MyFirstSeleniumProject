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

    @Test
    public void shareWishlistTest(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-link.skip-account span+span"));
        accountLink.click();
        WebElement loginLink = driver.findElement(By.cssSelector("a[title='Log In']"));
        loginLink.click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ralucasebeni@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.findElement(By.cssSelector(".level0[href='http://testfasttrackit.info/selenium-test/sale.html']")).click();
        driver.findElement(By.cssSelector(".link-wishlist[href*='423']")).click();
        driver.findElement(By.cssSelector("button[title='Share Wishlist'] span>span")).click();
        driver.findElement(By.cssSelector("#email_address")).sendKeys("stekoioana@huh.com");
        driver.findElement(By.cssSelector("button[title='Share Wishlist'] span>span")).click();
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector("li>span"));
        Assert.assertEquals(welcomeMessageElement.getText(), "Your Wishlist has been shared.");
    }
}
