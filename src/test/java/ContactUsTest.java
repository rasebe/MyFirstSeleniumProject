import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void contactUsTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement contactUsLink = driver.findElement(By.cssSelector("body > div > div.page > div.footer-container > div > div:nth-child(2) > ul > li:nth-child(2) > a"));
        contactUsLink.click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Jane Doe");
        driver.findElement(By.cssSelector("#email")).sendKeys("janedoe@yahoo.com");
        driver.findElement(By.cssSelector("#comment")).sendKeys("Nothing to say");
        driver.findElement(By.cssSelector("#contactForm > div.buttons-set > button > span > span")).click();
        WebElement inquirySubmittedElement = driver.findElement(By.cssSelector("#messages_product_view > ul > li > ul > li > span"));
        Assert.assertEquals(inquirySubmittedElement.getText(), "Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
