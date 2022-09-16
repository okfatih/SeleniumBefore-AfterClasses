package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    /*
    -Amazon sayfasına gidelim
    - 3 farklı test methodu oluşturalım.
    -  a-url nin amazon içerip içermedğini test et
       b-title ın facebook içermediğini test edelim
       c- sol üst köşede amazon logosunun göründüğünü test edelim
       d- test whether url facebook.com
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.get("https://amazon.com");

    }
    @Test
    public void test1(){
     // a-url nin amazon içerip içermedğini test et
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void test2(){
        //   b-title ın facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
        Assert.assertNotEquals(expectedTitle,actualTitle);


    }
    @Test
    public void test3(){
        //  c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        String expectedURl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedURl,actualUrl);
    }

@AfterClass
    public static void tearDown(){
driver.close();
    }

}
