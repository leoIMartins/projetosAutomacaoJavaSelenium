package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import massateste.Mensagens;

public class ShoppingCartPagina extends ClasseBasePageObject{

	@FindBy(xpath = "//ul[@class='checkout-types top']/li/button[@title='Proceed to Checkout']")
	private WebElement botaoCheckout;
	
	public ShoppingCartPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean verificaMensagem() {
		return driver.getPageSource().contains(Mensagens.MENSAGEM_ADICIONAR_CARRINHO_SUCESSO);
	}
	
	public void vaiParaCheckout() {
		botaoCheckout.click();
	}
}
