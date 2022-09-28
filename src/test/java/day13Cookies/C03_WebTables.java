package day13Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    /*
    1.Bir önceki classtaki adrese gidelim
    2. Giriş yap methodunu kullanarak sayfaya giriş yapalım

    WebElement tekilHucre = driver.findElement(By.xpath("//tbody//tr[6]//td[4]"));

   Pricebaşlığındaki tüm numaraları yazdır



     */


    @Test
    public void tet1() {
        login();

        /*
          3. Input olarak verilen satır ve sütün sayısına sahip
        cell deki texti yazdıralım



         */
        int satir = 3;
        int sutun = 4;

        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(cell.getText());

        //PRice başlığındaki tüm numaraları yazdır
        List<WebElement> price = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        price.forEach(t-> System.out.println(t.getText()));

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
