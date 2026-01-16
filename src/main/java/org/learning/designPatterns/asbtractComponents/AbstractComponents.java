package org.learning.designPatterns.asbtractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractComponents {
    WebDriver driver;
    private WebElement sectionElement;

    public AbstractComponents(WebDriver driver, By footerSectionElement) {
        this.sectionElement = driver.findElement(footerSectionElement);
        this.driver = driver;
    }

    public WebElement findElement(By findElementBy) {
        return sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementsBy) {
        return sectionElement.findElements(findElementsBy);
    }

    public void waitForElementToDisappear(By findElementBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findElementBy));
    }
}
