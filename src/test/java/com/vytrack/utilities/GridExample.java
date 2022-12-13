package com.vytrack.utilities;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridExample {

    public static void main(String[] args) throws MalformedURLException {

        //1.hub must be up running
        //2. Grid must be registered
        //3. Chrome path must be done correctly


        //create url for hub
        URL url = new URL ("http://localhost:4445/wd/hub");

        //create options class
        ChromeOptions chromeOptions = new ChromeOptions();


        //RemoteWebDriver is used to open browser remotely using grid
        WebDriver driver = new RemoteWebDriver(url,chromeOptions);



        /*
        // Create URL for the hub
        URL url = new URL("http://localhost:4444/wd/hub");
        // create options
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        //desiredCapabilities.setVersion("67");

        desiredCapabilities.setPlatform(Platform.WIN8_1); //we can say ANY instead of WIN8_1 as well
        WebDriver driver = new RemoteWebDriver(url, desiredCapabilities);
        // RemoteWebDriver--> used to open browser remotely using grid
        driver.get("https://selenium.dev");
        System.out.println(driver.getTitle());
        BrowserUtils.waitFor(3);
        driver.quit();

         */


    }
}
