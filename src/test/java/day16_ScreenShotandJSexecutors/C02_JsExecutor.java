package day16_ScreenShotandJSexecutors;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JsExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        /*
        Amazon a git
        Aşağıdaki carriers buttonunu görünceye kadar
        JS ile scroll yapalım
        Sonra carrers butonuna JS ile click yapalım
         */
        driver.get("https://amazon.com");
        WebElement amazonLang  = driver.findElement(By.xpath("//*[@id='icp-touch-link-language']"));
        WebElement careers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",amazonLang);
        jse.executeScript("arguments[0].scrollIntoView(true);",careers);
        jse.executeScript("arguments[0].click();",careers);

//        actions.moveToElement(amazonLang).perform();
//        actions.click(amazonLang).perform();
    }
}
