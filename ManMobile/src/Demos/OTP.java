package Demos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OTP {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
		capability.setCapability("deviceName", "sunil");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET,true);
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("OS").click();
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("SMS Messaging").click();
		driver.findElementById("io.appium.android.apis:id/sms_recipient").sendKeys("7865");
		driver.findElementById("io.appium.android.apis:id/sms_content").sendKeys("Demo OTP:4567");
		driver.hideKeyboard();
		driver.findElementByAccessibilityId("Send").click();
		Thread.sleep(9000);
		driver.activateApp("com.google.android.apps.messaging");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String otpValue=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"You: Demo OTP:4567\")")).getText();
		System.out.println("OTP value is "+otpValue);
		
	}
}