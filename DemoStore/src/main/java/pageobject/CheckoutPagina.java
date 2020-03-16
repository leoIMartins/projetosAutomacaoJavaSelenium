package pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import massateste.MassaTeste;

public class CheckoutPagina extends ClasseBasePageObject{

	@FindBy(id = "onepage-guest-register-button")
	private WebElement botaoContinue1;
	
	@FindBy(id = "billing:firstname")
	private WebElement campoFirstName;
	
	@FindBy(id = "billing:middlename")
	private WebElement campoMiddleName;
	
	@FindBy(id = "billing:lastname")
	private WebElement campoLastName;
	
	@FindBy(id = "billing:company")
	private WebElement campoCompany;
	
	@FindBy(id = "billing:email")
	private WebElement campoEmail;
	
	@FindBy(id = "billing:street1")
	private WebElement campoAdress;
	
	@FindBy(id = "billing:city")
	private WebElement campoCity;
	
	@FindBy(id = "billing:region_id")
	private WebElement comboState;
	
	@FindBy(id = "billing:postcode")
	private WebElement campoZip;
	
	@FindBy(id = "billing:country_id")
	private WebElement comboCountry;
	
	@FindBy(id = "billing:telephone")
	private WebElement campoTelephone;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']/button[@title='Continue']")
	private WebElement botaoContinue2;
	
	@FindBys({
		@FindBy(xpath = "//input[@name='shipping_method']")
	})
	private List<WebElement> opcoesEnvio;
	
	private static final String LOC_DIV_SHIPPING_METHOD =  "//*[@id='checkout-step-shipping_method']";
	
	@FindBy(xpath = "//button[@onclick='shippingMethod.save()']")
	private WebElement botaoContinue3;
	
	@FindBy(xpath = "//button[@onclick='payment.save()']")
	private WebElement botaoContinue4;
	
	@FindBy(xpath = "//button[@title='Place Order']")
	private WebElement botaoPlaceOrder;
	
	public CheckoutPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public int selecaoRandomica() {
		Random random = new Random();
		return (random.nextInt(opcoesEnvio.size()));
	}

	public void preencheFormularios() {
		wait = new WebDriverWait(driver,10);
		
		botaoContinue1.click();
		campoFirstName.sendKeys(MassaTeste.FIRST_NAME);
		campoMiddleName.sendKeys(MassaTeste.MIDDLE_NAME);
		campoLastName.sendKeys(MassaTeste.LAST_NAME);
		campoCompany.sendKeys(MassaTeste.COMPANY);
		campoEmail.sendKeys(MassaTeste.EMAIL);
		campoAdress.sendKeys(MassaTeste.ADRESS);
		campoCity.sendKeys(MassaTeste.CITY);
		
		Select select1 = new Select(comboState);
		select1.selectByVisibleText(MassaTeste.STATE);
		
		campoZip.sendKeys(MassaTeste.ZIP);
		
		Select select2 = new Select(comboCountry);
		select2.selectByVisibleText(MassaTeste.COUNTRY);
		
		campoTelephone.sendKeys(MassaTeste.TELEPHONE);
		botaoContinue2.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOC_DIV_SHIPPING_METHOD)));
		opcoesEnvio.get(selecaoRandomica()).click();
		botaoContinue3.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(botaoContinue4));
		botaoContinue4.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(botaoPlaceOrder));
		botaoPlaceOrder.click();
	}
	
	
}
