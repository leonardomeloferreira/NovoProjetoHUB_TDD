package br.com.rsinet.hub_tdd.Projeto;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Categoria_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Categoria_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.DriverFactory;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Categoria_TC {

private static WebDriver driver;
	
	@BeforeMethod
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca");
		driver = DriverFactory.inicializaDriver(driver);
		
		Reporter.log("Abrindo o navegador");
		
	}
	
	@Test
	public void iniciaTest() throws Exception {
		DriverFactory.abrirURL(driver);
		Reporter.log("Acessando a loja");
		Categoria_Action.Execute_BuscaHome(driver);
		Reporter.log("Executando a busca do produto pela home");
	
		
	}
	@Test
	public void iniciaTestInvalido() throws Exception {
		DriverFactory.abrirURL(driver);
		Reporter.log("Acessando a loja");
		
		String LaptopHomeInvalido = Home_Page.txt_Notebook_Home(driver).getText();
		Categoria_Action.Execute_BuscaHomeInvalida(driver);
		Reporter.log("Executando a busca do produto pela home");
		
		String LaptopInvalido = Categoria_Page.lnk_LaptopInvalido(driver).getText();
		
		assertEquals(LaptopHomeInvalido.equals(LaptopInvalido), false);
	}
	@AfterMethod
	public static void fechaNavegador() {
		driver = DriverFactory.fecharDriver(driver);
		Reporter.log("Fechando o navegador");
	}
}
