import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewsletterTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void newsletterSubscribe(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement newsletterLink = driver.findElement(By.cssSelector("#newsletter"));
        newsletterLink.sendKeys("stekkoioana@gmail.com");
        WebElement subscribeLink = driver.findElement(By.cssSelector("#newsletter-validate-detail > div > div.actions > button > span > span"));
        subscribeLink.click();
        WebElement confirmSubscriptionElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > ul > li > ul > li > span"));
        Assert.assertEquals(confirmSubscriptionElement.getText(), "Thank you for your subscription.");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
