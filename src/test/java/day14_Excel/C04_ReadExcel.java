package day14_Excel;

import com.github.javafaker.File;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void test1() throws IOException {
       String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

      int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);

        String turkceBaskentler ="";
        for (int i = 0; i <=sonSatir ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);

        }
    }
    /*
    //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Turkce baskentler sutununu yazdiralim
     */

    /*
    Lambda ile

    List<String> list=new ArrayList<>();
for (int i = 0; i <=sonsatir ; i++) {
    list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
}
list.forEach(t-> System.out.println(t));
     */
}
