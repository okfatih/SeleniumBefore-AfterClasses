package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php ");

    }
@Test
    public void test1(){
        WebElement signinButonu = driver.findElement(By.xpath("//*[@class='login']"));
        signinButonu.click();
       WebElement emailbox =  driver.findElement(By.xpath("//*[@id='email_create']"));
       emailbox.sendKeys("gmail.com",Keys.ENTER);
       WebElement invalidEmailAlert = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
       Assert.assertTrue(invalidEmailAlert.isDisplayed());
  //  WebElement emailbox = driver.findElement(By.xpath("//*[@id='email_create']"));
   // emailbox.sendKeys("gmail.com", Keys.ENTER);
    //Assert.assertTrue(driver.findElement(By.xpath("//p[@class='alert alert-danger']")).isDisplayed());


    //Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }
@AfterClass
    public static void teardown(){
       driver.close();


}
}
/*
/ 1.Bir Class olusturalimYanlisEmailTesti
// 2.http://automationpractice.com/index.php sayfasinagidelim
// 3.Sign in butonunabasalim
// 4.Email kutusuna @isareti olmayan bir mail yazipenter'a
// bastigimizda "Invalid email address" uyarisi ciktigini testedelim
:white_check_mark:
3
:tada:
1


 */