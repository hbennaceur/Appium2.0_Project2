package com.Appium2_0_Project;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
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
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        des.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        URL url = new URL("http://127.0.0.1:4723/");

        switch (platformName) {
            case "Android" -> {
                String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                des.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                des.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                des.setCapability("appPackage", "io.appium.android.apis");
                des.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                des.setCapability("avd", "emulator-5554");
                des.setCapability("avdLaunchTimeout", 180000);
                des.setCapability("unlockType", "pin");
                des.setCapability("unlockKey", "");
                des.setCapability("noWindow", true); // Run in headless mode
                des.setCapability("disableWindowAnimation", true); // Disable animations for faster execution

                driver = new AndroidDriver(url, des);
            }
            case "IOS" -> {
                des.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
                des.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                des.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                des.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                driver = new IOSDriver(url, des);
            }
            default -> throw new Exception("Invalid platform");
        }
    }
    }

