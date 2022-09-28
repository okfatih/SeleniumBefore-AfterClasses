package seleniumPratik;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.idealized.Javascript;

public class P06 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//*[@id='button1']")).click();

        // 3. Açılır metni alın
        System.out.println(driver.switchTo().alert().getText());
        String actualMesaj = driver.switchTo().alert().getText();
        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedMesaj = "I am an alert box!";
        Assert.assertEquals(expectedMesaj,actualMesaj);

        // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();
    }
}
