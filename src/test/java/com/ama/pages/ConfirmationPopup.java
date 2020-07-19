package com.ama.pages;

import com.ama.reporting.ExtentTestManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ConfirmationPopup extends BasePage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private WebElement oneTime;

    public ConfirmationPopup(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    /**
     * Selects one time
     */
    public void useOneTime() {

        clickAnElement(oneTime);
        ExtentTestManager.reportInfo("Click use one time");
    }
}
