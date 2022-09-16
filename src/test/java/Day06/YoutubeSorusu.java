package Day06;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeSorusu {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com ");
    }

    @Test
    public void Test1(){
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String beklenenTitle = "Youtube";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(beklenenTitle.equalsIgnoreCase(actualTitle));
        //Assert.assertEquals(beklenenTitle,actualTitle);
    }
    @Test
    public void Test2(){
        // * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(image.isDisplayed());

    }
    @Test
    public void Test3(){
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void Test4(){
        // * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String beklenenTitle = "youtube";
        String actualTitle = driver.getTitle();
     //   Assert.assertEquals(beklenenTitle, actualTitle); fail eder
        Assert.assertNotEquals(beklenenTitle,actualTitle);
    }
@AfterClass
    public static void tearDown(){
        driver.close();
}


}
/*
 * https://www.youtube.com adresine gidin
 * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
 * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
 * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
 * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
 * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
 */
