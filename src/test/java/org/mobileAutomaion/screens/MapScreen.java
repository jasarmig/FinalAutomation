package org.mobileAutomaion.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.utils.BaseScreen;

/**
 * Map Screen class
 *
 * @author je.sarmiento
 */
public class MapScreen extends BaseScreen {

    /**
     * Class constructor
     *
     * @param driver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/categoryTitleLayout\")")
    private AndroidElement categoryButton;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/facilityTypeTitle\").text(\"Hotels\")")
    private AndroidElement hotelsText;

    /**
     * Getter method for Category Button
     *
     * @return AndroidElement
     */
    public AndroidElement getCategoryButton() {
        return categoryButton;
    }

    /**
     * Method to check if an element is available
     *
     * @return boolean
     */
    public boolean hotelsCategoryAvailable() {
        return isElementAvailable(hotelsText);
    }
}

