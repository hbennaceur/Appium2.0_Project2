package com.Appium2_0_Project.Locators;

import com.Appium2_0_Project.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndInteractsWithApps_locator extends Base {
    public AndInteractsWithApps_locator(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility  = "Views")
    protected static WebElement views ;
}
