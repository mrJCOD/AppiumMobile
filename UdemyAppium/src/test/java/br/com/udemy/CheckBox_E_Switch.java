package br.com.udemy;

import java.net.MalformedURLException;
import java.net.URL;
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

public class CheckBox_E_Switch {

	private AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
		desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

	@Test
	public void ValidandoFormulario() throws InterruptedException {
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("CTAppium");
		el1.click();
		System.out.println("Abriu o APP");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		System.out.println("Clicou no formulario");
		Thread.sleep(2000);

		// Escrevendo nome do console
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Sony PS4");
		String texto = driver.findElement(MobileBy.AccessibilityId("nome")).getText();
		Assert.assertEquals("Sony PS4", texto);
		System.out.println("Validou nome do console");

		// Validando check box e switch
		MobileElement check = (MobileElement) driver.findElementByAccessibilityId("check");
		MobileElement switchh = (MobileElement) driver.findElementByAccessibilityId("switch");
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switchh.getAttribute("checked").equals("true"));
		System.out.println("Validou se os botoes estao como deveriam");
		check.click();
		switchh.click();
		System.out.println("Clicou nos botoes");
		Assert.assertTrue(check.getAttribute("checked").equals("true"));
		Assert.assertTrue(switchh.getAttribute("checked").equals("false"));
		System.out.println("Validou alteracao");

		// Validando Combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		System.out.println("Abriu o Combo");
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		System.out.println("Clicou na opcao PS4");
		String opcaoEscolhida = driver.findElement(By.xpath("//android.widget.TextView[@text='PS4']")).getText();
		Assert.assertEquals("PS4", opcaoEscolhida);
		System.out.println("Validou opcao escolhida\n");
		System.out.println("Teste Finalizado Com sucesso!!");

	}

	@Test
	public void realizandoCadastro() throws InterruptedException {

		//abrindo o app
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("CTAppium");
		el1.click();
		System.out.println("Abriu o APP");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		System.out.println("Clicou no formulario");
		Thread.sleep(2000);

		// Escrevendo nome do console
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Sony PS4");


		// clicando no check box e no switch
		MobileElement check = (MobileElement) driver.findElementByAccessibilityId("check");
		MobileElement switchh = (MobileElement) driver.findElementByAccessibilityId("switch");
		check.click();
		switchh.click();
		System.out.println("Clicou nos botoes");

		// escolhendo console
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		System.out.println("Abriu o Combo");
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		System.out.println("Clicou na opcao PS4");
		
		//clicando em salvar
		driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		System.out.println("Clicou em salvar");
		System.out.println("Teste Finalizado Com sucesso!!");
		
		
		//validando retorno de informacoes
		Thread.sleep(2000);
		
		String nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Sony PS4']")).getText();
			Assert.assertEquals("Nome: Sony PS4", nome);
		String console = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: ps4']")).getText();
			Assert.assertEquals("Console: ps4", console);
		String slider = driver.findElement(By.xpath("//android.widget.TextView[@text='Slider: 25']")).getText();
			Assert.assertEquals("Slider: 25", slider);
		String checkbox = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']")).getText();
			Assert.assertEquals("Switch: Off", checkbox);
		String checkbox2 = driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText();
			Assert.assertEquals("Checkbox: Marcado", checkbox2);
		String data = driver.findElement(By.xpath("//android.widget.TextView[@text='Data: 01/01/2000']")).getText();
			Assert.assertEquals("Data: 01/01/2000", data);
		String hora = driver.findElement(By.xpath("//android.widget.TextView[@text='Hora: 06:00']")).getText();
			Assert.assertEquals("Hora: 06:00", hora);
		

	}

}
