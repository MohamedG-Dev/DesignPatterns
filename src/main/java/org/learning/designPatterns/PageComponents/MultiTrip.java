package org.learning.designPatterns.PageComponents;

import org.learning.designPatterns.asbtractComponents.AbstractComponents;
import org.learning.designPatterns.asbtractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponents implements SearchFlightAvailability {
    private By modelPopup = By.id("MultiCityModelAlert");
    private By rdoMultiTrip = By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_2']");
    private By txtFrom = By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");
    private By txtTo = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    private By txtDestination2To = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation2_CTXT']");

    public MultiTrip(WebDriver driver, By footerSectionElement) {
        super(driver, footerSectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String,String> tripDetails) {
        makeStateReady(s ->selectOriginCity(tripDetails.get("origin")));
        selectDestinationCity(tripDetails.get("destination"));
        selectDestinationCity2(tripDetails.get("origin2"));
        findElement(searchBtn).click();
    }

    public void selectOriginCity(String originCity){
        findElement(txtFrom).click();
        findElement(By.xpath("//a[@value='"+originCity+"']")).click();
    }

    public void selectDestinationCity(String destinationCity){
        findElement(txtTo).click();
        findElement(By.xpath("(//a[@value='"+destinationCity+"'])[2]")).click();
    }
    public void selectDestinationCity2(String destinationCity){
        findElement(txtDestination2To).click();
        findElement(By.xpath("(//a[@value='"+destinationCity+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        //common prerequisites code
        //execute actual function
        //tear down code
        System.out.println("i am inside multi trip");
        findElement(rdoMultiTrip).click();
        findElement(modelPopup).click();
        waitForElementToDisappear(modelPopup);
        consumer.accept(this);
    }
}
