package day15ReadExcelScreenShot;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        driver.get("https://amazon.nl");

        TakesScreenshot ts = (TakesScreenshot) driver;

        /*
        Bir web sayasının resmini alabilmek için TakesScreenShot classından
        obje oluşturup Geçici bir File classından değişkene TakesScreenShot'dan
        oluşturduğum objeden getScreenShotAs methodunu kullanarak geçiçi bir file oluştururuz

         */


        File tumSayfaResmi =  ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
    }
}
