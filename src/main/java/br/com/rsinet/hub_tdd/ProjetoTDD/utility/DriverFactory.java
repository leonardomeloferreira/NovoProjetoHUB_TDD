package br.com.rsinet.hub_tdd.ProjetoTDD.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public static WebDriver driver;


	public static  WebDriver inicializaDriver(WebDriver driver) {
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
	}
	public static void abrirURL(WebDriver driver) {
		if(driver != null)
			driver.get(Constant.URL);
	}

	public static WebDriver fecharDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
		return driver;
		
	}
 }
