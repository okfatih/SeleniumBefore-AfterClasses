package Day07_DropDownMenu;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownSelectile {
    static WebDriver driver;
   static Select secim;
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
/*
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu testedin
 */


        /*
        Dropdown menuye ulaşmak içinn select classından bir obje oluştururuz
        ve locate ettiğimiz dropdown webelementini Select klasına tanımlarız
        ve getOption methodunu kullanarak dropdown u bir liste atarak dropdown menunun bütün elemanlarının
        sayısına ulaşabiliriz
         */
        WebElement dropdownmenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']")); //Dropdown u webelemente atadık
         secim = new Select(dropdownmenu); // Select objesine ekledik
        List<WebElement>ddmList = secim.getOptions();
        System.out.println(ddmList.size());
        int expectedNumber = 45;
        int actualNumber =  ddmList.size();
        Assert.assertNotEquals(expectedNumber,actualNumber);


    }
    @Test
    public void test2(){
        //1.Kategori menusunden Books seceneginisecin
        WebElement dropdownmenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        secim =new Select(dropdownmenu);
        secim.selectByVisibleText("Books");// drop down menudeki optioa string olarak ulaşmak istersek
        secim.selectByIndex(5);// drop down menudeki optioa integer olarak ulaşmak istersek
        System.out.println(secim.getFirstSelectedOption().getText());
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

//3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucyazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(sonucyazisi.getText());
        //4
        String expectedKelime = "Java";
        String actualSonuc = sonucyazisi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        /*
        Dropdown menude seçtiğiöiz optiona ulaşmak istersek select.getFirstSelectedOption()
        mehodunu kullanıyoruz
         */


    }

    @AfterClass
    public static void tearDown(){
driver.close();
    }

}
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
4.Sonuc
)
 */