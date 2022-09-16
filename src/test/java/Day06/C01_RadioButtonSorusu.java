package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.beans.Transient;
import java.time.Duration;

public class C01_RadioButtonSorusu {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void method1(){
        driver.get("https://www.facebook.com ");
        //Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy\"]")).click();
        //“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“radio buttons” elementlerini locate edin
        WebElement cinsiyetFemale = driver.findElement(By.xpath("(//*[@class='_58mt'])[1]"));
        WebElement cinsiyetMale = driver.findElement(By.xpath("(//*[@class='_58mt'])[2]"));
        WebElement custom = driver.findElement(By.xpath("(//*[@class='_58mt'])[3]"));
        if (!cinsiyetMale.isSelected()){
            cinsiyetMale.click();
        }


    }
    @After
    public void tearDown(){
       driver.close();
    }
}
//Bir class oluşturun : RadioButtonTest
//Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
//https://www.facebook.com adresine gidin
//Cookies’i kabul edin
//“Create an Account” button’una basin
//“radio buttons” elementlerini locate edin
//Secili degilse cinsiyet butonundan size uygun olani secin