import Utilty.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DownloadTheOrderHistoryToTheComputer extends BaseDriver {

    @Test
    public void Test1() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);
        actions.perform();

        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.click(login).perform();

        WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
        actions.click(Email).sendKeys("techno@tester.com").perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        actions.click(password).sendKeys("Password123").perform();

        WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.click(login2).perform();

        WebElement account = driver.findElement(By.xpath("//a[text()='techno@tester.com']"));
        actions.click(account).perform();

        WebElement orders = driver.findElement(By.xpath(" (//*[@class=\"inactive\"])[2]"));
        actions.click(orders).perform();

        WebElement details = driver.findElement(By.xpath("//input[@class='button-2 order-details-button' and @value='Details' and @type='button']"));
        actions.click(details).perform();

        WebElement pdfInvoice = driver.findElement(By.xpath("//*[@class='button-2 pdf-order-button']"));
        actions.click(pdfInvoice).perform();

        TearDown();
    }
}