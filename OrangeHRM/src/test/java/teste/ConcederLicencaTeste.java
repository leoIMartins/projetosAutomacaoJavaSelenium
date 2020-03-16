package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageobject.AdicionarEmpregadoPagina;
import pageobject.AtribuirLicencaPagina;
import pageobject.DashboardPagina;
import pageobject.ListaEmpregadosPagina;
import pageobject.LoginPagina;

public class ConcederLicencaTeste extends ClasseBaseTeste{
	
	LoginPagina loginPagina;
	DashboardPagina dashboardPagina;
	ListaEmpregadosPagina listaEmpregadosPagina;
	AdicionarEmpregadoPagina adicionarEmpregadoPagina;
	AtribuirLicencaPagina atribuirLicencaPagina;
	
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
		loginPagina = new LoginPagina(driver);
		dashboardPagina = new DashboardPagina(driver);
		listaEmpregadosPagina = new ListaEmpregadosPagina(driver);
		adicionarEmpregadoPagina = new AdicionarEmpregadoPagina(driver);
		atribuirLicencaPagina = new AtribuirLicencaPagina(driver);
	}

	@Test
	public void concedeLicenca() {
		loginPagina.efetuarLogin();
		dashboardPagina.selecionaMenuPim();
		listaEmpregadosPagina.clicaBotaoAdd();
		adicionarEmpregadoPagina.adicionaEmpregado();
		atribuirLicencaPagina.atribuir();
		Assert.assertTrue(atribuirLicencaPagina.verificarMensagemSucesso());
	}
}
