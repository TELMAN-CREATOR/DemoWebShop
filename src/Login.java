import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseDriver {
    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginin= driver.findElement(By.xpath("//a[@href='/login' and @class='ico-login']"));
        Actions ActionDriver1=new Actions(driver);
        Action Action1=ActionDriver1.moveToElement(loginin).click().build();
        Action1.perform();

        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.sendKeys("techno@tester.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Password123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in' and @type='submit']"));
        Actions ActionDriver=new Actions(driver);
        Action Action=ActionDriver.moveToElement(loginButton).click().build();
        Action.perform();


        WebElement element= driver.findElement(By.xpath("//a[text()='techno@tester.com']"));
        Assert.assertTrue(element.getText().equals("techno@tester.com"));


        TearDown();
    }

}
