package com.Appium2_0_Project.Pages;

import com.Appium2_0_Project.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class AndLockAndUnlockDevicePage extends Base {
    public  void lockAndUnlock()  throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();


    }
}
