package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelecaoCategoriaPagina extends ClasseBasePageObject{

	Actions actions;
	
	@FindBy(xpath = "//*/li[@class='level0 nav-2 parent']")
	private WebElement menuMen;
	
	@FindBy(xpath = "//a[text()='Blazers']")
	private WebElement opcaoBlazers;
	
	public SelecaoCategoriaPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selecionaProduto() {
		actions = new Actions(driver);
		actions.moveToElement(menuMen).perform();
		opcaoBlazers.click();
	}

	
}
