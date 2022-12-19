package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Booking;
import pages.SearchResult;

public class SearchResultTest extends BaseTest{
    Booking bookin;
    SearchResult searchResult;

    @BeforeMethod
    public void localSetup() {
        bookin = new Booking(driver);
        //searchResult=new SearchResult(driver);

    }


    @Test
    public void Test2()
    {

    }
}
