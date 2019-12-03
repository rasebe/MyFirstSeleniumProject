import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void registerTest(){
        String userEmail = RandomStringUtils.randomAlphanumeric(7) + "@testFastTrackIt.com";
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        WebElement registerLink = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerLink.click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Ioana");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Steko");
        driver.findElement(By.cssSelector("#email_address")).sendKeys(userEmail);
        driver.findElement(By.cssSelector("#password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button"));
        Assert.assertTrue(registerButton.isDisplayed());
    }
    @After
    public void closeDriver(){
        driver.quit();
    }


    @Test
    public void backFromregisterTest(){
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-link.skip-account span:first-child"));
        accountLink.click();
        driver.findElement(By.cssSelector("a[title=Register]")).click();
        driver.findElement(By.cssSelector("a.back-link")).click();
        WebElement backToLoginElement = driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals(backToLoginElement.getText(), "LOGIN OR CREATE AN ACCOUNT");
    }
    @Test
    public void registerWithShorterPasswordTest(){
        String userEmail = RandomStringUtils.randomAlphanumeric(7) + "@testFastTrackIt.com";
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-link.skip-account span:first-child"));
        accountLink.click();
        driver.findElement(By.cssSelector("a[title=Register]")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Ioana");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Steko");
        driver.findElement(By.cssSelector("#email_address")).sendKeys(userEmail);
        driver.findElement(By.cssSelector("#password")).sendKeys("qwert");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("qwert");
        driver.findElement(By.cssSelector("button[title=Register]")).click();
        WebElement enter6OrMoreElement = driver.findElement(By.cssSelector("div[id=advice-validate-password-password]"));
        Assert.assertEquals(enter6OrMoreElement.getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

}
