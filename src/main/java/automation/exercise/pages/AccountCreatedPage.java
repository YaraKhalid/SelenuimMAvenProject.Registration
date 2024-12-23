package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreatedPage {
    WebDriver driver;

    ////////// Locators \\\\\\\\\\
    private By FirstContinueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

///////// Actions \\\\\\\\

    public AccountCreatedPage clickOnContinue(){
        driver.findElement(FirstContinueButton).click();
        return this;
    }

    ////////// Assertions \\\\\\\\\\
    public AccountCreatedPage assertThatAccountCreatedIsVisible(){
        Assert.assertEquals(driver.findElement(By.cssSelector("h2[data-qa='account-created']")).getText(), "ACCOUNT CREATED!");
    return this;
    }

}
