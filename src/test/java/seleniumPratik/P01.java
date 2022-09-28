package seleniumPratik;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    //1. Iframelerin hepsinin bulunduğu tabakayı locate et ki üzerinde işlem yapabilesin
    WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
    driver.switchTo().frame(iframe);
    //ikincim emojiyi tıklat
     driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

     //2.
        // tüm hayvan emojilerini bir listeye al
        // ve tüm hayvan emojilerini tıkla

        List<WebElement> animalsiframeListesi = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
//        for (WebElement e:animalsiframeListesi) {
//            e.click();
//
//        }
        //lambda ile
       // animalsiframeListesi.forEach(t->t.click());
    driver.switchTo().defaultContent();//Iframeden çıkmayı unutma
        //text boxun içindeki hepsini bir liste ata
        //Hoca burada harikja bir çözüm buldu iki tane liste yaptı alttaki ikinci liste
        // forma göndereceğimiz Stringleri içeren bir liste
        List<WebElement>box =driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String>formDegerleri = new ArrayList<>(Arrays.asList("Hayva","Gulusler","Park","Kunefe","tennis","rakamlar","medeniyey","Europe",",","Ok","t"));
        for (int i = 0; i <box.size() ; i++) {
            box.get(i).sendKeys(formDegerleri.get(i));

        }
        //Apply buttonuna tıkla
        WebElement applyButtonu = driver.findElement(By.xpath("//button[@class='mdl-button mdl-js-button mdl-button--raised mdl-button--colored']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",applyButtonu);
        driver.close();
    }



}
//Siteye git 2. emojiye tıkla formu doldur
//tüm hayvan emojilerine tıkla
