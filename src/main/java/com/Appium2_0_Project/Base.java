package com.Appium2_0_Project;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class Base {
    public static AppiumDriver driver;
    public static Properties props =new Properties();

    public Base(){
        File file;
        try {
            String environment = System.getProperty("env","local");
            if("local".equalsIgnoreCase(environment)){
                file=new File("src/main/java/com/Appium2_0_Project/Properties/local_config.Properties");
            } else if ("prod".equalsIgnoreCase(environment)) {
                file=new File("src/main/java/com/Appium2_0_Project/Properties/prod_config.Properties");

            }else{ throw new RuntimeException("environment n'est pas pris en charger !");}

            FileInputStream fis =new FileInputStream(file);
            props.load(fis);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void InitializeDriver(String platformName) throws Exception {
        DesiredCapabilities des =new DesiredCapabilities();
        des.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        des.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
        URL url = new URL("http://127.0.0.1:4723/");


        switch (platformName) {
            case "Android" -> {
                String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        /*UiAutomator2Options options =new UiAutomator2Options().
                setDeviceName("Pixel_5")
                .setUdid("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setApp(appUrl);*/
                des.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_5");
                des.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                //des.setCapability("isHeadless",true);
                des.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
                des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
                des.setCapability(AndroidMobileCapabilityType.AVD, "Pixel_5");
                des.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 180000);
                des.setCapability(AndroidMobileCapabilityType.UNLOCK_TYPE,"pin");
                // des.setCapability(AndroidMobileCapabilityType.UNLOCK_TYPE,"pattern");
                des.setCapability(AndroidMobileCapabilityType.UNLOCK_KEY,"");
                // des.setCapability(MobileCapabilityType.APP,appUrl);
                //  System.out.println("Session id" + driver.getSessionId());
                // des.setCapability("noWindow", true); // Run in headless mode
                // des.setCapability("disableWindowAnimation", true); // Disable animations for faster execution
                driver=  new AndroidDriver(url, des);
            }
            case "IOS" -> {
                des.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone 11");
                des.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                des.setCapability("bundleId", "com.exemple.apple-samplecode.UICatalog");
                driver =new IOSDriver(url, des);
            }
            default -> throw new Exception("Invalid platform");
        }
    }}
//
