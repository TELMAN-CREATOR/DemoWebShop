import Utilty.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NegativeUsingCouponsAndGiftCards extends BaseDriver {

    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.click(login).perform();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        actions.click(email).sendKeys("techno@tester.com").perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        actions.click(password).sendKeys("Password123").perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.click(loginButton).perform();

        WebElement computers = driver.findElement(By.xpath("(//a[@href='/computers'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(computers));
        actions.moveToElement(computers).perform();

        WebElement noteBooks = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(noteBooks));
        actions.click(noteBooks).perform();

        WebElement addToCart = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        actions.click(addToCart).perform();

        WebElement shoppingCart = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        actions.click(shoppingCart).perform();

        WebElement discountCode = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actions.click(discountCode).perform();

        WebElement couponMessage = driver.findElement(By.xpath("//div[contains  (text(), 'The coupon')]"));
        wait.until(ExpectedConditions.visibilityOf(couponMessage));

        Assert.assertTrue(couponMessage.getText().contains("The coupon code you entered couldn't be applied to your order"));

        WebElement giftCards = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actions.click(giftCards).perform();

        WebElement giftMessage = driver.findElement(By.xpath("(//div[@class='coupon-code'])[2]/following-sibling::div"));
        wait.until(ExpectedConditions.visibilityOf(giftMessage));

        Assert.assertTrue(giftMessage.getText().contains("The coupon code you entered couldn't be applied to your order"));

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        actions.moveToElement(checkbox).click().perform();

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        actions.click(checkout).perform();

        WebElement billingAddress = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input"));
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
        actions.click(billingAddress).perform();

        WebElement pickUp = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        actions.click(pickUp).perform();

        WebElement shippingAddress = driver.findElement(By.xpath("//div[@id='shipping-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(shippingAddress));
        actions.click(shippingAddress).perform();

        WebElement paymentMethod = driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        actions.click(paymentMethod).perform();

        WebElement paymentInformation = driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(paymentInformation));
        actions.click(paymentInformation).perform();

        WebElement confirm = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(confirm));
        actions.click(confirm).perform();

        WebElement orderConfirmationMessage = driver.findElement(By.xpath("//div[@class='title']/strong"));

        Assert.assertTrue("Siparişiniz oluşturulamadı", orderConfirmationMessage.getText().contains("Your order has been successfully processed!"));

        TearDown();
    }
}
