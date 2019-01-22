package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        //1. Define web driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ntorres\\Documents\\AutomationPractice\\Software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Open the browser and navigate to the web application
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Find the elements
            //Locate the elements, determine the action, pass any parameters
        //3. Enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testmail.com");
        //4. Enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
        //5. Click login
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
        //6. Get Confirmation

        //7. Close browser

    }
}
