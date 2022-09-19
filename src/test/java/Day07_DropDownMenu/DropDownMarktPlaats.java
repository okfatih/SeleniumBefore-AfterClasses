package Day07_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class DropDownMarktPlaats {
    static WebDriver driver;
    static Select secim;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.marktplaats.nl/v/huizen-en-kamers/huizen-te-huur/m1886991380-woning-te-huur-julianadorp-bij-den-helder");

    }
    @Test
    public void test1(){
        driver.findElement(By.xpath("//*[@class='gdpr-consent-button hz-Button hz-Button--primary hz-Button--lg']")).click();
        //Select objesi ile drop down menu
        WebElement ddm  = driver.findElement(By.xpath("(//*[@class='hz-Dropdown-input'])[1]"));
        secim = new Select(ddm);
        //DropDown menuye 2. elemanı seçtirelim
        secim.selectByIndex(2);
        //DropDown menudeki optionları bir liste atayıp listenin eleman sayısıyla ilgili testler yapalım
        List<WebElement>ddmmenu =secim.getOptions(); //Dropdpwn menunun hepsini alabilmek için liste atamak gerekiyor
        //Dropdown menudeki elemanları yazdıralım
        ddmmenu.stream().forEach(t-> System.out.print(t.getText()+", "));
        // sizeını test edelim
        int ddmexpectedSize = 40;
        int ddmactualSize = ddmmenu.size();
        Assert.assertNotEquals(ddmactualSize,ddmexpectedSize);
        System.out.println("DropDown menunun eleman sayisi:" + ddmmenu.size());

    }
    @Test
    public void test2(){
        //Çerezleri kabul et // Alles acceptaren
        driver.findElement(By.xpath("//*[@class='gdpr-consent-button hz-Button hz-Button--primary hz-Button--lg']")).click();
        //Select objesi ile drop down menu
        WebElement ddm  = driver.findElement(By.xpath("(//*[@class='hz-Dropdown-input'])[1]"));
        secim = new Select(ddm);
        //Drop down menuden Auto's değerini VisibleText ile seçtir
        secim.selectByVisibleText("Auto's");
        //seçtiğimiz değeri yazdıralım
        System.out.println(secim.getFirstSelectedOption().getText());//Auto's
        //Search butonuna gel ve arama olaralk BMW  yaz
        WebElement search = driver.findElement(By.xpath("//*[@class='hz-Nav-dropdown-toggle hz-Header-Autocomplete-input']"));
        search.sendKeys("Bmw", Keys.ENTER);
        // Çıkan sonuç sayısını yazdır
        WebElement results = driver.findElement(By.xpath("//*[@class='mp-Nav-breadcrumb-title']"));
        System.out.println(results.getText());
        String sonucYazsisi =results.getText();
        String expectedKelime = "bmw";
        Assert.assertTrue(sonucYazsisi.contains(expectedKelime));

    }
}
