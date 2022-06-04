package br.com.udemy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.udemy.core.ConfiguracaoDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioCadastroRefatorado {
	
	private AndroidDriver<MobileElement> driver;

	

	@Before
	public void setUp() throws Exception {
		
		driver = ConfiguracaoDriver.getDriver();
		System.out.println("Iniciou o appium");
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void test() throws InterruptedException {
		
		//abrindo o app
		driver.findElement(MobileBy.AccessibilityId("CTAppium")).click();
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

