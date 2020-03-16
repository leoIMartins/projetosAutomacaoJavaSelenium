package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClasseBasePageObject {
	
	WebDriverWait wait;
	WebDriver driver;
	
	public ClasseBasePageObject(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(driver,10);
	}

}
