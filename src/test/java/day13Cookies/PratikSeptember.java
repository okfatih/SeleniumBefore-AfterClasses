package day13Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PratikSeptember extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        login();

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
        //Tablo başlıklarını yazdırt
        List<WebElement> theadler = driver.findElements(By.xpath("//thead//tr[1]//th"));
        theadler.forEach(t-> System.out.print(t.getText()+ " "));
        //Body içersindeki dataları getir
        List<WebElement> insideBody= driver.findElements(By.xpath("//tbody//tr//td"));
        //insideBody.forEach(t-> System.out.print(t.getText()+ ", "));
        int count = 1;
        for (WebElement e:insideBody
             ) {
            System.out.println(count + ".  " + e.getText());
            count++;

        }



    }
}
