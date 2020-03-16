package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import massateste.MassaTeste;

public class LeaveListPagina extends ClasseBasePageObject{

	@FindBy(id = "leaveList_txtEmployee_empName")
	private WebElement campoEmployee;
	
	public LeaveListPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void cancela() throws InterruptedException {
		Thread.sleep(2000);
		campoEmployee.clear();
		campoEmployee.sendKeys(MassaTeste.FIRST_NAME + " " + MassaTeste.LAST_NAME);
	}

}
