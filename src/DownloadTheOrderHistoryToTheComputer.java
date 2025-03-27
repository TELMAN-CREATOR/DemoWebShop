import Utilty.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DownloadTheOrderHistoryToTheComputer extends BaseDriver {

    @Test
    public void Test1() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/");

        Actions actions=new Actions(driver);
        actions.perform();

        WebElement login= driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.click(login).perform();

        WebElement Email= driver.findElement(By.xpath("//input[@id='Email']"));
        actions.click(Email).sendKeys("techno@tester.com").perform();

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        actions.click(password).sendKeys("Password123").perform();

        WebElement login2=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.click(login2).perform();








        TearDown();
    }
}
