import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void addToCompare(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement vipLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a"));
        vipLink.click();
        WebElement addToCompareLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > ul > li:nth-child(2) > a"));
        addToCompareLink.click();
        WebElement addToCompareSecondLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(2) > a"));
        addToCompareSecondLink.click();
        WebElement compareButton = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-right.sidebar > div.block.block-list.block-compare > div.block-content > div > button > span > span"));
        Assert.assertTrue(compareButton.isDisplayed());
        WebElement compareLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-right.sidebar > div.block.block-list.block-compare > div.block-content > div > button > span > span"));
        compareLink.click();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
