package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class BookigTest extends BaseTest {
    Booking bookin;
    SearchResult searchResult;
    Hotel hotel;
    YourDetails yourDetails;
    Confirm confirm;


    @BeforeMethod
    public void localSetup() {
        bookin = new Booking(driver);
        searchResult=new SearchResult(driver);
        hotel=new Hotel(driver);
        yourDetails=new YourDetails(driver);
        confirm=new Confirm(driver);
    }


    @Test
    public void Test1() throws InterruptedException {
        bookin.bukiraj();

        //String URL= bookin.getCurrentUrl();

        Assert.assertTrue(bookin.urlCheck());
        //provera da smo na pravoj strani https://www.booking.com/searchresults.html?label=gen173nr-1F


        searchResult.odaberiDorucakIhotel();
        searchResult.nadjiPrvuCenu();
        double cena1=searchResult.nadjiPrvuCenu();
        System.out.println("cena 1 je " + cena1);
        hotel.clickSelect();

        yourDetails.unesiPodatke();

        confirm.nadjiCenu2();
        double cena2=confirm.nadjiCenu2();
        System.out.println("cena 2 je " + cena2);
        Assert.assertEquals(cena1, cena2);


       // Assert.assertTrue(confirm.nadjiCenu2().contains(searchResult.nadjiPrvuCenu()));
    }

    @Test
    public void Test2() throws InterruptedException {
        bookin.bukiraj();
        searchResult.odaberiDorucakIhotel();
        searchResult.nadjiPrvuCenu();

        //Assert.assertTrue(searchResult.nadjiPrvuCenu().contains("313"));

    }

}
