import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReviewTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void addReview(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement vipLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a"));
        vipLink.click();
        WebElement ceramicVaseViewDetailsLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > a"));
        ceramicVaseViewDetailsLink.click();
        WebElement reviewsLink = driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > div > div.col-main > div.product-view > div.product-collateral.toggle-content.tabs > ul > li.last > span"));
        reviewsLink.click();
        WebElement beFirstToReviewLink = driver.findElement(By.cssSelector("#customer-reviews > p > a"));
        beFirstToReviewLink.click();
        WebElement priceRatingLink = driver.findElement(By.cssSelector("#Price_4"));
        priceRatingLink.click();
        WebElement valueRatingLink = driver.findElement(By.cssSelector("#Value_3"));
        valueRatingLink.click();
        WebElement qualityRatingLink = driver.findElement(By.cssSelector("#Quality_3"));
        qualityRatingLink.click();
        driver.findElement(By.cssSelector("#review_field")).sendKeys("It's all I wanted for Christmas");
        driver.findElement(By.cssSelector("#summary_field")).sendKeys("Thumbs up!");
        driver.findElement(By.cssSelector("#nickname_field")).sendKeys("Jane Doe");
        driver.findElement(By.cssSelector("#review-form > div.buttons-set > button > span > span")).click();
        WebElement acceptedReviewElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div.col-main > ul > li > ul > li > span"));
        Assert.assertEquals(acceptedReviewElement.getText(), "Your review has been accepted for moderation.");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
