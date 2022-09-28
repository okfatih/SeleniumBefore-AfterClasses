package day14_Excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook work = WorkbookFactory.create(fis);
        Sheet sheet = work.getSheet("Sayfa2");
        int sonSatir = work.getSheet("Sayfa2").getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);
        int expectedLastRow = 6;
        Assert.assertEquals(expectedLastRow,sonSatir+1);
        //Excelde kullanılan satır
        int kullanilanSatir  = work.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatir = " + kullanilanSatir);
        int expectedSatir = 6;
        Assert.assertEquals(expectedLastRow,kullanilanSatir);

    }
}
/*
//-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
 */