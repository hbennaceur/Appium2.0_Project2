package com.Appium2_0_Project.Pages;
import com.Appium2_0_Project.Locators.runApp_locator;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class runAppPage extends runApp_locator {
    private static runAppPage instance;
    public runAppPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static runAppPage getInstance() throws InterruptedException {
        if (instance == null) {
            instance = new runAppPage();
        }
        return instance;}


    public void ScrollToTheViewButton() throws InterruptedException {

        views.click();

        //Swipe

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        textFields.click();
        editText.sendKeys("my text");
        Thread.sleep(3000);
        editText.clear();
    }
    }








