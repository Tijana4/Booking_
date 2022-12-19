package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResult extends BasePage{
    By dorucakLista = By.xpath("//div[contains(text(),'Breakfast Included')]");

    By listaHotelaSaDoruckom = By.xpath("//div[text()='Breakfast included']//ancestor::div[@data-testid='property-card']//a//div[@data-testid='title']");

    By cena = By.cssSelector("span[data-testid='price-and-discounted-price']");
    public SearchResult(WebDriver driver) {
        super(driver);
    }


    public void odaberiDorucakIhotel() throws InterruptedException {
        List<WebElement> dorucakL = driver.findElements(dorucakLista);
        dorucakL.get(0).click();
        List<WebElement> zeleniEl = driver.findElements(listaHotelaSaDoruckom);
        WebElement prviHotel = zeleniEl.get(0);
        Thread.sleep(3000);
        prviHotel.click();
    }
    public double nadjiPrvuCenu() {

        List<WebElement>listaCena=getElementList(cena);
        listaCena.get(0);
        String a= listaCena.get(0).getText(); //RSD 313,758
        String[] splitPrvaCena = a.split(" ");
        String prvaFinal = splitPrvaCena[1]; //cena bez rsd
        //int aa=Integer.parseInt(prvaFinal);
      // System.out.println("Vrednost prve cene je: " + prvaFinal);
        double aa = Double.parseDouble(prvaFinal.replace(",", "."));
       // System.out.println("double cena je " + aa);
        double aaa=Math.round(aa);
        //System.out.println("prva cena zaokruzena je " + aaa);
        return aaa;


    }
}
