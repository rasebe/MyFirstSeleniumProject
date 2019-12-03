import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccountTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void editContactInformationTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ralucasebeni@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.findElement(By.cssSelector("h3+a[href='http://testfasttrackit.info/selenium-test/customer/account/edit/']")).click();
        driver.findElement(By.cssSelector("#current_password")).sendKeys("123456");
        driver.findElement(By.cssSelector(".button[title='Save'] span>span")).click();
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector(".success-msg span"));
        Assert.assertEquals(welcomeMessageElement.getText(), "The account information has been saved.");
    }
        @After
        public void closeDriver(){
            driver.quit();
        }
}
