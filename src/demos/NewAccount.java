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
        String gender = "Female";
        String password = "mspass";
        String country = "Brazil";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occasional = false;
        String successfulMessage = "Customer information added successfully";

        //WebElements definitions
        WebElement createAccountButtonElement = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a"));
        createAccountButtonElement.click();

        WebElement txtName = driver.findElement(By.id("MainContent_txtFirstName"));
        WebElement txtEmail = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement txtPhone = driver.findElement(By.id("MainContent_txtHomePhone"));
        WebElement txtPassword = driver.findElement(By.id("MainContent_txtPassword"));
        WebElement txtVerifyPassword = driver.findElement(By.id("MainContent_txtVerifyPassword"));
        WebElement txtCountry = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement btnSubmit = driver.findElement(By.id("MainContent_btnSubmit"));
        WebElement maleRadioButton = driver.findElement(By.id("MainContent_Male"));

        WebElement femaleRadioButton = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
        WebElement monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
        WebElement occasionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));

        WebElement successfulMessageElement;

        //Fill out the form
        txtName.sendKeys(name);
        txtEmail.sendKeys(email);
        txtPhone.sendKeys(phoneNumber);
        txtPassword.sendKeys(password);
        txtVerifyPassword.sendKeys(password);

        //How to manage the dropdown.
        new Select(txtCountry).selectByVisibleText(country);

        //Gender radio button
        if (gender.equalsIgnoreCase("Male")) {
            maleRadioButton.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            femaleRadioButton.click();
        }

        //Check box management
        //1. Weekly checkbox
        if (weeklyEmail) {
            if (!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        } else {
            if (weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        }

        //2.Monthly checkbox
        if (monthlyEmail) {
            if (!monthlyCheckbox.isSelected()) {
                monthlyCheckbox.click();
            }
        } else {
            if (monthlyCheckbox.isSelected()) {
                monthlyCheckbox.click();
            }
        }

        //3.Occasional checkbox
        if (occasional) {
            if (!occasionalCheckbox.isSelected()) {
                occasionalCheckbox.click();
            }
        } else {
            if (occasionalCheckbox.isSelected()) {
                occasionalCheckbox.click();
            }
        }

        //Submit the form
        btnSubmit.click();

        //Get confirmation & close browser
        successfulMessageElement = driver.findElement(By.id("MainContent_lblTransactionResult"));
        String conf = successfulMessageElement.getText();

        //Validate result of the test
        if (conf.contains(successfulMessage)) {
            System.out.println("Message: " + conf);
        } else {
            System.out.printf("Test Fail");
        }

        driver.close();
    }
}
