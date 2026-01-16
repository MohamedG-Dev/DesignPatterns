package org.learning.designPatterns;

import org.learning.designPatterns.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FlightDemoTest extends BaseTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(dataProvider = "tripDetails")
    public void flightTest(HashMap<String, String> bookingDetails) throws InterruptedException {

        //SRP Pattern Implementation
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        travelHomePage.getFooterNav().getFlightAttributes();
        travelHomePage.getNavigation().getFlightAttributes();
        travelHomePage.getFooterNav().getLinksCount();
        travelHomePage.getNavigation().getLinksCount();
        travelHomePage.getPageTitle();

        //Strategy Pattern Implementation
        //check availability
        //travelHomePage.setBookingStrategy(new RoundTrip(driver,headerSectionElement));
        //travelHomePage.setBookingStrategy(new MultiTrip(driver,headerSectionElement));

        //factory based strategy implementation
        travelHomePage.setBookingStrategy("multitrip");

        travelHomePage.checkFlightAvailability(bookingDetails);
    }

//    @DataProvider(name = "tripDetails")
//    public Object[][] getData() {
//        //HashMap implementation
//        List<HashMap<String,String>> data = getJsonData("data/tripDetails.json");
////        return new Object[][]{
////                {data.get(0)},
////                {data.get(1)}
////        };
//        //Create an Object[][] with the same size as the data list
//        Object[][] dataArray = new Object[data.size()][1];
//        for(int i=0;i<data.size();i++){
//            dataArray[i][0]=data.get(i);
//        }
//        return dataArray;
//    }

    @DataProvider(name="tripDetails")
    public Iterator<Object[]> getData(){
        List<HashMap<String,String>> data = getJsonData("data/tripDetails.json");
        return data.stream().map( e -> new Object[]{e}).iterator();
    }
}
