package teste;

import org.openqa.selenium.WebDriver;

public abstract class ClasseBaseTeste {

	protected WebDriver driver;
	
	public void iniciaAplicacao() {
		driver = DriverFactory.createDriver("edge");
		driver.get(Configuracoes.URL_APLICACAO);
		driver.manage().window().maximize();
	}
}
