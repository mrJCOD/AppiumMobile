package br.com.udemy;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ValidandoCombo {
	
	private AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
	    //desiredCapabilities.setCapability("appium:appPackage", "com.android.calculator2");
	    //desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
	    //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/mauro/eclipse-workspace/Kabum/UdemyAppium/src/test/resources/CTAppium_1_2.apk");
	    
	    
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void validandoOpcaoEscolhida() throws InterruptedException {
		
		
		driver.findElement(MobileBy.AccessibilityId("CTAppium")).click();
		
		Thread.sleep(2000);
		
		List<MobileElement> listaDeElementos = driver.findElements(By.className("android.widget.TextView"));
		listaDeElementos.get(1).click();
		
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);
		
		
		
	}

}
