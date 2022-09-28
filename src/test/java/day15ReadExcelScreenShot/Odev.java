package day15ReadExcelScreenShot;

public class Odev {
    /*
    1.satirdaki 2.hucreye gidelim ve yazdiralim
1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
Satir sayisini bulalim
Fiziki olarak kullanilan satir sayisini bulun
Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */
}
/*
String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println("1. Satir 2. Hucre  " + workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String actualData = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("1. Satir 2. Hucre String degisken = " + actualData);
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualData2 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedData = "Kabil";
        assert expectedData.equals(actualData2);
        //- Satir sayisini bulalim
        int toplamSatirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("toplamSatirSayisi = " + toplamSatirSayisi);
        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki olarak kullanilan satir sayisi = " + (toplamSatirSayisi+1));
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkeBaskentIsimleri = new LinkedHashMap<>(); // LinkedHashMap<>() bu methodu kullanma amacimiz excel'deki satirlarla ayni sekilde siralamasi icin
        for (int i = 1; i <= toplamSatirSayisi; i++) {
            String ingUlkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String ingBaskentIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeBaskentIsimleri.put(ingUlkeIsmi,ingBaskentIsmi);
        }
        System.out.println(ulkeBaskentIsimleri);

 */