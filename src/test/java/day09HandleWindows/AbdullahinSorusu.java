package day09HandleWindows;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Set;

public class AbdullahinSorusu extends TestBaseBeforeAfter  {
    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        Actions action = new Actions(driver);

        WebElement el = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        action.doubleClick(el).perform();

        Set<String> windows = driver.getWindowHandles();

        System.out.println(windows);

        int size =windows.size();

        String[] asdf = {"w1","w2","w3"};

        System.out.println("driver.getTitle() = " + driver.getTitle());

        int indx = 0;
        for (String each : windows
        ) {
            asdf[indx] = each;
            indx++;
        }

        System.out.println(Arrays.toString(asdf));

        String w1 = asdf[0];
        String w2 = asdf[1];
        String w3 = asdf[2];

        driver.switchTo().window(w2);
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }
}
