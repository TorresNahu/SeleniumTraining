package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

    public static void main(String[] args) {
        //1. Create web driver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ntorres\\Documents\\AutomationPractice\\Software\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //2. Navigate to Account Management >> Click on Create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
        //driver.findElement(By.linkText("Create Account")).click();

        //3. Fill out the form
        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testmail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123987123");

        driver.findElement(By.id("MainContent_Female")).click();
//        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();

//        driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("mspass");
        driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("mspass");
        driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("mspass");

        //How to manage the dropdown.
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Brazil");

        driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

        //4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("Confirmation: " + conf);

        //5. Close browser
        driver.close();
    }
}
