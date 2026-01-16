package org.learning.designPatterns.asbtractComponents;

import org.learning.designPatterns.PageComponents.MultiTrip;
import org.learning.designPatterns.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {
    private WebDriver driver;
    private By headerSectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver=driver;
    }

    public SearchFlightAvailability createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("multitrip")) {
            return new MultiTrip(driver, headerSectionElement);
        } else if (strategyType.equalsIgnoreCase("roundtrip")) {
            return new RoundTrip(driver, headerSectionElement);
        }
        return null;
    }
}
