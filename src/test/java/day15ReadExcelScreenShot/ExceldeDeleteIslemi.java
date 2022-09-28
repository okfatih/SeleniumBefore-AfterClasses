package day15ReadExcelScreenShot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExceldeDeleteIslemi {
    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

     Sheet sheet = workbook.getSheet("Sayfa1");

     Row row = sheet.getRow(3);

     Cell cell = row.getCell(3);
     /*
     Vir cell deki veriyi silmek için row objesine
     htiyaç vardır
     Row objesi ile removecell methodunu kullanarak cell objesi
     için belirttiğimiz cell değerini silebiliriz
      */
     row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        String actualData = null;
        String expectedData = "Cezayir";
        Assert.assertNotEquals(expectedData,actualData);



    }
}
/*
//-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        //-3. Satır 3. Cell'deki veriyi silelim
        //-Silindiğini test edin
Collapse











 */