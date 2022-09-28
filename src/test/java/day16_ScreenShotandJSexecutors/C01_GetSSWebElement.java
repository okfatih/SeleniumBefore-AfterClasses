package day16_ScreenShotandJSexecutors;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class C01_GetSSWebElement extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);


        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        File resultTextPic = new File("target/EKranGoruntuleri/result"+tarih+".jpeg");
        File temp = result.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp, resultTextPic);

    }
}
/*
  File sonucYazisiResmi = new File("target/EKranGoruntuleri/result"+tarih+".jpeg");

        File temp = sonucYazıElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYazisiResmi);
 */