package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelecaoProdutoPagina extends ClasseBasePageObject{

	@FindBy(xpath="//img[@title='Nikon D300']")
	private WebElement imagemProduto;
	
	public SelecaoProdutoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selecionaProduto() {
		imagemProduto.click();
	}

}
