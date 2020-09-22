# Uber-automation
I've attempted to the task of automation registration process with SMS code for Uber app, but at this moment my automation skills are not good enough to succesfully complete the whole process, so I decided to write down some missing steps.

1. Launch 'Uber' App
2. Tap on 'com.ubercab:id/welcome_screen_continue' button
3. (missing) Tap on 'com.ubercab:id/mobile_country_and_dropdown' button to select your country
4. Tap on 'com.ubercab:id/mobile_text_field' to input your mobile number
5. Tap on 'com.ubercab:id/mobile_button_next' to proceed to next screen
6. (missing) Wait for the sms notification from Uber app
7. (missing) Scroll down navigation bar on the top of the screen to get access to recent notifications
8. (missing) Safe to String variable: text of 'android:id/message_text' only if 'android:id/message_name' is comming from Uber
9. (missing) Tap 'back' button to close notification panel
10. (missing) Filter the copied message' body to get 4-digit code out of the redundant text and then split the copied 4-digit code to four parts (i.e. String array with 4 slots)
11. Assign each value from the String array to EditText field
    webDriver.findElement(By.id("com.ubercab:id/otp_input_0")).sendKeys(fourDigitCode[0]);
    webDriver.findElement(By.id("com.ubercab:id/otp_input_1")).sendKeys(fourDigitCode[1]);
    webDriver.findElement(By.id("com.ubercab:id/otp_input_2")).sendKeys(fourDigitCode[2]);
    webDriver.findElement(By.id("com.ubercab:id/otp_input_3")).sendKeys(fourDigitCode[3]);
12. Tap on 'com.ubercab:id/mobile_verification_button_next' button // This button is automatically clicked when user enters the whole 4-digit code
