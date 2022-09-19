package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Iframe {
    static WebDriver driver;
    static Select options;
//Iframe vir web sayfaısın içine yerleştirilmiş başka bir web sayfasıdır

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://html.com/tags/iframe/");


    }
    @Test
    public void test1(){
   // WebElement youtubeframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //driver.switchTo().frame(youtubeframe);
//   driver.findElement(By.xpath("//*[@ari
//Yukarıdaki link değişebileceğinden en mantıklısı tüm bu iframeleri bir liste atmak
/*
 Bir web sitesinde bir video(youtube vb.) varsa <iframe> tag'ı içerisindeyse bu video'yu direk locate edip
    çalıştırmak dinamik olmaz çünkü link değişebilir ve locate'imiz çalışmaz.
    Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip
    çalıştırabiliriz.
     */



        List<WebElement> iframeListesi = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeListesi.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();


   //driver.switchTo().frame(youtubeframe);
//   driver.findElement(By.xpath("//*[@aria-label='Play']")).click();


    }
}
/*
<iframe width="560" height="315" src="https://www.youtube.com/embed/2y02QxtTebg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay;
 clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
 */
