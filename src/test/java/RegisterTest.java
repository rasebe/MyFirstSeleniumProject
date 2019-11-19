import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public static void registerTest(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();

        WebElement registerLink = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerLink.click();

        driver.findElement(By.cssSelector("#firstname")).sendKeys("Ioana");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Steko");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("ioanasteko@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > ul > li.control > label")).click();
        driver.close();
    }
}
