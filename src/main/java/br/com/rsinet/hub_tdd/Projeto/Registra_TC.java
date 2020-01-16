package br.com.rsinet.hub_tdd.Projeto;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Registra_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Registra_TC {
	private static ChromeDriver driver;

	@BeforeMethod
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Registro");
		driver = new ChromeDriver();
		Reporter.log("Abrindo o navegador");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void inciaTeste() throws Exception {
		driver.get(Constant.URL);
		Reporter.log("Acessando a loja");
		Registra_Action.Execute(driver);
		Reporter.log("Executando o registro valido na loja");

		assertEquals("https://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());
	}

	@Test
	public void inciaTesteComFalha() throws Exception {
		driver.get(Constant.URL);
		
		Registra_Action.ExecuteFalha(driver);
		Reporter.log("Executando o registro invalido na loja");
		assertEquals("https://www.advantageonlineshopping.com/#/register", driver.getCurrentUrl());
	}

	@AfterMethod
	public static void fechaNavegador() {
		driver.quit();
		Reporter.log("Fechando o navegador");
	}
}
