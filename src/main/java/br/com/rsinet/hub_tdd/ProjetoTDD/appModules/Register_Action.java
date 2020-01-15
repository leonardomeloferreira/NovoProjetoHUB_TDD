package br.com.rsinet.hub_tdd.ProjetoTDD.appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.LogIn_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Register_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Register_Action {

	public static void Execute(WebDriver driver) throws Exception {

		Home_Page.lnk_MyAccount(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.btn_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));
	
		String sUserName = ExcelUtils.getCellData(1, 1);
		String sEmail = ExcelUtils.getCellData(1, 2);
		String sPassword = ExcelUtils.getCellData(1, 3);
		String sComfirmPassword = ExcelUtils.getCellData(1, 4);
		String sFirstname = ExcelUtils.getCellData(1, 5);
		String sLastname = ExcelUtils.getCellData(1, 6);
		String sPhoneNumber = ExcelUtils.getCellData(1, 7);
		String ssCity = ExcelUtils.getCellData(1, 8);
		String sCity = ExcelUtils.getCellData(1, 9);
		String sAddress = ExcelUtils.getCellData(1, 10);
		String sState = ExcelUtils.getCellData(1, 11);
		String sPostalCode = ExcelUtils.getCellData(1, 12);
		String sLogin = ExcelUtils.getCellData(1, 13);
				
		
		
		Register_Page.txtbx_UserName(driver).sendKeys(sUserName);
		Register_Page.txtbx_Email(driver).sendKeys(sEmail);
		Register_Page.txtbx_Password(driver).sendKeys(sPassword);
		Register_Page.txtbx_ComfirmPassword(driver).sendKeys(sComfirmPassword);
		Register_Page.txtbx_FirstName(driver).sendKeys(sFirstname);
		Register_Page.txtbx_LastName(driver).sendKeys(sLastname);
		Register_Page.txtbx_PhoneNumber(driver).sendKeys(sPhoneNumber);
		Register_Page.lisbx_City(driver).selectByVisibleText(ssCity);
		Register_Page.txtbx_City(driver).sendKeys(sCity);
		Register_Page.txtbx_Address(driver).sendKeys(sAddress);
		Register_Page.txtbx_State(driver).sendKeys(sState);
		Register_Page.txtbx_PostalCode(driver).sendKeys(sPostalCode);

		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btnbx_Register(driver).click();
		wait.until(ExpectedConditions.textToBePresentInElement(Home_Page.txt_Login(driver), sLogin));

//		Screenshot.captureScreenShot(driver);
		
		driver.getCurrentUrl();

	}

	public static void ExecuteFalha(WebDriver driver) throws Exception {

		Home_Page.lnk_MyAccount(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.btn_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		
		
		
		String sUserNamef = ExcelUtils.getCellData(2, 1);
		String sEmailf = ExcelUtils.getCellData(2, 2);
		String sPasswordf = ExcelUtils.getCellData(2, 3);
		String sComfirmPasswordf = ExcelUtils.getCellData(2, 4);
		String sFirstnamef = ExcelUtils.getCellData(2, 5);
		String sLastnamef = ExcelUtils.getCellData(2, 6);
		String sPhoneNumberf = ExcelUtils.getCellData(2, 7);
		String ssCityf = ExcelUtils.getCellData(2, 8);
		String sCityf = ExcelUtils.getCellData(2, 9);
		String sAddressf = ExcelUtils.getCellData(2, 10);
		String sStatef = ExcelUtils.getCellData(2, 11);
		String sPostalCodef = ExcelUtils.getCellData(2, 12);
		
		
		Register_Page.txtbx_UserName(driver).sendKeys(sUserNamef);
		Register_Page.txtbx_Email(driver).sendKeys(sEmailf);
		Register_Page.txtbx_Password(driver).sendKeys(sPasswordf);
		Register_Page.txtbx_ComfirmPassword(driver).sendKeys(sComfirmPasswordf);
		Register_Page.txtbx_FirstName(driver).sendKeys(sFirstnamef);
		Register_Page.txtbx_LastName(driver).sendKeys(sLastnamef);
		Register_Page.txtbx_PhoneNumber(driver).sendKeys(sPhoneNumberf);
		Register_Page.lisbx_City(driver).selectByVisibleText(ssCityf);
		Register_Page.txtbx_City(driver).sendKeys(sCityf);
		Register_Page.txtbx_Address(driver).sendKeys(sAddressf);
		Register_Page.txtbx_State(driver).sendKeys(sStatef);
		Register_Page.txtbx_PostalCode(driver).sendKeys(sPostalCodef);
		
		


		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btnbx_Register(driver).click();

		WebDriverWait wait3 = new WebDriverWait(driver, 10);
//		Screenshot.captureScreenShot(driver);
		
	}
}
