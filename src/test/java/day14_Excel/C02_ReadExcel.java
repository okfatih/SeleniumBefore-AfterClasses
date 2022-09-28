package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        //Dosya yolunu bir String degiskene atayali
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);//workbook objesiyle akışa aldığımız dosyamızla bir excel dosyası create ettik

        String actualData = workbook.
                getSheet("Sayfa1").
                getRow(3).
                getCell(3)
                .toString();
        System.out.println(actualData);

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
    }
}
