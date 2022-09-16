package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru {
    WebDriver driver;
    @Before
    public void setUp1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void  tearDown(){
       // driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get(" https://the-internet.herokuapp.com/checkboxes");
        WebElement checbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
Thread.sleep(2000);
    if (!checbox1.isSelected()){
        checbox1.click();
    }
        Thread.sleep(2000);
    if (!checbox2.isSelected()){
        checbox2.click();
    }

    }

}
/*
 1. Bir class oluşturun : CheckBoxTest
      2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */
