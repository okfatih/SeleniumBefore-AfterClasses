package Day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragme = driver.findElement(By.xpath("//*[@class='drag-box mt-4 ui-draggable ui-draggable-handle']"));
        WebElement dropMe = driver.findElement(By.xpath("//*[text()='Drop here']"));
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragme,dropMe).perform();

        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }

}
/*
Yeni bir class olusturalim: MouseActions2
https://demoqa.com/droppable adresine gidelim
“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
“Drop here” yazisi yerine “Dropped!” oldugunu test edin
 */