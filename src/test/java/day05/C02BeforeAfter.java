package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02BeforeAfter {
    WebDriver driver;
   @Before
   //Before notasyonu her testten önce çalışır
   //Before anotasyonlarında before methoduna setup yapılır
    public void setUp(){
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void method1() throws InterruptedException {
       Thread.sleep(2000);
       // Burada bir defa before methodu çalışır
       driver.get("https://amazon.com");
        // Bir defa da after methodu çalışır
   }
   @Test
    public void method2(){
        // Burada bir defa before methodu çalışır
        driver.get("https://hepsiburda.com");
        // Bir defa da after methodu çalışır
    }
    @Test
    public void method3(){
        // Burada bir defa before methodu çalışır
        driver.get("https://hepsiburda.com");
        // Bir defa da after methodu çalışır
    }
    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown() {
       driver.close();
    }
}


/*
/*
    bir class da;
     -->@before ile olusturulan method class icindeki her test method'undan once ve 1 kez calisir ve
     genellikle public  void setup() seklinde yazilir
     -->@after ile olusturlan method class icindeki her test method'undan sonra ve 1 kez calisir ve
     genellikle public void tearDown() seklinde yazilir
     */
