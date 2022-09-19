package day09HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru2 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("https://amazon.com");
        String amazonWebHandle = driver.getWindowHandle();
        //Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://techproeducation.com");

        Assert.assertFalse(driver.getTitle().contains("TECHPROEDCATION"));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

       // Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

       //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWebHandle);

        Assert.assertTrue(driver.getTitle().contains(actualTitle));




    }

}
/*
Yeni bir class olusturun: WindowHandle
Amazon anasayfa adresine gidin.
Sayfa’nin window handle degerini String bir degiskene atayin
Sayfa title’nin “Amazon” icerdigini test edin
Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
Sayfa title’nin “Walmart” icerdigini test edin
Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
 */