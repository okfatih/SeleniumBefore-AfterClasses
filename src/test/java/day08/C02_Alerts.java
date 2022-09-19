package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    /*
    *
●Bir class olusturun:Alerts
●https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

●Bir metod olusturun:acceptAlert○1.
butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
"You successfully clicked an alert" oldugunu test edin.

●Bir metod olusturun:dismissAlert○2. butona tıklayın,
uyarıdaki Cancel butonuna tıklayın ve resultmesajının"successfuly" icermedigini test edin.

●Bir metod olusturun:sendKeysAlert○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
 */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void test1(){
       //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //Javascript alerti tıkla
        driver.switchTo().alert().accept();

        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(actualMesaj,expectedMesaj);

    }
    @Test
    public void test2() throws InterruptedException {
        //●○2. butona tıklayın, uyarıdaki cancel buyonuna tıkla ve   resultmesajının"successfuly" icermedigini test edin.
Thread.sleep(1000);
    driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println(driver.switchTo().alert().getText());
        //iptale bas
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

        //Result mesajının sucessfully içermediğini test et
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expected = "succesfully";
        Assert.assertFalse(actualMesaj.contains(expected));
    }
    @Test
    public void test3() throws InterruptedException {
        /*
       3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    */
        //3. elementi locate et
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().getText();
        Thread.sleep(2000);
        // Alert üzerindeki mesajı yazdıralım
        driver.switchTo().alert().sendKeys("Fatih");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();//ismi girdikten sonra tamam butonuna basmak çin

        WebElement girilenIsim = driver.findElement(By.xpath("//*[@id='result']"));
       String realName = girilenIsim.getText();
       String expectedName = "Fatih";
       Assert.assertTrue(realName.contains(expectedName));

    }

}
