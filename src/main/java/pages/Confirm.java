package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Confirm extends BasePage{

    By cena2 = By.className("e2e-price-details__total-charge--user");

    public Confirm(WebDriver driver) {
        super(driver);
    }

    /*private WebElement getCena2(){
        return driver.findElement(cena2);
    }*/
    public double nadjiCenu2()
    {
        //String vrednostAtributa = getElement(cena2).getAttribute("data-price");

        String b = getElement(cena2).getText(); //RSD 313,757.97 *
        String[] splitDrugaCena = b.split(" ");

        String drugaF = splitDrugaCena[1]; //cena bez rsd i *
        //int bb=Integer.parseInt(drugaF);
       // System.out.println("Vrednost druge cene je: " + drugaF); //289,069.97

        String []splitDrugi=drugaF.split("[.]");
        String skoroKonacna=splitDrugi[0];
        //System.out.println(skoroKonacna); //313,757
        double bb = Double.parseDouble(skoroKonacna.replace(",", "."));
        //System.out.println("double cena je " + bb);
        double bbb=Math.round(bb);
       // System.out.println("druga cena zaokruzena je " + bbb);
            return bbb;
        //double bb = Double.parseDouble(drugaF.replace(",", "."));
        //

       // double doubleVrednostCena2 = Double.parseDouble(vrednostAtributa);
        //System.out.println("Double vrednost cene: " + doubleVrednostCena2);
    }
}
