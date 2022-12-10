package org.mobileAutomaion.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.utils.BaseScreen;

/**
 * Menu Screen class
 *
 * @author je.sarmiento
 */
public class MenuScreen extends BaseScreen {

    /**
     * Class constructor
     * @param driver
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textContains(\"Privacy\")")
    private AndroidElement privacyButton;

    private final AndroidElement scrollableMenu =
            driver.findElement(new MobileBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));

    /**
     * Method to navigate to Privacy Screen
     *
     * @return PrivacyScreen
     */
    public PrivacyScreen goToPrivacyScreen() {
        if(getScrollableMenu()){
            click(privacyButton);
            return new PrivacyScreen(driver);
        }
        return null;
    }

    /**
     * Method to validate if the scrollable element is present
     *
     * @return boolean
     */
    public boolean getScrollableMenu() {
        return scrollableMenu != null ;
    }
}

