package day13Cookies;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Odev2 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //Headers da bulunan department isimlerini yazdirin
        List<WebElement> dem = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
       dem.stream().forEach(t-> System.out.print(t.getText()));
        dem.stream().skip(2).limit(1).forEach(t-> System.out.println("3.eleman: " + t.getText()));

        for (int i = 0; i <dem.size() ; i++) {
            if (i==2){
                System.out.println("3.eleman: " + dem.get(i).getText());
            }

        }
       // driver.close();

       List<WebElement>tumDatalar = driver.findElements(By.xpath("//div[@class='ReactTable -striped -highlight']"));
       tumDatalar.forEach(t-> System.out.println(t.getText()));

        List<WebElement>tabloadkiSatirlar = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        tabloadkiSatirlar.forEach(t-> System.out.println(t.getText()));
        System.out.println("tabladaki Satirlarin sayisi:  " + tabloadkiSatirlar.size());

    }
    @Test
    public void test2(){
        driver.get("https://demoqa.com/webtables");
        //Tablo başlıkları
        List<WebElement>departmantSayisi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("departmantSayisi.size() = " + departmantSayisi.size());
        System.out.println("*********************");
        //Tablodaki tüm elemanlar
        List<WebElement>tumElemanlar = driver.findElements(By.xpath("//div[@class='rt-table']"));

        tumElemanlar.forEach(t-> System.out.print(t.getText()+", "));
        //Tabloadaki cell sayisi
        System.out.println("*********************");
        List<WebElement>tabloadakiCell= driver.findElements(By.xpath("//div[@class='rt-td']"));
        tabloadakiCell.forEach(t-> System.out.println(t.getText()));
        System.out.println("tabloadaki hücre sayisi: " + tabloadakiCell.size());
        //Tabloaki satir sayisini yazdiralim

        List<WebElement>tabloadkiSatirlar = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        tabloadkiSatirlar.forEach(t-> System.out.println(t.getText()));
        System.out.println("tabladaki Satirlarin sayisi:  " + tabloadkiSatirlar.size());

        List<WebElement> baslikYazdirma = driver.findElements(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        baslikYazdirma.forEach(t-> System.out.println(t.getText()));

    }
}
/*
Bir Class olusturun D19_WebtablesHomework
“https://demoqa.com/webtables” sayfasina gidin
Headers da bulunan department isimlerini yazdirin
sutunun basligini yazdirin
Tablodaki tum datalari yazdirin
Tabloda kac cell (data) oldugunu yazdirin
Tablodaki satir sayisini yazdirin
Tablodaki sutun sayisini yazdirin
Tablodaki 3.kolonu yazdirin
Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
 */
