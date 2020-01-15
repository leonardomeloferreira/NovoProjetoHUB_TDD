package br.com.rsinet.hub_tdd.ProjetoTDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Category_Page {

	public static WebElement element;
	
	public static WebElement lnk_Laptop(WebDriver driver) {
		
		element = driver.findElement(By.linkText("HP Chromebook 14 G1(ENERGY STAR)"));
		
		return element;
	}
	public static WebElement lnk_Roar(WebDriver driver) {
		
		element = driver.findElement(By.linkText("HP Roar Mini Wireless Speaker"));
		
		return element;
		
	}
	public static WebElement lnk_NoResult(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div"));
		
		return element;
	}
	public static WebElement lnk_Result(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1"));
		
		return element;
	}
	
}
