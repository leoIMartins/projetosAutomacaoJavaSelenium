package pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProdutoPagina extends ClasseBasePageObject{

	@FindBy(xpath = "//img[@alt=\"White\"]")
	private WebElement imgWhite;
	
	@FindBys({
		@FindBy(xpath = "//ul[@id=\"configurable_swatch_size\"]/li")
	})
	private List<WebElement> tamanhos;
	
	@FindBy(id = "qty")
	private WebElement campoQuantidade;
	
	@FindBy(xpath = "//div[@class='add-to-cart-buttons']")
	private WebElement botaoAddToCart;
	
	public ProdutoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public int selecaoRandomica() {
		Random random = new Random();
		return (random.nextInt(tamanhos.size()));
	}
	
	public void adicionaAoCarrinho() {
		imgWhite.click();
		tamanhos.get(selecaoRandomica()).click();
		campoQuantidade.clear();
		campoQuantidade.sendKeys("2");
		botaoAddToCart.click();
	}

}
