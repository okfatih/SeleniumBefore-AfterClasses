package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void test1() throws IOException {

        /*
        Belirtilen satırNo ve sütün no değerlerini parametre olarak alıp
        o celldeki datayı konsola yazdıralım.
        Sonucun  konsolda yazanla aynı olduğunu doğrulayalım
         */
        int satirNo = 12;
        int hucreNo = 2;
        //Dosya yolunu bir String degiskene atayali
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);//workbook objesiyle akışa aldığımız dosyamızla bir excel dosyası create ettik

      String actualData =   workbook.getSheet("Sayfa1").
                getRow(satirNo-1).
                getCell(hucreNo-1).
                 toString();
        System.out.println(actualData);
    //Index 0 dan başladığı  için bizden istenen satıra ulaşabilmek için 1 eksiğini alırız
        String expectedData = "Baku";
        Assert.assertEquals(expectedData,actualData);
    }
}
