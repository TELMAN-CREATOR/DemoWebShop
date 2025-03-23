package Utilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
   static WebDriver driver;

    static {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void TearDown() throws InterruptedException {
        MyFunc.Wait(2);
        driver.quit();
    }

}
