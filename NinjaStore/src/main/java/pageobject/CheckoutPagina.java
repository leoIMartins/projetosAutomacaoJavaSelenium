package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import massateste.MassaTeste;
import massateste.Mensagens;

public class CheckoutPagina extends ClasseBasePageObject{

	@FindBy(xpath="//input[@value='guest']")
	private WebElement radioGuest;
	
	@FindBy(id="button-account")
	private WebElement botaoContinue1;
	
	@FindBy(id="input-payment-firstname")
	private WebElement campoFirstName;
	
	@FindBy(id="input-payment-lastname")
	private WebElement campoLastName;
	
	@FindBy(id="input-payment-email")
	private WebElement campoEmail;
	
	@FindBy(id="input-payment-telephone")
	private WebElement campoTelephone;
	
	@FindBy(id="input-payment-address-1")
	private WebElement campoAdress1;
	
	@FindBy(id="input-payment-city")
	private WebElement campoCity;
	
	@FindBy(id="input-payment-postcode")
	private WebElement campoPostCode;
	
	@FindBy(id="input-payment-country")
	private WebElement comboCountry;
	
	@FindBy(id="input-payment-zone")
	private WebElement comboRegion;
	
	@FindBy(id="button-guest")
	private WebElement botaoContinue2;
	
	@FindBy(name="comment")
	private WebElement campoComment;
	
	@FindBy(id="button-shipping-method")
	private WebElement botaoContinue3;
	
	@FindBy(name="agree")
	private WebElement checkAgree;
	
	@FindBy(id="button-payment-method")
	private WebElement botaoContinue4;
	
	@FindBy(id="button-confirm")
	private WebElement botaoConfirmOrder;
	
	private static final String LOC_MSG_SUCESS = "//h1[text()='Your order has been placed!']";
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement botaoContinue5;
	
	public CheckoutPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/*public int selecaoRandomica() {
		Random random = new Random();
		return (random.nextInt(comboRegion.size()));
	}*/
	
	public void preencheFormulario() throws InterruptedException {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(radioGuest));
		radioGuest.click();
		botaoContinue1.click();
		campoFirstName.sendKeys(MassaTeste.FIRST_NAME);
		campoLastName.sendKeys(MassaTeste.LAST_NAME);
		campoEmail.sendKeys(MassaTeste.EMAIL);
		campoTelephone.sendKeys(MassaTeste.PHONE);
		campoAdress1.sendKeys(MassaTeste.ADRESS1);
		campoCity.sendKeys(MassaTeste.CITY);
		campoPostCode.sendKeys(MassaTeste.POST_CODE);

		Select select1 = new Select(comboCountry);
		select1.selectByVisibleText(MassaTeste.COUNTRY);
		
		Thread.sleep(1000);
		
		Select select2 = new Select(comboRegion);
		select2.selectByVisibleText(MassaTeste.REGION);
		
		botaoContinue2.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(campoComment));
		campoComment.sendKeys(MassaTeste.COMMENT);
		botaoContinue3.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(checkAgree));
		checkAgree.click();
		botaoContinue4.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(botaoConfirmOrder));
		botaoConfirmOrder.click();
	}
	
	public boolean verificaMensagem() {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOC_MSG_SUCESS)));
		return driver.getPageSource().contains(Mensagens.MENSAGEM_COMPRA_SUCESSO);
	}
	
	public void finaliza() {
		botaoContinue5.click();
	}
}
