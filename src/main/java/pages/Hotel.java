package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Hotel extends BasePage{
    By klasaSkrol = By.cssSelector(".hprt-table-header-cell.hprt-table-header-rooms-number");

    By hotel = By.cssSelector(".fcab3ed991.a23c043802");

    By cena = By.cssSelector("span[data-testid='price-and-discounted-price']");
    By reserveButton = By.cssSelector(".js-reservation-button");

    public Hotel(WebDriver driver) {
        super(driver);
    }

    public void clickSelect() {
        List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        scrollToMyElement(klasaSkrol);
        Select sel = new Select(driver.findElement(By.cssSelector(".hprt-nos-select.js-hprt-nos-select")));
        sel.selectByIndex(1);

        clickOnElement(reserveButton);

    }


}
