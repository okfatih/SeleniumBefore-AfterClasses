package seleniumPratik;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P07 extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        String[] arr = {"Yemek","Bulaşık","Camasir","Joggin"};
        List<String>works = new ArrayList<>();
        works.addAll(Arrays.asList(arr));
        System.out.println(works);
        WebElement addTodo = driver.findElement(By.xpath("//input[@type='text']"));

        for (String w:works
             ) {
          actions.moveToElement(addTodo).sendKeys(w,Keys.ENTER).click().perform();
        }
       List<WebElement>deleteButtons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        deleteButtons.stream().forEach(t->t.click());

        List<WebElement>bosToDoButtons = driver.findElements(By.xpath("//input[@placeholder='Add new todo']"));
        Assert.assertEquals(bosToDoButtons.size()-1,0);
    }
}
/*
// http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
// Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
//Tüm yapılacakların üzerini çiz.
//Tüm yapılacakları sil.
//Tüm yapılacakların silindiğini doğrulayın.
exploratory testing


Keşif Testi (Exploratory Testing) , test senaryolarının önceden oluşturulmadığı,
testçilerin sistemi test anında kontrol ettiği bir tür yazılım testidir.
Herhangi bir test senaryosuna bağlı kalmaksızın yazılımları serbestçe keşfederek buldukları bug’ları raporlamasına dayanır.
Test uzmanlarının minimum planlama ve maksimum test uygulamasına katıldığı uygulamalı bir yaklaşımdır.
Testin yürütülmesinden önce neyin test edileceğine dair fikirleri not edebilirler.
Keşif Testi (Exploratory Testing), diğer test yaklaşımlarında kolayca kapsanmayan hataları ve eksiklikleri keşfetmeye, ortaya çıkarmaya dayanır.
Özellikle yazılım test döngüsünün başlarında sıkça başvurulan bir test türüdür.
 Test uzmanı açısından ise istediği şekilde son kullanıcı senaryoları oluşturma imkanı olduğu için eğlencelidir.




 */