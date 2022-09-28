package seleniumPratik;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P05 extends TestBaseBeforeAfter {
    static Select select;
    @Test
    public void test1() {
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Fatih");
        //fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ok");
        //check the gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();

        //check the experience
        driver.findElement(By.xpath("//input[@id='exp-0']")).click();
        //fill the date
        driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("28/09/2022",Keys.ENTER);
        //choose your profession -> Automation Tester
        driver.findElement(By.xpath("//*[@id='profession-1']")).click();
        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        //choose your continent -> Antartica
        WebElement continentWe=driver.findElement(By.xpath("(//*[@class='input-xlarge'])[1]"));
        select=new Select(continentWe);
        select.selectByVisibleText("Antartica");
        List<WebElement> ddmenu = select.getOptions();
        //choose your command  -> Browser Commands
        WebElement dropDownCommand = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        Select select2 = new Select(dropDownCommand);
        select2.selectByVisibleText("Browser Commands");
        //click submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

    }
}
