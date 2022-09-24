package Day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        driver.get("https://amazon.com");


    }
}
