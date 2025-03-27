import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class NegativeRegisterUser extends BaseDriver {

    @Test
    public void Test1() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/");

        Actions actions=new Actions(driver);

        WebElement registerBtn= driver.findElement(By.xpath("//a[@class='ico-register']"));
        actions.click(registerBtn).perform();

        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        actions.click(gender).perform();

        WebElement FirstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        actions.click(FirstName).sendKeys("Techno").perform();

        WebElement LastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        actions.click(LastName).sendKeys("study").perform();

        WebElement Email= driver.findElement(By.xpath("//input[@id='Email']"));
        actions.click(Email).sendKeys("techno@tester.com").perform();

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        actions.click(password).sendKeys("Password123").perform();

        WebElement confirmPassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        actions.click(confirmPassword).sendKeys("Password123").perform();

        WebElement registerBtn2= driver.findElement(By.xpath("//input[@id='register-button']"));
        actions.click(registerBtn2).perform();

        WebElement element= driver.findElement(By.xpath("//div[@class='message-error']"));

        Assert.assertTrue(element.getText().contains("The specified email already exists"));

        TearDown();

    }
}
