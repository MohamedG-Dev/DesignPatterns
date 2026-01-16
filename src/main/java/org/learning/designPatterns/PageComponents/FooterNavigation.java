package org.learning.designPatterns.PageComponents;

import org.learning.designPatterns.asbtractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbstractComponents {
    WebDriver driver;
    //traveller-home

    By flights = By.cssSelector( "a[title='Flights']" );
    By footerLinks = By.cssSelector("a");

    public FooterNavigation(WebDriver driver, By footerSectionElement) {
        super(driver, footerSectionElement);
        this.driver = driver;
    }

    public void selectFlight(){
        findElement(flights).click();
    }

    public void getFlightAttributes(){
        String flightAttr = findElement(flights).getAttribute("class");
        System.out.println("Flight Attribute:"+flightAttr);
    }

    public void getLinksCount(){
        System.out.println(findElements(footerLinks).size());
    }
}
