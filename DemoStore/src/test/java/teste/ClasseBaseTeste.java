package teste;

import org.openqa.selenium.WebDriver;

public abstract class ClasseBaseTeste {

protected WebDriver driver;
	
	public void iniciaAplicacao() throws InterruptedException {
		//System.setProperty(Configuracoes.NOME_DRIVER, Configuracoes.CAMINHO_DRIVER);
		//driver = new ChromeDriver();
		driver = DriverFactory.createDriver("chrome");
		driver.get(Configuracoes.URL_APLICACAO);
		driver.manage().window().maximize();
	}

}
