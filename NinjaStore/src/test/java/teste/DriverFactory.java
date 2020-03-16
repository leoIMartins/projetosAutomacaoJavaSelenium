package teste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class DriverFactory {

private static WebDriver driver;
private static final String DRIVER_CHROME = "chrome";
private static final String DRIVER_IE = "ie";
private static final String DRIVER_FIREFOX = "firefox";
private static final String HEADLESS_CHROME = "chrome-headless";
private static final String DRIVER_EDGE = "edge";

public static WebDriver createDriver(String browserName) {
   
   if (browserName.equals(DRIVER_CHROME)) {
      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
      driver = new ChromeDriver();
   } 
   
   else if (browserName.equals(DRIVER_IE)) {
      System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer.exe");
      driver = new InternetExplorerDriver();
   } 
   
   else if (browserName.equals(DRIVER_FIREFOX)) {
      System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");
      driver = new FirefoxDriver();
   } 
   
   else if (browserName.equals(HEADLESS_CHROME)) {
      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless");
      driver = new ChromeDriver(options);
   } 
   
   else if (browserName.equals(DRIVER_EDGE)) {
	      System.setProperty("webdriver.edge.driver", "path/to/MicrosoftWebDriver.exe");
	      driver = new EdgeDriver();
	   } 
   
   return driver;
   }
}
