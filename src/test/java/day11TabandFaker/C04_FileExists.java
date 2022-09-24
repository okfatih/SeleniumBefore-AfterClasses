package day11TabandFaker;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists extends TestBaseBeforeAfter {
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\Admin\IdeaProjects\demo\com.81JUnit
        //Şuanki içinde bulundugum yolu gösterir
        System.out.println(System.getProperty("user.home")); //C:\Users\Admin
        //Geçerli kullanıcının ana dizinin verir

        String farkliBolum = System.getProperty("user.home"); //masaüstündeki dosyanın adı


        String ortakBolum = "\\Onedrive||Masaustu\\text.txt";

        String masaUstuDosyaYolu = farkliBolum + ortakBolum; //Masaustundeki dosya ylunu gösterir

//        System.out.println(masaUstuDosyaYolu); //C:\Users\Admin\Onedrive||Masaustu\text.txt
//        System.out.println(Files.exists(Path.of(masaUstuDosyaYolu)));
       // Assert.assertTrue(Files.exists(Path.of(masaUstuDosyaYolu)));

        String dosyaYolu = "C:\\Users\\Admin\\Desktop\\New Text Document.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Bir web sitesinden indirdiğimiz veya windows içinde  oluşturduğumuz
        dosyanın indiğini ya da orda olduğunu test edebilmem için o dosyanın
        üzerine shift  ile basılı olarak sağ klik yapıp dosyanı yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı dogrulamak için bu methodu kullanırız

         */
    }
}
