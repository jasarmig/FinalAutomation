package org.definitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mobileAutomaion.screens.DashboardScreen;
import org.mobileAutomaion.screens.MapScreen;
import org.mobileAutomaion.screens.MenuScreen;
import org.mobileAutomaion.screens.PrivacyScreen;
import org.mobileAutomation.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.reporting.Reporter;
import org.testng.Assert;
import org.utils.BaseScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class DisneyDefinitions {

    public static AndroidDriver<AndroidElement> driver;
    protected BaseScreen baseScreen;
    protected DashboardScreen dashboard;
    protected MapScreen maps;
    protected MenuScreen menu;
    protected PrivacyScreen privacy;

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * Method to setup environment before each test
     *
     * @author Arley.Bolivar
     */
    @Before()
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetup(capabilities);
        ConfigCapabilities.applicationSetup(capabilities);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Method to close the app after each test
     *
     * @author Arley.Bolivar
     */
    @After()
    public void mobileApplicationEnd() {
        Reporter.info("Test Concluded");
        driver.quit();
    }


    /**
     * Method to navigate to Dashboard during environment setup
     *
     * @return DashboardScreen
     * @author je.sarmiento
     */
    @Given("user is in the dashboard")
    public void setUpStartApp() {
        baseScreen = new BaseScreen(getDriver());
        baseScreen.goToDashboard();
    }

    @Then("map button is available")
    public void validateMapButtonIsAvailable(){
        Assert.assertTrue(maps.isElementAvailable(maps.getCategoryButton()),"Category Button Not Avaliable");
    }

    @When("user taps on map option")
    public void tapOnMapsButton(){
        maps.click(maps.getCategoryButton());
    }

    @Then("map view is shown")
    public void validateMapIsShown(){
        Assert.assertTrue(maps.isElementAvailable(maps.getCategoryButton()),"Category Button Not Avaliable");
    }

    @When("user taps on category list")
    public void tapOnCategoryList(){
        maps.click(maps.getCategoryButton());
    }

    @When("categories are listed and hotel option is available")
    public void validateCategoriesAreListed(){
        Assert.assertTrue(maps.hotelsCategoryAvailable(),"Category Not Available");
    }

    @When("user taps on menu button")
    public void tapOnMenuButton(){
        dashboard.goToMenuScreen();
    }

    @Then("a menu is displayed and different categories are displayed")
    public void validateMenuIsDisplayed(){
        menu.goToPrivacyScreen();
        Assert.assertTrue(privacy.optionsExist(),"Options don't match");
    }

    @When("user taps on Privacy and Legal")
    public void tapOnPrivacy{
        menu.goToPrivacyScreen();
    }


}
