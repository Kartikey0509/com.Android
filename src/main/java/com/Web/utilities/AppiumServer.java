package com.Web.utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServer {
    AppiumDriverLocalService service;

    public AppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingDriverExecutable(new File(System.getenv("NODEJS")));
        serviceBuilder.withAppiumJS(new File(System.getenv("APPIUMJS")));

        service = AppiumDriverLocalService.buildService(serviceBuilder);
    }

    /**
     * Start the Appium server at port 4723
     */
    public void start() {
        service.start();
    }

    /**
     * Stop the running Appium server
     */
    public void stop() {
        service.stop();
    }
}
