package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
         WebElement arama =  driver.findElement(By.id("twotabsearchtextbox"));

         arama.sendKeys("Samsung headphones", Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(sonuc.getText()); //1-16 of 246 results for "Samsung headphones" yazdırır
        String sonucArray[] = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("sonucArray[2] = " + sonucArray[2]); // 256 yı yazdırır
        System.out.println(Arrays.toString(sonucArray));

        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class = 'a-section aok-relative s-image-fixed-height'])[1]"));
        firstProduct.click();

        WebElement wholePAge= driver.findElement(By.xpath("//*[@id='a-page']"));


    }
}
/*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */


