package org.mobileAutomaion.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.utils.BaseScreen;


/**
 * Dashboard Screen class
 *
 * @author je.sarmiento
 */
public class DashboardScreen extends BaseScreen {

    /**
     * Class constructor
     *
     */
    public DashboardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_icon\").instance(1)")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_icon\").instance(3)")
    private AndroidElement menuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_animated_icon\")")
    private AndroidElement addPlansButton;

    /**
     * Method to navigate to Map screen from Dashboard
     *
     * @return MapScreen
     */
    public MapScreen goToMapScreen() {
        click(mapButton);
        return new MapScreen(driver);
    }

    /**
     * Method to navigate to Menu screen from Dashboard
     *
     * @return MenuScreen
     */
    public MenuScreen goToMenuScreen() {
        click(menuButton);
        return new MenuScreen(driver);
    }

    /**
     * Method to navigate to Plans screen from Dashboard
     *
     * @return PlansScreen
     */
    public PlansScreen goToPlansScreen() {
        click(addPlansButton);
        return new PlansScreen(driver);
    }
}
