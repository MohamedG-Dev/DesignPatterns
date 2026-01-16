package org.learning.designPatterns.PageObjects;

import org.learning.designPatterns.PageComponents.FooterNavigation;
import org.learning.designPatterns.PageComponents.NavigationBar;
import org.learning.designPatterns.asbtractComponents.SearchFlightAvailability;
import org.learning.designPatterns.asbtractComponents.StrategyFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By footerSectionElement = By.id("traveller-home");
    By navigationSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigation(){
        return new NavigationBar(driver,navigationSectionElement);
    }

    public FooterNavigation getFooterNav(){
        return new FooterNavigation(driver, footerSectionElement);
    }

    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        this.searchFlightAvailability = strategyFactor.createStrategy(strategyType);
       // this.searchFlightAvailability = searchFlightAvailability;
    }

    public void checkFlightAvailability(HashMap<String,String> tripDetails){
        searchFlightAvailability.checkAvailability(tripDetails);
    }

    public String getPageTitle(){
        System.out.println("Retrieving page title");
        return driver.getTitle();
    }
}
