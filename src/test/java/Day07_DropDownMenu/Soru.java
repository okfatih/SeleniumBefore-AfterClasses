package Day07_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.List;

public class Soru {
    static WebDriver driver;
    static Select secim;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void test1(){
        WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id='dropdown']"));
        secim = new Select(dropdownMenu);
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        secim.selectByIndex(1);

        System.out.println(secim.getFirstSelectedOption().getText());
        System.out.println("***************************");
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        secim.selectByValue("2");
        System.out.println(secim.getFirstSelectedOption().getText());
        System.out.println("***************************");
        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        secim.selectByVisibleText("Option 1");
        System.out.println(secim.getFirstSelectedOption().getText());
        System.out.println("***************************");
        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDropDown = secim.getOptions();
        for (WebElement e:tumDropDown
             ) {
            System.out.print(e.getText()+ ", ");

        }
        int tumDropDownBoyutu = tumDropDown.size();
        int beklenenBoyut = 4;
        Assert.assertNotEquals(tumDropDownBoyutu,beklenenBoyut);
    }
}
/*
Bir class oluşturun: DropDown
https://the-internet.herokuapp.com/dropdown adresine gidin.
Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
Tüm dropdown değerleri(value) yazdırın
Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
 */

/*
public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement optionBoxs=driver.findElement(By.xpath("//select[@id='dropdown'][1]"));
        Select select=new Select(optionBoxs);
        //1. Index kullanarak Secenek 1'i (Option 1) secin ve yazdirin
        select.selectByIndex(1); //sectik
        System.out.println(select.getFirstSelectedOption().getText()); // bir onceki adimda sectigimizi yazdiriyoruz
        // 2. Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        // 3. Visible Text(Gorunen metin) kullanarak Secenek'i (Option) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        // 4. Tum dropdown options'i yazdirin
         List<WebElement> tumOpsiyon =select.getOptions();
        for (WebElement each:tumOpsiyon
             ) {
            System.out.println(each.getText());
        }
        // 5. Dropdown'un boyutunu bulun, Dropdown'da 4 oge varsa konsolda True, degilse False yazdirin.
           int dropdownBoyut=tumOpsiyon.size();
           if (dropdownBoyut==4){
               System.out.println("True");
           }else
               System.out.println("False");
    }
 */