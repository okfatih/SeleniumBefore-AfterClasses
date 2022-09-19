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

public class SelectPratik {
    static WebDriver driver;
    static Select options;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @Test
    public void test1(){
        //-Test1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
        //oldugunu testedin

      WebElement dropdownbutton = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
      options = new Select(dropdownbutton);
    //  options.selectByIndex(5);//Books. Web sitesine gider dropdowndaki 5.yi elemente gelir
   //     options.selectByVisibleText("Books");// elementi bu şekilde de seçebiliriz
        List<WebElement> ddm = options.getOptions();
        System.out.println("ddm.size() = " + ddm.size());
        int expectedNumber = 28;
        Assert.assertEquals(ddm.size(),expectedNumber);
        ddm.stream().forEach(t-> System.out.print(t.getText()+ ", "));



    }
    @Test
    public void test2(){
        //1.Kategori menusunden Books seceneginisecin
        WebElement dropdownbutton = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        options = new Select(dropdownbutton);
        options.selectByVisibleText("Books"); // eger select klasını unutursak dropdownbutton.sendKeys("Books") da yapabilizi
        System.out.println(options.getFirstSelectedOption().getText());

        //2.Arama kutusuna Java yazin ve aratin
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        aramakutusu.sendKeys("Java", Keys.ENTER);
        //3.Bulunan sonuc sayisiniyazdirin
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonuc.getText()); //1-16 of over 30,000 results for "Java"
        //4.Check whether the result contains word "Java"
         Assert.assertTrue(sonuc.getText().contains("Java"));


    }
    @AfterClass
    public static void tearDown(){

    }

}
