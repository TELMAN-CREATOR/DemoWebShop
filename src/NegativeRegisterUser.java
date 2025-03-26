import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NegativeRegisterUser extends BaseDriver {
    @Test
    public void Test1() throws InterruptedException {

        driver.get("(https://demowebshop.tricentis.com/");

        Actions actions=new Actions(driver);
        WebElement registerLink= driver.findElement(By.xpath("//a[@class='ico-register']"));
        actions.click().perform();

        WebElement gender= driver.findElement(By.xpath("//input[@id='gender-female']"));
        actions.click().perform();

        WebElement FirstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        actions.click().sendKeys("Techno").perform();

        WebElement LastName= driver.findElement(By.xpath("//input[@id='LastName']"));
        actions.click().sendKeys("study").perform();

        WebElement Email= driver.findElement(By.xpath("//input[@id='Email']"));
        actions.click().sendKeys("techno@tester.com").perform();

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        actions.click().sendKeys("Password123").perform();

        WebElement confirmPassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        actions.click().sendKeys("Password123").perform();

        WebElement registerBtn= driver.findElement(By.xpath("//input[@id='register-button']"));
        actions.click().perform();

        WebElement element= driver.findElement(By.xpath(""));

        Assert.assertTrue(element.getText().contains("The specified email already exists"));

        TearDown();

    }
}
