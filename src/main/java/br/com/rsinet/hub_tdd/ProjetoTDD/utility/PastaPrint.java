package br.com.rsinet.hub_tdd.ProjetoTDD.utility;

import java.io.File;

import org.testng.annotations.BeforeSuite;

public class PastaPrint {

	public static String caminhoPasta = System.getProperty("user.dir") + "/screenshots/" + DataPrint.horas();
	
	@BeforeSuite
	private void PastaS() {
		File pastaPrint = new File(caminhoPasta);
		pastaPrint.mkdir();
	}
}
