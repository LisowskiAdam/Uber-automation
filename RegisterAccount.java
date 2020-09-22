package com.example.uber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class RegisterAccount {
    WebDriver webDriver;

    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AOSP on IA Emulator");
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
        capabilities.setCapability(CapabilityType.VERSION, "9");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "C:\\Users\\Lenovo\\AndroidStudioProjects\\Uber\\app\\apk\\uber.apk");
        capabilities.setCapability("automationName", "UIAutomator2");

        webDriver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    public void registerAccount() throws InterruptedException, NumberFormatException {
        Thread.sleep(3000);
        webDriver.findElement(By.id("com.ubercab:id/welcome_screen_continue")).click();
        webDriver.findElement(By.id("com.ubercab:id/mobile_text_field")).sendKeys("555-521-5554");
        webDriver.findElement(By.id("com.ubercab:id/mobile_button_next")).click();
        Thread.sleep(3000);

        /*
        Wait for the sms notification from 'Uber' app
        Scroll down navigation bar on the top of the screen to get access to recent notifications
        Safe to String variable: text of 'android:id/message_text', but only if 'android:id/message_name' is coming from 'Uber' app
        Tap 'android back' button to close notification panel
        Filter the copied message body to get 4-digit code out of the redundant text and then split the copied 4-digit code to four parts (i.e. String array with 4 slots)*/

        String[] fourDigitCode = {"1", "2", "3", "4"};
        webDriver.findElement(By.id("com.ubercab:id/otp_input_0")).sendKeys(fourDigitCode[0]);
        webDriver.findElement(By.id("com.ubercab:id/otp_input_1")).sendKeys(fourDigitCode[1]);
        webDriver.findElement(By.id("com.ubercab:id/otp_input_2")).sendKeys(fourDigitCode[2]);
        webDriver.findElement(By.id("com.ubercab:id/otp_input_3")).sendKeys(fourDigitCode[3]);

        //webDriver.findElement(By.id("com.ubercab:id/mobile_verification_button_next")).click(); // This button is automatically clicked when user enters the whole 4-digit code
        Thread.sleep(5000);
    }

    @AfterTest
    public void End() {
        webDriver.quit();
    }
}
