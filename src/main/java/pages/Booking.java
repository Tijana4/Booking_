package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Booking extends BasePage {

    By gde_idete = By.cssSelector("#ss");
    By data_picker = By.cssSelector("div[data-mode='checkin']");
    By datum1 = By.cssSelector("td[data-date='2022-12-26']");
    By datum2 = By.cssSelector("td[data-date='2023-01-03']");
    By searchButton = By.cssSelector(".sb-searchbox__button");




    public Booking(WebDriver driver) {
        super(driver);
    }

    public void bukiraj()
    {
        typeIn(gde_idete, "Zlatibor");
        getElement(data_picker).click();
        clickOnElement(datum1);
        clickOnElement(datum2);
        clickOnElement(searchButton);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean urlCheck()
    {
        if (getCurrentUrl().contains("https://www.booking.com/searchresults"))
        {
            System.out.println("URL JE " + getCurrentUrl());
            return true;

        }
        else {
            System.out.println("fail");
        }
        return false;
    }
}
