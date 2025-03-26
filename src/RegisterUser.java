import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegisterUser extends BaseDriver {

    @Test
    public void Test1() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        actions.click(register).perform();

        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-female']"));
        actions.click(gender).perform();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        actions.click(firstName).sendKeys("techno").perform();

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        actions.click(lastName).sendKeys("study").perform();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        actions.click(email).sendKeys("techno@tester.com").perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        actions.click(password).sendKeys("Password123").perform();

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        actions.click(confirmPassword).sendKeys("Password123").perform();

        WebElement verifyRegister = driver.findElement(By.xpath("//input[@id='register-button']"));
        actions.click(verifyRegister).perform();

        WebElement message = driver.findElement(By.xpath("//div[class='result']"));

        Assert.assertTrue("Kayıt oluşturulamadı", message.getText().contains("Your registration completed"));

        TearDown();
    }
}
