package br.com.rsinet.hub_tdd.ProjetoTDD.appModules;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Category_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.util.Screenshot;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Pesquisa_Action {

	public static void Execute_Busca(WebDriver driver) throws Exception {
		
		String sBuscaValida = ExcelUtils.getCellData(1, 0);
		
		Home_Page.lnk_MenuSearch(driver).click();
		
		
		Home_Page.txt_Search(driver).sendKeys(sBuscaValida);
		Home_Page.txt_Search(driver).sendKeys(Keys.ENTER);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Category_Page.lnk_Roar(driver));
		
//		WebDriverWait
		
//		Screenshot.captureScreenShot(driver);
		
	}
	
	public static void Execute_Busca_Invalida(WebDriver driver) throws Exception {
		
		String sBuscaInvalida = ExcelUtils.getCellData(2, 0);
		
		Home_Page.lnk_MenuSearch(driver).click();
		
		Home_Page.txt_Search(driver).sendKeys(sBuscaInvalida);
		Home_Page.txt_Search(driver).sendKeys(Keys.ENTER);
		
		Screenshot.captureScreenShot(driver);
	}
}
