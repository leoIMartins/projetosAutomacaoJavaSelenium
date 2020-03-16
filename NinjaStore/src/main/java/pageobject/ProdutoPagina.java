package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import massateste.Mensagens;

public class ProdutoPagina extends ClasseBasePageObject{

	@FindBy(id="button-cart")
	private WebElement botaoAdicionarAoCarrinho;
	
	private static final String LOC_MSG_SUCESS = "//div[@class='alert alert-success alert-dismissible']";
	
	@FindBy(id="cart")
	private WebElement botaoCarrinho;
	
	@FindBy(className="dropdown-menu pull-right")
	private WebElement dropMenu;
	
	@FindBy(xpath="//strong[text()=' Checkout']")
	private WebElement botaoCheckout;
	
	public ProdutoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void adicionaAoCarrinho() throws InterruptedException {
		botaoAdicionarAoCarrinho.click();
	}
	
	public boolean verificaMensagem() {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOC_MSG_SUCESS)));
		return driver.getPageSource().contains(Mensagens.MENSAGEM1_SUCESSO_ADICIONAR_CARRINHO);

	}
	
	public void vaiParaCheckout() {
		wait = new WebDriverWait(driver,10);
		botaoCarrinho.click();
		wait.until(ExpectedConditions.elementToBeClickable(botaoCheckout));
		botaoCheckout.click();
	}

}
