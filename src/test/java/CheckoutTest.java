import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void checkoutAsReturningCustomerTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector(".level0[href*='sale.html']"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector(".button[href='http://testfasttrackit.info/selenium-test/racer-back-maxi-dress-603.html']"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("span img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span>span")).click();
        driver.findElement(By.cssSelector(".checkout-types.top [title='Proceed to Checkout'] span>span")).click();
        driver.findElement(By.cssSelector("#login-email")).sendKeys("ralucasebeni@gmail.com");
        driver.findElement(By.cssSelector("#login-password")).sendKeys("123456");
        driver.findElement(By.cssSelector(".button[onclick='onepageLogin(this)'] span>span")).click();
        WebElement billingInformationElement = driver.findElement(By.cssSelector("li.section.allow.active h2"));
        Assert.assertEquals(billingInformationElement.getText(), "BILLING INFORMATION");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void placeAnOrderTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector(".level0[href*='sale.html']"));
        saleLink.click();
        WebElement viewItemLink = driver.findElement(By.cssSelector(".button[href*='racer']"));
        viewItemLink.click();
        driver.findElement(By.cssSelector("img[alt='Purple']")).click();
        driver.findElement(By.cssSelector("#swatch80 span:first-child")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons span>span")).click();
        driver.findElement(By.cssSelector(".checkout-types.top [title='Proceed to Checkout'] span>span")).click();
        driver.findElement(By.cssSelector("#login-email")).sendKeys("ralucasebeni@gmail.com");
        driver.findElement(By.cssSelector("#login-password")).sendKeys("123456");
        driver.findElement(By.cssSelector(".button[onclick='onepageLogin(this)'] span>span")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container > button")).click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        driver.findElement(By.cssSelector("#s_method_freeshipping_freeshipping")).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }
        driver.findElement(By.cssSelector("#payment-buttons-container > button")).click();
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }
        driver.findElement(By.cssSelector("#review-buttons-container > button")).click();
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }
        WebElement billingInformationElement = driver.findElement(By.cssSelector("div h1"));
        Assert.assertEquals(billingInformationElement.getText(), "YOUR ORDER HAS BEEN RECEIVED.");
    }

}
