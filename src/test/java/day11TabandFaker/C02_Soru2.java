package day11TabandFaker;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Soru2  extends TestBaseBeforeAfter {
    @Test
    public void name() throws InterruptedException {
        driver.get("https://www.facebook.com ");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Actions actions = new Actions(driver);
       WebElement isim =  driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
       isim.sendKeys("FATİH");
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).

                sendKeys("Evren").
                sendKeys(Keys.TAB).
                sendKeys("evren@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("evren@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).

                sendKeys("12").
                sendKeys(Keys.TAB).
                sendKeys("Sep").
                sendKeys(Keys.TAB).
                sendKeys("1982").
                sendKeys(Keys.TAB). //Gender?
                sendKeys(Keys.TAB). //Female
                sendKeys(Keys.RIGHT). //Male
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
/*
1- https://www.facebook.com adresine gidelim
2- Yeni hesap olustur butonuna basalim
3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim  4- Kaydol tusuna basalim

 */