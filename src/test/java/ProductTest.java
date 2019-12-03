import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void viewAsListTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement listButton = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > p > a"));
        Assert.assertTrue(listButton.isDisplayed());
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > p > a")).click();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
    @Test
    public void setDescendingDirectionTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleLink.click();
        WebElement setDescendingDirectionButton = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > a"));
        Assert.assertTrue(setDescendingDirectionButton.isDisplayed());
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > a")).click();
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
    @Test
    public void changeNumberOfProductsPerPageTest(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("slim");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        Select sortByElement = new Select (driver.findElement(By.cssSelector(".category-products>.toolbar select[title='Results per page']")));
        sortByElement.selectByIndex(1);
        Assert.assertTrue(driver.findElement(By.cssSelector(".category-products > .toolbar option[value*='24']"))
                .getAttribute("selected").contains("true"));
    }

}
