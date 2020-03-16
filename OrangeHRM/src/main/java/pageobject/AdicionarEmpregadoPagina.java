package pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import massateste.MassaTeste;

public class AdicionarEmpregadoPagina extends ClasseBasePageObject{

	Actions actions;
	Select select;
	
	@FindBy(id = "firstName")
	private WebElement campoFirstName;
	
	@FindBy(id = "lastName")
	private WebElement campoLastName;
	
	@FindBy(id = "btnSave")
	private WebElement botaoSave;
	
	@FindBy(id = "btnSave")
	private WebElement botaoEdit;
	
	@FindBy(id = "personal_optGender_1")
	private WebElement radioMale;
	
	@FindBys({
		@FindBy(xpath = "//select[@id='personal_cmbMarital']/option[text()!='-- Select --']")
	})
	private List<WebElement> tiposConjugais;
	
	@FindBy(id = "personal_cmbNation")
	private WebElement comboNationality;
	
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	private WebElement menuLeave;
	
	@FindBy(id = "menu_leave_assignLeave")
	private WebElement menuAssignLeave;
	
	public AdicionarEmpregadoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public int selecaoRandomica() {
		Random random = new Random();
		return (random.nextInt(tiposConjugais.size()));
	}
	
	public void adicionaEmpregado() {
		actions = new Actions(driver);
		campoFirstName.sendKeys(MassaTeste.FIRST_NAME);
		campoLastName.sendKeys(MassaTeste.LAST_NAME);
		botaoSave.click();
		botaoEdit.click();
		radioMale.click();
		tiposConjugais.get(selecaoRandomica()).click();
		select = new Select(comboNationality);
		select.selectByVisibleText(MassaTeste.NATIONALITY);
		actions.moveToElement(menuLeave).perform();
		menuAssignLeave.click();
	}

}
