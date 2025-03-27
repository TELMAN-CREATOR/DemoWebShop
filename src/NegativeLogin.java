import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NegativeLogin extends BaseDriver {

    @Test
    public void TestNegLog() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("techno@tester.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("YanlisSifre");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue(errorMessage.getText().contains("Login was unsuccessful."));

        TearDown();
    }
}
