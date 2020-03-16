package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClasseBasePageObject {

	WebDriver driver;
	WebDriverWait wait;
	
	public ClasseBasePageObject(WebDriver driver) {
		this.driver = driver;
	}
}
