package Day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Action2 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

       // Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.contextClick(ciziliAlan).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        String expectedYazi = "You selected a context menu";
        String alertMesaji = driver.switchTo().alert().getText();
        Assert.assertTrue(alertMesaji.contains(expectedYazi));
      //  Assert.assertTrue(driver.switchTo().alert().getText().contains(expectedYazi));
       // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();


        // Elemental Selenium linkine tiklayalim
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        /*
        Neden liste atıyoruz
         */

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());


    }

}
/*
Yeni bir class olusturalim: MouseActions1
https://the-internet.herokuapp.com/context_menu sitesine gidelim
Cizili alan uzerinde sag click yapalim
Alert’te cikan yazinin “You selected a context menu” oldugunu
test edelim.
Tamam diyerek alert’i kapatalim
Elemental Selenium linkine tiklayalim
Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
Collapse











 */