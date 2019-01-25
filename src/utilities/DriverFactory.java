package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    //This method will return a Webdriver object
    public static WebDriver open(String browserType){
        //1. Create web driver
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ntorres\\Documents\\AutomationPractice\\Software\\chromedriver.exe");
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ntorres\\Documents\\AutomationPractice\\Software\\geckodriver.exe");
            return new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\ntorres\\Documents\\AutomationPractice\\Software\\MicrosoftWebDriver.exe");
            return new EdgeDriver();
        }
        return null;
    }
}
