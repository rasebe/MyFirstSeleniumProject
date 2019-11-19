import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        loginTest();
        invalidLoginTest();
        addToCart();
        addToCompare();
        newsletterSubscribe();
        addReview();
        emptyCart();


        }
        public static void loginTest(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");
            WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
            accountLink.click();

            WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
            loginLink.click();

            driver.findElement(By.cssSelector("#email")).sendKeys("ralucasebeni@gmail.com");
            driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
            driver.findElement(By.cssSelector("#send2 > span > span")).click();
            driver.close();
        }

        public static void invalidLoginTest(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");
            WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
            accountLink.click();

            WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
            loginLink.click();

            driver.findElement(By.cssSelector("#email")).sendKeys("ralucasebeni@gmail.com");
            driver.findElement(By.cssSelector("#pass")).sendKeys("khooklh");
            driver.findElement(By.cssSelector("#send2 > span > span")).click();
            driver.close();
        }

        public static void addToCart(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");

            WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
            saleLink.click();

            WebElement viewItemLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
            viewItemLink.click();

            driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
            driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
            driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
            driver.close();
        }

    public static void addToCompare() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement vipLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a"));
        vipLink.click();

        WebElement addToCompareLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > ul > li:nth-child(2) > a"));
        addToCompareLink.click();

        WebElement addToCompareSecondLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(2) > a"));
        addToCompareSecondLink.click();

        WebElement compareLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-right.sidebar > div.block.block-list.block-compare > div.block-content > div > button > span > span"));
        compareLink.click();
        driver.quit();
    }

    public static void newsletterSubscribe(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");

            WebElement newsletterLink = driver.findElement(By.cssSelector("#newsletter"));
            newsletterLink.sendKeys("stekkoioana@gmail.com");
            WebElement subscribeLink = driver.findElement(By.cssSelector("#newsletter-validate-detail > div > div.actions > button > span > span"));
            subscribeLink.click();
            driver.close();
    }

    public static void addReview(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

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
        driver.close();
    }

    public static void emptyCart(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement vipLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a"));
        vipLink.click();

        WebElement viewDetailsCardiganLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewDetailsCardiganLink.click();

        WebElement colorLink = driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img"));
        colorLink.click();

        WebElement sizeLink = driver.findElement(By.cssSelector("#swatch77 > span.swatch-label"));
        sizeLink.click();

        WebElement addtoCartLink = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button"));
        addtoCartLink.click();

        WebElement emptyCartLink = driver.findElement(By.cssSelector("#empty_cart_button > span > span"));
        emptyCartLink.click();
        driver.close();
    }
}
