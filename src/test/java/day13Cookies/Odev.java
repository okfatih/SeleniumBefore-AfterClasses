package day13Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Odev extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        login();
        table();
    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
       List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println(sutunSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement allTableBodyandHead = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Tüm body ve basliklar " + allTableBodyandHead.getText());

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

     //   driver.findElement(By.xpath("//*[@id='Username']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}
/*
Bir class oluşturun : D18_WebTables
login( ) metodun oluşturun ve oturum açın.
https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
Username : manager  ○ Password : Manager2!
table( ) metodu oluşturun
Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
printRows( ) metodu oluşturun //tr
table body’sinde bulunan toplam satir(row) sayısını bulun.
Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
4.satirdaki(row) elementleri konsolda yazdırın.
printCells( ) metodu oluşturun //td
table body’sinde bulunan toplam hücre(cell) sayısını bulun.
Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
printColumns( ) metodu oluşturun
table body’sinde bulunan toplam sutun(column) sayısını bulun.
Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
5.column daki elementleri konsolda yazdırın.
 */