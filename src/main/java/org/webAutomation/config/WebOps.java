package org.webAutomation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOps {

    private final WebDriverWait wait;
    private final Actions action;

    public WebOps(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public void clickElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    public void typeOfInput(WebElement element, String text){
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void placeMouseOn(WebElement element){
        waitForVisibility(element);
        waitForClickable(element);
        action.moveToElement(element).perform();
    }
}
