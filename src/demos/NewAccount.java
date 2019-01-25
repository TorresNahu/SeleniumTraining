package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class NewAccount {

    public static void main(String[] args) {
        //Initialize driver
        WebDriver driver;
        driver = utilities.DriverFactory.open("chrome");
        Objects.requireNonNull(driver).get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Data
        String name = "Mari Sue";
        String email = "ms@testemail.com";
        String phoneNumber = "123987123";
        String gender;
        String password = "mspass";
        String country = "Brazil";
        String weeklyEmail;
        String monthlyEmail;
        String occasional;

        //WebElements definitions
        WebElement createAccountButtonElement = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a"));
        createAccountButtonElement.click();

        WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
        WebElement passwordElement = driver.findElement(By.id("MainContent_txtPassword"));
        WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement submitButtonElement = driver.findElement(By.id("MainContent_btnSubmit"));

        //Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);

        //How to manage the dropdown.
        new Select(countryElement).selectByVisibleText(country);

        driver.findElement(By.id("MainContent_Female")).click();
        driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();

        //Submit the form
        submitButtonElement.click();

        //Get confirmation & close browser
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("Confirmation: " + conf);
//        driver.close();
    }
}
