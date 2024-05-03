package com.Appium2_0_Project.Locators;

import com.Appium2_0_Project.Base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class runApp_locator extends Base {
    public runApp_locator(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility  = "Views")
    protected static WebElement views ;
    @AndroidFindBy(accessibility = "TextFields")
    protected static WebElement textFields ;
    @AndroidFindBy(id = "io.appium.android.apis:id/edit")
    protected static WebElement editText ;
    @AndroidFindBy(id = "android:id/list")
    protected static WebElement element ;


}
