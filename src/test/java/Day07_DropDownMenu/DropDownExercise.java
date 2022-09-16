package Day07_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDownExercise {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
}
@Test
    public void test1(){
    List<WebElement> dropdown =driver.findElements(By.xpath("//option"));
    System.out.println(dropdown.size());
    for (WebElement e:dropdown
         ) {
        System.out.print(e.getText() + " ");

    }
    int dropdownListeSayisi = dropdown.size();
    int expectedListe = 45;
    Assert.assertNotEquals(expectedListe,dropdownListeSayisi);
    }
    }

/*
/*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresine gidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/
