package teste;

import org.junit.Before;
import org.junit.Test;

import pageobject.DashboardPagina;
import pageobject.LeaveListPagina;
import pageobject.LoginPagina;

public class CancelarLicencaTeste extends ClasseBaseTeste{

	LoginPagina loginPagina;
	DashboardPagina dashboardPagina;
	LeaveListPagina leaveListPagina;
	
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
		loginPagina = new LoginPagina(driver);
		dashboardPagina = new DashboardPagina(driver);
		leaveListPagina = new LeaveListPagina(driver);
	}
	
	@Test
	public void cancelaLicenca() throws InterruptedException {
		loginPagina.efetuarLogin();
		dashboardPagina.selecionaMenuLeave();
		leaveListPagina.cancela();
	}
}
