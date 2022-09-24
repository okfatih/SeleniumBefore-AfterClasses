package automationExercises;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IncorrectLoginUser extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        driver.get("https://automationexercise.com");

        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        //Sign in
        WebElement signIn = driver.findElement(By.xpath(" //*[@class='fa fa-lock']"));
        signIn.click();
        Actions action = new Actions(driver);
        Faker fake = new Faker();
        WebElement lgtoyour = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(lgtoyour.isDisplayed());
        System.out.println(lgtoyour.getText());
        // Enter correct email address and password
        WebElement emailBox = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        WebElement passwordBox = driver.findElement(By.xpath("//*[@name= 'password']"));
        String email =fake.internet().emailAddress();
        String password = fake.internet().password();
        action.click(emailBox).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(password).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());



    }
}
