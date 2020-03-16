package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListaEmpregadosPagina extends ClasseBasePageObject{

	@FindBy(id = "btnAdd")
	private WebElement botaoAdd;
	
	public ListaEmpregadosPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clicaBotaoAdd() {
		botaoAdd.click();
	}
}
