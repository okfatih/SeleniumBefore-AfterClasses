package day12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_FileUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/upload");
        /*
        Dosyasec butonuna direkt click yapayabiliriz
        Çünkü windows'a müdahaleye izin vermeyeilir
        Bu yüzden dosyasec butonunu direkt locate edip
        sendKeys() methodu ile String değişkene atadığımız dosya yolumuzu göndeririz

         */
          WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
          String dosyaYolu = "C:\\Users\\Admin\\Desktop\\New Text Document.txt";
          dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());

    }
}
/*
https://the-internet.herokuapp.com/upload adresine gidelim
chooseFile butonuna basalim
Yuklemek istediginiz dosyayi secelim.
Upload butonuna basalim.
“File Uploaded!” textinin goruntulendigini test edelim.

 */