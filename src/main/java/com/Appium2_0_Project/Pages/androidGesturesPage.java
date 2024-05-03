package com.Appium2_0_Project.Pages;

import com.Appium2_0_Project.Locators.androidGestures_locator;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class androidGesturesPage extends androidGestures_locator {
    public static androidGesturesPage instance;
    public androidGesturesPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static androidGesturesPage getInstance(){
        if(instance == null){
            instance= new androidGesturesPage();
        }return instance;

    }

    public void performLongClick()  {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "x",217,
                "y",659
                ,"duration",1000
        ));
    }

    public void performDragAndDrop(){
        views.click();
        dragAndDrop.click();
         driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662
        ));
    }


    public void performZoomInAndZoomOu(){
        //ZOOMIN
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,
                "height",600,
                "percent", 0.75
        ));
    }

    public void performSwipe(){
        views.click();
        gallery.click();
        photos.click();
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 600,
                "elementId",((RemoteWebElement)pic1).getId(),
                "direction", "left",
                "percent", 0.75
        ));

    }

    public void scrollToTheElement(){
        views.click();
        boolean canScrollMore=true;
        while (canScrollMore){

         canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
               // "left", 100, "top", 100, "width", 600, "height", 600,
                "elementId",((RemoteWebElement)listElement).getId(),
                "direction", "down",
                "percent", 1.0
        ));}
    }
}
