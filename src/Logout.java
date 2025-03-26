import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Logout extends BaseDriver {
    @Test
    public void Test3() {
        driver.get("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        actions.click(loginLink).perform();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        actions.sendKeys(email, "techno@tester.com").perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        wait.until(ExpectedConditions.visibilityOf(password));
        actions.sendKeys(password, "Password123").perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        actions.click(loginButton).perform();

        WebElement account = driver.findElement(By.xpath("//a[text()='techno@tester.com']"));
        wait.until(ExpectedConditions.visibilityOf(account));
        actions.click(account).perform();

        WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Log out']"));
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        actions.click(logoutLink).perform();

        driver.navigate().to("https://demowebshop.tricentis.com/customer/info");

        boolean isLogoutVisible;
        if (!driver.findElements(By.xpath("//a[text()='Log out']")).isEmpty()) isLogoutVisible = true;
        else isLogoutVisible = false;

        boolean isLoginVisible;
        if (!driver.findElements(By.xpath("//a[text()='Log in']")).isEmpty()) isLoginVisible = true;
        else isLoginVisible = false;

        Assert.assertFalse(isLogoutVisible);
        Assert.assertTrue(isLoginVisible);
    }
}
