package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    /*
    https://the-internet.herokuapp.com/ e git
    click for js alert butonuna tıklayalım
    Tıkladıktan sonra çıkan uyarı mesajına alerte tamam diyelim

     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));

        //Javascript alerti tıkla
        driver.switchTo().alert().accept();



    }
    /*
    /*
bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
ve istedigimiz locate'i alabiliriz.
Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak

bu tür alertlere  js alert denir.
js alert'lere müdahale edebilmek icin

-- tamam ya da ok icin
driver.switchTo().alert().accept();

--iptal icin
driver.switchTo().alert().dismiss();

--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");

methodları kullanilir!!

 */

}
