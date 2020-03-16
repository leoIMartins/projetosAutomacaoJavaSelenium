package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import massateste.Mensagens;

public class SucessoCompraPagina extends ClasseBasePageObject{

	@FindBy(xpath = "//button[@title='Continue Shopping']")
	private WebElement botaoContinueShopping;
	
	public SucessoCompraPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean verificaMensagem() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoContinueShopping));
		return driver.getPageSource().contains(Mensagens.MENSAGEM_COMPRA_COM_SUCESSO);
	}
	
	public void continuaCompra() {
		botaoContinueShopping.click();
	}
}
