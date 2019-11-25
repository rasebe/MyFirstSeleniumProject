import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void validLoginTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ralucasebeni@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        Assert.assertEquals(welcomeMessageElement.getText(), "Hello, Raluca Sebeni!");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void invalidLoginTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ralucasebeni@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("khooklh");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement invalidLoginMessageElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertEquals(invalidLoginMessageElement.getText(), "Invalid login or password.");
    }
    @Test
    public void forgotYourPasswordTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();
        driver.findElement(By.cssSelector("#login-form > div > div.col-2.registered-users > div.content.fieldset > ul > li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("#email_address")).sendKeys("janedoe@yahoo.com");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        WebElement accountAssociatedElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertEquals(accountAssociatedElement.getText(), "If there is an account associated with janedoe@yahoo.com you will receive an email with a link to reset your password.");
    }
}
