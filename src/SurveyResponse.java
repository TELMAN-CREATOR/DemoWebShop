import Utilty.BaseDriver;
import Utilty.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SurveyResponse extends BaseDriver {

    @Test
    public void SurveyResponseTest() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com");
        MyFunc.Wait(2);

        WebElement excellent = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        excellent.click();
        MyFunc.Wait(1);

        WebElement good = driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
        good.click();
        MyFunc.Wait(1);

        WebElement poor = driver.findElement(By.xpath("//input[@id='pollanswers-3']"));
        poor.click();
        MyFunc.Wait(1);

        WebElement veryPoor = driver.findElement(By.xpath("//input[@id='pollanswers-4']"));
        veryPoor.click();
        MyFunc.Wait(1);

        WebElement vote = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        vote.click();
        MyFunc.Wait(1);

        WebElement login = driver.findElement(By.xpath("//a[@href='/login' and @class='ico-login']"));
        Actions ActionDriver1 = new Actions(driver);
        Action Action1 = ActionDriver1.moveToElement(login).click().build();
        Action1.perform();
        MyFunc.Wait(1);

        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.sendKeys("techno@tester.com");
        MyFunc.Wait(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Password123");
        MyFunc.Wait(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in' and @type='submit']"));
        Actions ActionDriver = new Actions(driver);
        Action Action = ActionDriver.moveToElement(loginButton).click().build();
        Action.perform();
        MyFunc.Wait(1);

        WebElement excellent2 = driver.findElement(By.xpath("//ul[@class='poll-results'] /li[1]"));
        Assert.assertTrue(excellent2.getText().contains("Excellent"));

        TearDown();


    }
}
