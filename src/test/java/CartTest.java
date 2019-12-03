import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void addToCartTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement productAddedToCartElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertEquals(productAddedToCartElement.getText(), "Racer Back Maxi Dress was added to your shopping cart.");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

        @Test
    public void emptyCartTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement vipLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a"));
        vipLink.click();
        WebElement viewDetailsCardiganLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewDetailsCardiganLink.click();
        WebElement colorLink = driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img"));
        colorLink.click();
        WebElement sizeLink = driver.findElement(By.cssSelector("#swatch77 > span.swatch-label"));
        sizeLink.click();
        WebElement addtoCartLink = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button"));
        addtoCartLink.click();
        WebElement emptyCartLink = driver.findElement(By.cssSelector("#empty_cart_button > span > span"));
        emptyCartLink.click();
        WebElement cartIsEmptyElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertEquals(cartIsEmptyElement.getText(), "SHOPPING CART IS EMPTY");
    }

    @Test
    public void continueShoppingFromCartTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement continueShoppingButton = driver.findElement(By.cssSelector("#shopping-cart-table > tfoot > tr > td > button.button2.btn-continue > span > span"));
        Assert.assertTrue(continueShoppingButton.isDisplayed());
        driver.findElement(By.cssSelector("#shopping-cart-table > tfoot > tr > td > button.button2.btn-continue > span > span")).click();
    }

    @Test
    public void editFromCartTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement editButton = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > ul > li > a"));
        Assert.assertTrue(editButton.isDisplayed());
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > ul > li > a")).click();
    }
    @Test
    public void viewShoppingCartTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#header > div > a > img.large")).click();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.icon")).click();
        WebElement viewShoppingCartButton = driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions > a"));
        Assert.assertTrue(viewShoppingCartButton.isDisplayed());
        driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions > a")).click();
    }
    @Test
    public void invalidDiscountCodeTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#coupon_code")).sendKeys("sadhasd");
        driver.findElement(By.cssSelector("#discount-coupon-form > div > div > div > div > button > span > span")).click();
        WebElement invalidCouponCodeElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        Assert.assertEquals(invalidCouponCodeElement.getText(), "Coupon code \"sadhasd\" is not valid.");
    }
    @Test
    public void removeItemFromcartTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector(".level0[href*='sale.html']"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector(".button[href*='racer']"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("img[alt='Purple']")).click();
        driver.findElement(By.cssSelector("#swatch80 span:first-child")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span>span")).click();
        driver.findElement(By.cssSelector(".a-center.product-cart-remove a")).click();
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector("div h1"));
        Assert.assertEquals(welcomeMessageElement.getText(), "SHOPPING CART IS EMPTY");
    }
}
