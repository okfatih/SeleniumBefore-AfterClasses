package day11TabandFaker;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() {
driver.get("https://amazon.com");
//Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        Actions actions = new Actions(driver);
/*
keyDown(Keys.SHIFT).// shift tusu otomasyon ile bu sekilde kullanılır.
Shift tuşuna basmak için keyDown, shift ten çıkmak için keyUp kullanılır
 */
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramakutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" "). keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).isDisplayed());
    }
}
/*
Bir Class olusturalim KeyboardActions1
https://www.amazon.com sayfasina gidelim
Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
aramanin gerceklestigini test edin
Collapse


 */