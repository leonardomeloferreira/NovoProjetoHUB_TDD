package br.com.rsinet.hub_tdd.Projeto;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Pesquisa_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Categoria_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.DriverFactory;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Pesquisa_TC {

	private static WebDriver driver;
	
	@BeforeMethod
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca");
		driver = DriverFactory.inicializaDriver(driver);
		Reporter.log("Abrindo o navegador");
		
	}
	
	@Test(priority = 0)
	public void iniciaTest() throws Exception {
		DriverFactory.abrirURL(driver);
		Reporter.log("Acessando a loja");
		Pesquisa_Action.Execute_Busca(driver);
		Reporter.log("Executando a busca valida pela lupa");

		assertEquals(true, Categoria_Page.lnk_Result(driver).getText().contains(ExcelUtils.getCellData(1, 1).toUpperCase()));

	}
	@Test(priority = 1)
	public void iniciaTestInvalido() throws Exception {
		DriverFactory.abrirURL(driver);
		Reporter.log("Acessando a loja");
		Pesquisa_Action.Execute_Busca_Invalida(driver);
		Reporter.log("Executando a busca invalida pela lupa");
		String sInvalido = Categoria_Page.lnk_NoResult(driver).getText();
		
		assertEquals(true, sInvalido.contains("No results for"));
	}	
	@AfterMethod
	public static void fechaNavegador() {
		driver = DriverFactory.fecharDriver(driver);
		Reporter.log("Fechando o navegador");
	}
}
