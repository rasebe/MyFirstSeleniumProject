import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void searchAndSortByTest(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("slim");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        Select sortByElement = new Select (driver.findElement(By.cssSelector(".category-products>.toolbar select[title='Sort By']")));
        sortByElement.selectByIndex(1);
        Assert.assertTrue(driver.findElement(By.cssSelector(".category-products > .toolbar option[value*='name']"))
                .getAttribute("selected").contains("true"));
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
