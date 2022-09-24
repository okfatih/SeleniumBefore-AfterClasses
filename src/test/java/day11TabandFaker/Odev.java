package day11TabandFaker;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class Odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        WebElement hof = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hof).perform();
        WebElement list = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.moveToElement(list).click().perform();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement releaseKisim = driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.moveToElement(releaseKisim).clickAndHold().perform();
        System.out.println(releaseKisim.getText());
        WebElement doubleClick = driver.findElement(By.id("double-click"));
        actions.moveToElement(doubleClick).doubleClick().perform();


    }
}
/*
Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
 2- Hover over Me First" kutusunun ustune gelin
Link 1" e tiklayin
Popup mesajini yazdirin
Popup'i tamam diyerek kapatin
“Click and hold" kutusuna basili tutun
7-“Click and hold" kutusunda cikan yaziyi yazdirin
8- “Double click me" butonunu cift tiklayin
Collapse



white_check_mark
eyes
raised_hands













 */