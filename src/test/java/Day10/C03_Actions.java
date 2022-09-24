package Day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        /*
        Soru 1:  Go webpage amazon.com
        Account menüsünden create a list linkine tıklayalım

         */
        driver.get("https://amazon.com");
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
      Actions actions = new Actions(driver);
      /*
      Bir websitesinde bir mouse ile açılan bir webelementine
      ulaşmak istersek actions.moveToElement kullanamamız gerekir
      aksi takdirde html codeları arasında web elementi bulur ama ulaşamadığı için
      element not interactable exceptionı verir
       */
      actions.moveToElement(accountList).perform(); //move to Element istediğimiz elemanın üstünde tutat mouse

      driver.findElement(By.xpath("//*[text()='Create a List']")).click();
  }

}
