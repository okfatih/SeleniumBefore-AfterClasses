package day09HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_windowShandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows ");
        String ilkSiteHandle = driver.getWindowHandle();
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //Click Here butonuna basın.
        Thread.sleep(2000);
        /*
        Bir web sitesine gittiğinizde bir web elementini tıkladığınızda bir web elementi yeni bir sekme ya da pencere
        açılırsa bu yeni açılan sekmenin handle değerini bulabilimek için driver.getWindowHandles() bir array liste atıp
        bütün sayfaların listesine ulaşabilirim. İlk açtığım pencerenin indexi 0 dır. ikinci açılan segmenin indexi 1 dir
        ve ikinci açılan pencerede ya da sekmede işlem yapabilmek için driver.switch to window(listAdı.get(1)) methodunu kullanırız
         */
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(windowList.get(1));

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window");

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSiteHandle = driver.getWindowHandle();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String>windowHandles =new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(windowHandles.get(0));
    }
}
/*
Tests package’inda yeni bir class olusturun: WindowHandle2
https://the-internet.herokuapp.com/windows adresine gidin.
Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
Click Here butonuna basın.
Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
Sayfadaki textin “New Window” olduğunu doğrulayın.
Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
 */