package day14_Excel;

import Utilities.TestBaseBeforeAfter;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel  {
    @Test
    public void test() throws IOException {
        //Dosya yolunu bir String degiskene atayali
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);//workbook objesiyle akışa aldığımız dosyamızla bir excel dosyası create ettik

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");//Excel dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);//Sayfa 1 deki 3. satırı bu şekilde seçeriz
        //- Cell objesi olusturun row.getCell(index)

        Cell cell = row.getCell(3);//Satır seçimi yapıldıktan sonra hücre seçimi bu şekilde yapılır
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData,actualData);

    }
}
/*
/- Dosya yolunu bir String degiskene atayalim
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
 */