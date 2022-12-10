package org.mobileAutomaion.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Privacy Screen class
 *
 * @author je.sarmiento
 */
public class PrivacyScreen extends MenuScreen{

    /**
     * Class constructor
     *
     * @param driver
     */
    public PrivacyScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "resourceId(\"com.disney.wdpro.dlr:id/txt_element\").text(\"Privacy Policy\")")
    AndroidElement privacyPolicyBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textContains(\"Use\")")
    AndroidElement termsOfUseBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textContains(\"Supplemental\")")
    AndroidElement supplementalTermsBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textContains(\"Legal\")")
    AndroidElement legalNoticesBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textContains(\"Property\")")
    AndroidElement propertyRulesBtn;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.disney.wdpro.dlr:id/txt_element\").textContains(\"Electronic\")")
    AndroidElement electronicCommunicationsBtn;

    /**
     * Method to validate if given options are present
     *
     * @return boolean
     */
    public boolean optionsExist() {
        return isElementAvailable(privacyPolicyBtn) && isElementAvailable(termsOfUseBtn) && isElementAvailable(supplementalTermsBtn)
                && isElementAvailable(legalNoticesBtn) && isElementAvailable(propertyRulesBtn) && isElementAvailable(electronicCommunicationsBtn);
    }
}
