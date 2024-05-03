package com.Appium2_0_Project.Pages;

import com.Appium2_0_Project.Locators.AndInteractsWithApps_locator;
import io.appium.java_client.android.AndroidDriver;
;

import java.io.File;


public class AndInteractsWithAppsPage extends AndInteractsWithApps_locator {
    AndroidDriver driver ;
    public  void performInteract() throws Exception {

        views.click();
        Thread.sleep(5000);

        driver.terminateApp("io.appium.android.apis");

        System.out.println(driver.queryAppState("io.appium.android.apis"));
        Thread.sleep(5000);
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        //     driver.runAppInBackground(Duration.ofMillis(5000));
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(5000);
        driver.activateApp("com.android.settings");
        Thread.sleep(5000);
        driver.activateApp("io.appium.android.apis");
        //     System.out.println(driver.isAppInstalled("io.appium.android.apis"));
        // driver.terminateApp("io.appium.android.apis");
        String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        driver.installApp(andAppUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

    }
}
