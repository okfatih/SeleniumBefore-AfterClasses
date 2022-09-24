package automationExercises;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegisterUser extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        driver.get("https://automationexercise.com");

        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        //Sign in
        WebElement signIn = driver.findElement(By.xpath(" //*[@class='fa fa-lock']"));
        signIn.click();
        WebElement newUserSignUp = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserSignUp.isDisplayed());
        System.out.println(newUserSignUp.getText());
        Actions action = new Actions(driver);

        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement emailaddress = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
      //4. Click on 'Signup / Login' button

        action.click(name).
                sendKeys("Fatih").
                sendKeys(Keys.TAB).
                sendKeys("fatih_ok4@hotmail.com").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).

                perform();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
 //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title = driver.findElement(By.xpath("(//*[@class='radio-inline'])[1]"));
       // WebElement firstCheckbox = (WebElement) driver.findElements(By.xpath("(//*[@type='checkbox'])[1]"));
        action.moveToElement(title).click().
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("fatih012").
                sendKeys(Keys.TAB).
                sendKeys("1").
                sendKeys(Keys.TAB).
                sendKeys("May").
                sendKeys(Keys.TAB).
                sendKeys("2022").
                sendKeys(Keys.TAB).

                sendKeys(Keys.ENTER).


                perform();



    }
}
