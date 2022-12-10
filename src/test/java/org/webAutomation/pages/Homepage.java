package org.webAutomation.pages;

import org.webAutomation.config.Driver;
import org.webAutomation.config.WebOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends WebOps {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "user")
    private WebElement userMenu;

    @FindBy(css = "#sideLogin-left-rail .button-alt")
    private WebElement loginButton;

    @FindBy(className = "watch")
    private WebElement watchButton;

    @FindBy(id = "oneid-iframe")
    private WebElement iFrame;

    @FindBy(linkText = "Log Out")
    private WebElement logoutBtn;

    @FindBy(className = "display-user")
    private WebElement userName;

    @FindBy(id = "InputFirstName")
    private WebElement firstName;

    @FindBy(id = "InputLastName")
    private WebElement lastName;

    @FindBy(id = "InputEmail")
    private WebElement emailAddress;

    @FindBy(id = "password-new")
    private WebElement userPass;

    @FindBy(id = "BtnSubmit")
    private WebElement submit;

    @FindBy(id = "close")
    private WebElement closeBtn;

    @FindBy(id = "BtnCreateAccount")
    private WebElement createBtn;

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(className = "input-InputLoginValue")
    private WebElement loginEmailInput;

    @FindBy(className = "input-InputPassword")
    private WebElement loginPasswordInput;

    public WebElement getLoginEmailInput() {
        return loginEmailInput;
    }

    public WebElement getLoginPasswordInput() {
        return loginPasswordInput;
    }

    public WebElement getUserMenu() {
        return userMenu;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWatchButton() { return watchButton; }

    public WebElement getiFrame() { return iFrame; }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public Watch goToWatch(Driver driver) {
        clickElement(getWatchButton());
        return new Watch(driver.getDriver());
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserPass() {
        return userPass;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getCreateBtn() {
        return createBtn;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getCloseBtn() {
        return closeBtn;
    }

    public boolean logoIsDisplayed() {
        return getLogo().isDisplayed();
    }

    public boolean loginBtnIsDisplayed() {
        return getSubmit().isDisplayed();
    }

    public boolean signUpBtnIsDisplayed() {
        return getCreateBtn().isDisplayed();
    }

    public boolean firstNameFieldDisplayed() {
        return getFirstName().isDisplayed();
    }

    public boolean lastNameFieldDisplayed() {
        return getLastName().isDisplayed();
    }

    public boolean emailAddressFieldDisplayed() {
        return getEmailAddress().isDisplayed();
    }

    public boolean closeBtnDisplayed() {
        return getCloseBtn().isDisplayed();
    }

    public boolean loginFrameIsVisible() {
        waitForVisibility(getLogo());
        waitForVisibility(getSubmit());
        waitForVisibility(getCreateBtn());
        return logoIsDisplayed() && loginBtnIsDisplayed() && signUpBtnIsDisplayed();
    }

    public boolean signupFrameIsVisible() {
        waitForVisibility(getFirstName());
        waitForVisibility(getLastName());
        waitForVisibility(getEmailAddress());
        waitForVisibility(getCloseBtn());
        return firstNameFieldDisplayed() && lastNameFieldDisplayed() && emailAddressFieldDisplayed()
                && closeBtnDisplayed();
    }

    public void switchToFrame(Driver driver) {
        driver.getDriver().switchTo().frame(getiFrame());
    }

    public void switchToHome(Driver driver) {driver.getDriver().switchTo().defaultContent();}

    public void fillSignUpForm(String name, String lastName, String email, String pass) {
        typeOfInput(getFirstName(),name);
        typeOfInput(getLastName(), lastName);
        typeOfInput(getEmailAddress(), email);
        typeOfInput(getUserPass(), pass);
    }

    public String getUserNameText() {
        return getUserName().getText();
    }

    public boolean isLogoutButtonDisplayed() {
        waitForClickable(getUserMenu());
        placeMouseOn(getUserMenu());
        waitForClickable(getLogoutBtn());
        return getLogoutBtn().isDisplayed();
    }

    public void setLoginInfo(String email, String pass) {
        typeOfInput(getLoginEmailInput(),email);
        typeOfInput(getLoginPasswordInput(),pass);
    }
}