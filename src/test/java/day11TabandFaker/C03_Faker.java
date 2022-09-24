package day11TabandFaker;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
// faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
// ve en cok kullanilani pom.xml dosyamiza ekleriz
// ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
// emailAdress() methodunu seceriz
// password icinde ayni internet methodunu kullaniriz
// isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
// faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi üretecegimiz
// veriler yerine bizim icin random veriler üretir ve isimizi kolaylastirir
:pray::skin-tone-2::pray::pray::skin-tone-5:
7


 */

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("https://www.facebook.com ");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Faker faker = new Faker();
        WebElement isim =  driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress();
        actions.click(isim).sendKeys(faker.name().
                firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()). sendKeys(Keys.TAB). sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1982").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
/*

 */