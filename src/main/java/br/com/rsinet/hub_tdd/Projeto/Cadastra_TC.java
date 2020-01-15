package br.com.rsinet.hub_tdd.Projeto;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Register_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Cadastra_TC {
	private static ChromeDriver driver;

	@BeforeClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Registro");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void inciaTeste() throws Exception {
		driver.get("https://www.advantageonlineshopping.com/");

		Register_Action.Execute(driver);

		assertEquals("https://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());
	}

	@Test
	public void inciaTesteComFalha() throws Exception {
		driver.get("https://www.advantageonlineshopping.com/");

		Register_Action.ExecuteFalha(driver);

		assertEquals("https://www.advantageonlineshopping.com/#/register", driver.getCurrentUrl());
	}

	@AfterClass
	public static void fechaNavegador() {
		driver.quit();
	}
}
