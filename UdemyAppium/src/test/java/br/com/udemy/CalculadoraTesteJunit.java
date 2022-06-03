package br.com.udemy;

import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTesteJunit {
	
	private AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
	    
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void validandoSoma() {
		
		MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el7.click();
	    MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el8.click();
	    MobileElement el10 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el10.click();
	    MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el11.click();
	    MobileElement el12 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el12.click();
	    MobileElement el13 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el13.click();
	    MobileElement el14 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    Assert.assertEquals("9", el14.getText());
	    System.out.println("O resultado apresentado foi: " + el14.getText());
	}

}
