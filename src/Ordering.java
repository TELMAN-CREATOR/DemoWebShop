import Utilty.BaseDriver;
import Utilty.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ordering extends BaseDriver {

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
        actions.moveToElement(computers).pause(Duration.ofMillis(500)).perform();

        WebElement noteBooks = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(noteBooks));
        actions.click(noteBooks).perform();

        WebElement addToCart = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        actions.click(addToCart).pause(Duration.ofMillis(500)).perform();
        MyFunc.Wait(2);

        WebElement shoppingCart = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        actions.click(shoppingCart).perform();
        MyFunc.Wait(2);

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        actions.moveToElement(checkbox).pause(Duration.ofMillis(500)).click().perform();

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        actions.click(checkout).pause(Duration.ofMillis(500)).perform();

        WebElement billingAddress = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input"));
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress));
        actions.click(billingAddress).pause(Duration.ofMillis(500)).perform();

        WebElement pickUp = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        actions.click(pickUp).pause(Duration.ofMillis(500)).perform();

        WebElement shippingAddress = driver.findElement(By.xpath("//div[@id='shipping-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(shippingAddress));
        actions.click(shippingAddress).pause(Duration.ofMillis(500)).perform();

        WebElement creditCard = driver.findElement(By.cssSelector("[id='paymentmethod_2']"));
        wait.until(ExpectedConditions.elementToBeClickable(creditCard));
        actions.click(creditCard).pause(Duration.ofMillis(500)).perform();

        WebElement paymentMethod = driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        actions.click(paymentMethod).pause(Duration.ofMillis(500)).perform();

        WebElement cardholderName = driver.findElement(By.cssSelector("[id='CardholderName']"));
        wait.until(ExpectedConditions.elementToBeClickable(cardholderName));
        actions.click(cardholderName).pause(Duration.ofMillis(500)).sendKeys("Yiğithan DÜZGÜN").perform();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        wait.until(ExpectedConditions.elementToBeClickable(cardNumber));
        actions.click(cardNumber).pause(Duration.ofMillis(500)).sendKeys("4242 4242 4242 4242").perform();

        WebElement day = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
        WebElement year = driver.findElement(By.xpath("//select[@id='ExpireYear']"));

        Select dayOption = new Select(day);
        dayOption.selectByValue("1");

        Select yearOption = new Select(year);
        yearOption.selectByValue("2032");

        WebElement cardCode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        wait.until(ExpectedConditions.elementToBeClickable(cardCode));
        actions.click(cardCode).pause(Duration.ofMillis(500)).sendKeys("123").perform();

        WebElement paymentInformation = driver.findElement(By.cssSelector("[id='payment-info-buttons-container']>p+input"));
        wait.until(ExpectedConditions.elementToBeClickable(paymentInformation));
        actions.click(paymentInformation).pause(Duration.ofMillis(500)).perform();

        WebElement quantity = driver.findElement(By.cssSelector("[class='qty nobr']>span+span"));
        WebElement price = driver.findElement(By.cssSelector("[class='unit-price nobr']>span+span"));
        WebElement total = driver.findElement(By.cssSelector("[class='product-price order-total']>strong"));

        int numQuantity = Integer.parseInt(quantity.getText());
        double numprice = Double.parseDouble(price.getText());
        double totalPrice = Double.parseDouble(total.getText());

        double sum = numQuantity * numprice;
        Assert.assertTrue(sum == totalPrice);

        WebElement confirm = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input"));
        wait.until(ExpectedConditions.elementToBeClickable(confirm));
        actions.click(confirm).pause(Duration.ofMillis(500)).perform();
        MyFunc.Wait(2);
        TearDown();

    }


}