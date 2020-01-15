package br.com.rsinet.hub_tdd.ProjetoTDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {

	private static WebElement element;
	
	public static WebElement txtbx_UserName(WebDriver driver) {
		
		element = driver.findElement(By.id("username"));
		
		return element;
	}
	
	public static WebElement txtbx_Password(WebDriver driver) {
		
		element = driver.findElement(By.id("password"));
		
		return element;
	}
	
	 public static WebElement btn_LogIn(WebDriver driver){
		 
         element = driver.findElement(By.id("sign_in_btnundefined"));
 
         return element;
 }
	 
	 public static WebElement btn_CreateAccount(WebDriver driver) {
		 
		 element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		 
		 return element;
	 }
}
