package org.learning.designPatterns.PageComponents;

import org.learning.designPatterns.asbtractComponents.AbstractComponents;
import org.learning.designPatterns.asbtractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponents implements SearchFlightAvailability {
    private By rdoRoundTrip = By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']");
    private By txtFrom = By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private By chkboxIndianArmedForces = By.id("ctl00_mainContent_chk_IndArm");
    private By searchBtn = By.id("ctl00_mainContent_btn_FindFlights");
    private By txtTo = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");

    public RoundTrip(WebDriver driver, By footerSectionElement) {
        super(driver, footerSectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String,String> tripDetails) {
        makeStateReady(s->selectOriginCity(tripDetails.get("origin")));;
        selectDestinationCity(tripDetails.get("destination"));
        findElement(chkboxIndianArmedForces).click();
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

    public void makeStateReady(Consumer<RoundTrip> consumer){
        System.out.println("I am inside round trip");
        findElement(rdoRoundTrip).click();
        consumer.accept(this);
    }
}
