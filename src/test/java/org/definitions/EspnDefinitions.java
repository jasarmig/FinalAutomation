package org.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.webAutomation.config.Driver;
import org.webAutomation.pages.Homepage;
import org.webAutomation.pages.Watch;
import org.reporting.Reporter;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;
import static org.hamcrest.Matchers.*;

public class EspnDefinitions {

    protected Driver driver;
    protected Homepage homepage;
    protected Watch watch;
    private final String browser = "chrome";

    @Before()
    public void setUp() {
        driver = new Driver(browser);
        driver.deleteCookies();
        driver.maximize();
    }

    @After()
    public void closeBrowser(){
        driver.quit();
    }

    @Given("user is on {string}")
    public void goHome(String url) {
        driver.goToUrl(url);
        homepage = new Homepage(driver.getDriver());
    }

    @When("user clicks on login button")
    public void openLoginFrame() {
        homepage.clickElement(homepage.getLoginButton());
    }

    @Then("the login iframe opens")
    public void validateLoginFrame() {
        homepage.switchToFrame(driver);
        checkThat("Login modal is present", homepage.loginFrameIsVisible(), is(true));
    }

    @When("user clicks on sign up button")
    public void clickOnSignUp() {
        homepage.clickElement(homepage.getCreateBtn());
        homepage.switchToHome(driver);
    }

    @Then("a new frame is displayed")
    public void validateSignUpFrame() {
        homepage.switchToFrame(driver);
        checkThat("Sign Up modal is present", homepage.signupFrameIsVisible(), is(true));
    }

    @When("user enters the new account information: {string} and {string} and {string} and {string}")
    public void userEntersTheNewAccountInformation(String name, String lastName, String email, String pass) {
        homepage.fillSignUpForm(name, lastName, email, pass);
        homepage.switchToHome(driver);
    }
    @When("clicks on sign up")
    public void clickOnSubmitSignUp() {
        homepage.switchToFrame(driver);
        homepage.clickElement(homepage.getSubmit());
    }

    @Then("user is logged in")
    public void validateUserLogin() {
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForVisibility(homepage.getLogoutBtn());
        checkThat("user is logged in",
                homepage.isLogoutButtonDisplayed(),
                is(true));
    }

    @When ("user clicks on Watch button")
    public void clickOnWatchBtn() {
        watch = homepage.goToWatch(driver);
    }

    @Then ("the watch page is opened")
    public void validateWatchPageIsDisplayed() {
        checkThat("carousel is displayed and tiles have titles and descriptions",
                watch.isWatchPageDisplayed(),
                is(true));
    }

    @When ("user clicks on the second element of the first carousel")
    public void clickOnCarousel() {
        watch.clickElement(watch.getSecondElement());
        watch.waitForClickable(watch.getClosePopupBtn());
    }

    @Then ("a lightbox is displayed and has a close button")
    public void validateLightboxIsDisplayed() {
        checkThat("lightbox is displayed", watch.isLightboxDisplayed(), is(true));
    }

    @When ("user closes the lightbox")
    public void closeLightBox() { watch.clickElement(watch.getClosePopupBtn()); }

    @Then ("user goes back to homepage")
    public void validateHomepageIsDisplayed() {
        driver.goBack();
        checkThat("user is logged in",
                homepage.isLogoutButtonDisplayed(),
                is(true));
    }

    @Then ("his name: {string} is displayed")
    public void  validateUserNameIsDisplayed(String name) {
        homepage.waitForClickable(homepage.getUserMenu());
        homepage.placeMouseOn(homepage.getUserMenu());
        homepage.waitForClickable(homepage.getLogoutBtn());
        checkThat("Username is present in menu", homepage.getUserNameText(), is("Welcome" + name + "!"));
    }

    @When ("user clicks on log out button")
    public void  userLogout() {
        homepage.clickElement(homepage.getLogoutBtn());
    }

    @Then ("user is logged out")
    public void  validateUserIsLoggedOut() {
        homepage.placeMouseOn(homepage.getUserMenu());
        checkThat("Username is not present in menu", homepage.getUserNameText(), is("Welcome!"));
    }

    @Given("user logs in with email {string} and password {string}")
    public void userLogsIn(String email, String pass) {
        homepage.waitForClickable(homepage.getLoginButton());
        homepage.clickElement(homepage.getLoginButton());
        homepage.switchToFrame(driver);
        homepage.waitForClickable(homepage.getSubmit());
        homepage.setLoginInfo(email, pass);
        homepage.clickElement(homepage.getSubmit());
    }
    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        Reporter.info(format("Checking that " + description.toLowerCase() + " [Expected: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue,expectedValue);
        } catch (AssertionError e) {
            Reporter.error(format("Assertion error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }

}
