package org.mobileAutomaion.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.utils.BaseScreen;

/**
 * Plans Screen class
 *
 * @author je.sarmiento
 */
public class PlansScreen extends BaseScreen {
    /**
     * Class constructor
     *
     * @param driver
     */
    public PlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/actionSheetItemText\").textContains(\"Dining\")")
    AndroidElement diningReserveButton;

    public boolean getDiningReserveButton() {
        return diningReserveButton != null;
    }
}
