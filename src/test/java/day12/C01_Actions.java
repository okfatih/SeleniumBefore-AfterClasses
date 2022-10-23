package day12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void title1 (){
        driver.get("https://www.automationexercise.com");
        //Product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk ürüne tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
    @Test
    public void test2(){
        driver.get("https://amazon.com");
        driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();
        WebElement todaysDeals = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(todaysDeals).click().perform();

    }
}
