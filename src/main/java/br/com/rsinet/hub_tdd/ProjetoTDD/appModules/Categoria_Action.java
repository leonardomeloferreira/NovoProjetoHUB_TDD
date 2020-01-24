package br.com.rsinet.hub_tdd.ProjetoTDD.appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Categoria_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Screenshots;

public class Categoria_Action {

	public static void Execute_BuscaHome(WebDriver driver) throws Exception {
				
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Home_Page.lnk_Laptops_Home(driver));
		
		
		executor.executeScript("arguments[0].click();", Categoria_Page.lnk_Laptop(driver));
		
		Categoria_Page.img_Notebook(driver);
			
		
		Screenshots.captureScreenShot(driver);
	}
	
		public static void Execute_BuscaHomeInvalida(WebDriver driver) throws InterruptedException {
			
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Home_Page.lnk_Detalhes(driver));
			
			Categoria_Page.img_Notebook(driver);

			Screenshots.captureScreenShot(driver);

		}
}
