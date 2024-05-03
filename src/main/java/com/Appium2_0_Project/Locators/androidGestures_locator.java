package com.Appium2_0_Project.Locators;

import com.Appium2_0_Project.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class androidGestures_locator extends Base {
    public androidGestures_locator(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(accessibility  = "Views")
    protected static WebElement views ;
    @AndroidFindBy(accessibility  = "Drag and Drop")
    protected static WebElement dragAndDrop ;

    @AndroidFindBy(id  = "io.appium.android.apis:id/drag_dot_1")
    protected static WebElement element ;
    @AndroidFindBy(accessibility =  "Gallery")
    protected static WebElement gallery ;
    @AndroidFindBy(accessibility =  "1. Photos")
    protected static WebElement photos ;
    @AndroidFindBy(xpath =  "//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")
    protected static WebElement pic1;
    @AndroidFindBy(id = "android:id/list")
    protected static WebElement listElement ;






}
