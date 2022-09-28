package day16_ScreenShotandJSexecutors;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
driver.get("https://hotelmycamp.com");


        WebElement secondRoom = driver.findElement(By.xpath("(//div[@class='text p-3 text-center'])[2]"));
        WebElement secondroomclick = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",secondRoom);
        js.executeScript("arguments[0].click();",secondroomclick);
        String odaSayfasi = driver.getCurrentUrl();
        System.out.println(odaSayfasi);
        ;
Assert.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());


    }
}
/*
Yeni bir class olusturun : ScroolInto
hotelmycamp anasayfasina gidin
2 farkli test method’u olusturarak actions classi
 ve Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
istediginiz oda inceleme sayfasi acildigini test  edin


white_check_mark
eyes
raised_hands


 */