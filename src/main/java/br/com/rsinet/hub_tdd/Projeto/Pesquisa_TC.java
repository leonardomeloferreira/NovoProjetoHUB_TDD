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

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Pesquisa_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Category_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Pesquisa_TC {

	private static ChromeDriver driver;
	
	@BeforeMethod
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca");
		driver = new ChromeDriver();
		Reporter.log("Abrindo o navegador");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void iniciaTest() throws Exception {
		driver.get(Constant.URL);
		Reporter.log("Acessando a loja");
		Pesquisa_Action.Execute_Busca(driver);
		Reporter.log("Executando a busca valida pela lupa");

		assertEquals(true, Category_Page.lnk_Result(driver).getText().contains(ExcelUtils.getCellData(1, 1).toUpperCase()));

	}
	@Test(priority = 1)
	public void iniciaTestInvalido() throws Exception {
		driver.get(Constant.URL);
		Reporter.log("Acessando a loja");
		Pesquisa_Action.Execute_Busca_Invalida(driver);
		Reporter.log("Executando a busca invalida pela lupa");
		String sInvalido = Category_Page.lnk_NoResult(driver).getText();
		
		assertEquals(true, sInvalido.contains("No results for"));
	}	
	@AfterMethod
	public static void fechaNavegador() {
		driver.quit();
		Reporter.log("Fechando o navegador");
	}
}
