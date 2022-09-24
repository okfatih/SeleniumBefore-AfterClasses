package day12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C04_Soru2 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textbox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textbox.isEnabled()); //Textbox’in etkin olmadigini(enabled) dogrulayın

        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));


    }

    @Test
    public void test2() {
    }
}


/*
1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrula
 Textbox’in etkin oldugunu(enabled) dogrulayın
 */