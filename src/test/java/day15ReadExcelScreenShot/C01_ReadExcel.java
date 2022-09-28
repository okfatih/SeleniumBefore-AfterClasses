package day15ReadExcelScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String tumTablo = "";
        for (int i = 0; i <=sonSatir ; i++) {
            tumTablo= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","
           + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println( tumTablo);
            
        }


    }
}
/*
Excel tablosundaki tüm tabloyu console yazdırın
 */

/*
Farklı çözümler
for (int i = 0; i <= sayi; i++) {

    for (int j = 0; j <= sayi; j++) {


        System.out.println(wk.getSheet("Sayfa1").getRow(j).getCell(i).toString());
PRINT F ILE COZUM
for (int i = 0; i <=sonData ; i++) {
    System.out.printf("%-15s %-15s %-15s %-15s\n",workbook.getSheet("Sayfa1")
    .getRow(i).getCell(0),workbook.getSheet("Sayfa1").getRow(i).
    getCell(1),workbook.getSheet("Sayfa1").getRow(i).getCell(2),workbook.getSheet("Sayfa1").getRow(i).getCell(3));

    }


}

 */