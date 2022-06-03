package br.com.udemy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

  private AndroidDriver<MobileElement> driver;

  @Before
  public void setUp() throws MalformedURLException {
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

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() {
    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
    el1.click();
    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
    el3.click();
    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("equals");
    el4.click();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
