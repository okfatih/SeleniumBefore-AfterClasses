package day11TabandFaker;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExistsSorusu extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //siteye git
        driver.get("https://the-internet.herokuapp.com/download ");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click(); //dosyaya tıkla indir

        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Admin\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //indirildiğini konsolda gösterin
        System.out.println(Files.exists(Paths.get(dosyaYolu))); //true yada false verir

        //

        //

        //

        //


        //

    }
}
/*
Tests packagenin altina bir class oluşturalim :
C04_FileDownload
Iki tane metod oluşturun : isExist( ) ve downloadTest( )
downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
https://the-internet.herokuapp.com/download adresine gidelim.
test.txt dosyasını indirelim
Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
Collapse

 */