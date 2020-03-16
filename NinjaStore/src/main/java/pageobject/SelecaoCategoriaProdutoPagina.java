package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelecaoCategoriaProdutoPagina extends ClasseBasePageObject{

	@FindBy(xpath="//a[text()='Cameras']")
	private WebElement menuCamera;
	
	public SelecaoCategoriaProdutoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void selecionaMenuCamera() {
		menuCamera.click();
	}
}
