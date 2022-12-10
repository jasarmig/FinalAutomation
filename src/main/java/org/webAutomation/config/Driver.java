package org.webAutomation.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private WebDriver driver;

    public Driver(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void goBack() {
        getDriver().navigate().back();
    }

    public void refresh() { getDriver().navigate().refresh(); }

    public void deleteCookies() { getDriver().manage().deleteAllCookies(); }

    public void goToUrl(String url) { getDriver().get(url); }

    public void maximize() { getDriver().manage().window().maximize(); }

    public void quit() { getDriver().quit(); }

}
