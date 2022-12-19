package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        Thread.sleep(3000);
        driver= DriverManager.getInstance().setDriver("chrome");
        driver.get("https://www.booking.com/");
    }
}
