package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourDetails extends BasePage{
    By firstname = By.id("firstname");
    By lastname = By.id("lastname");

    By email = By.id("email");
    By email_confirm = By.id("email_confirm");

    By nextButton = By.cssSelector(".bui-button__text.js-button__text");

    public YourDetails(WebDriver driver) {
        super(driver);
    }

    public void unesiPodatke() {
        typeIn(firstname, "Test");
        typeIn(lastname, "Tester");
        String mejl = randomMejl();
        typeIn(email, mejl);
        typeIn(email_confirm, mejl);
        clickOnElement(nextButton);

       // System.out.println(getElement(cena2).getText().substring(4).split(" "));
    }
}
