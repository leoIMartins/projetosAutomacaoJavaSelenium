package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import massateste.MassaTeste;

public class LoginPagina extends ClasseBasePageObject{

	@FindBy(id = "txtUsername")
	private WebElement campoUsername;
	
	@FindBy(id = "txtPassword")
	private WebElement campoPassword;
	
	@FindBy(id = "btnLogin")
	private WebElement botaoLogin;
	
	public LoginPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void efetuarLogin() {
		campoUsername.sendKeys(MassaTeste.USERNAME);
		campoPassword.sendKeys(MassaTeste.PASSWORD);
		botaoLogin.click();
	}
	
}
