package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPagina extends ClasseBasePageObject{

	Actions actions;
	
	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement menuPim;
	
	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveModule']/b")
	private WebElement menuLeave;
	
	@FindBy(id = "menu_leave_viewLeaveList")
	private WebElement menuLeaveList;
	
	public DashboardPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selecionaMenuPim() {
		menuPim.click();
	}
	
	public void selecionaMenuLeave() throws InterruptedException {
		menuLeave.click();
		menuLeaveList.click();
	}

}
