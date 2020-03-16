package pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import massateste.MassaTeste;
import massateste.Mensagens;

public class AtribuirLicencaPagina extends ClasseBasePageObject{

	@FindBy(id = "assignleave_txtEmployee_empName")
	private WebElement campoEmployeeName;
	
	@FindBys({
		@FindBy(xpath = "//select[@id='assignleave_txtLeaveType']/option[@value>=1]")
	})
	private List<WebElement> tiposLicenca;
	
	@FindBy(id = "assignleave_txtFromDate")
	private WebElement campoFromDate;

	@FindBy(id = "assignleave_txtToDate")
	private WebElement campoToDate;
	
	@FindBy(id = "assignleave_txtComment")
	private WebElement campoComment;
	
	@FindBy(id = "assignBtn")
	private WebElement botaoAssign;
	
	public AtribuirLicencaPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public int selecaoRandomica() {
		Random random = new Random();
		return (random.nextInt(tiposLicenca.size()));
	}

	public void atribuir() {
		campoEmployeeName.sendKeys(MassaTeste.FIRST_NAME + " " + MassaTeste.LAST_NAME);
		tiposLicenca.get(selecaoRandomica()).click();
		campoFromDate.clear();
		campoFromDate.sendKeys(MassaTeste.FROM_DATE);
		campoToDate.clear();
		campoToDate.sendKeys(MassaTeste.TO_DATE);
		campoComment.sendKeys(MassaTeste.COMMENT);
		botaoAssign.click();
	}
	
	public boolean verificarMensagemSucesso() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successfully Assigned')]")));
		return (driver.getPageSource().contains(Mensagens.MENSAGEM_SUCESSO));
	}

}
