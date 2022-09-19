package day09HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

    }
    @After
    public  void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("https://amazon.com");
        String amazonWindowHandle =  driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String currentURl = driver.getCurrentUrl();
        String expectedUrl = "amazon";

        Assert.assertTrue(currentURl.contains(expectedUrl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);//YYeni bir pencere açmak için bu methodu kullanırız
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
       Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("Java", Keys.ENTER);
        WebElement aramasonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "Java";
        String actualSonuc =aramasonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));


        //7- Yeniden bestbuy sayfasına gidelim
       driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        WebElement logo =  driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }

    /*
    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım
     */
}
