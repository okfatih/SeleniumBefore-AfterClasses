package day13Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/*
// -- tabloda <table> tagi altinda tablonun basligini gosteren <thead> tagi bulunur
// -- eger baslikta satir(row) varsa <thead> tagi altinda <tr> (satir-row) tagi vardir
// -- ve basliktaki sutunlara yani hucrelere(cell) de <th> tagi ile ulasilir
// -- basligin altindaki tablodaki verilere <tbody> tagi ile altindaki satirlara (row)
// -- <tr> tagi ile sutunlara yani hucrelere <td> tagi ile ulasiriz
Genel HTML kodlari acisindan tablo elementleri tag'lerle belirlenmistir.
             - <table>
             - <header> tablonun baslik kismini belirler
                <tr> veya <th> satirlari
                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
             - <tbody> tablo body'si
                <tr> satirlari
                <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
 */

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test() {
        login();
        table();
        printRows();
    }

    private void printRows() {
      List<WebElement>  satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi: " + satirSayisi.size());

    }

    private void table() {

        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println(sutunSayisi.size());

        // başlıkları yazdır
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar: "+ basliklar.getText());

        //body yazdir
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body " + body.getText());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement>  satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        satirSayisi.stream().forEach(t-> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.

        WebElement row4th = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("4.satır" + row4th.getText());



    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).
        sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();




    }
}
/*Bir class oluşturun : C02_WebTables
login( ) metodun oluşturun ve oturum açın.
https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
Username : manager
Password : Manager1!
table( ) metodu oluşturun
Tüm table body’sinin boyutunu(sutun sayisi) bulun.
Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
printRows( ) metodu oluşturun //tr
table body’sinde bulunan toplam satir(row) sayısını bulun.
Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
4.satirdaki(row) elementleri konsolda yazdırın.

 */