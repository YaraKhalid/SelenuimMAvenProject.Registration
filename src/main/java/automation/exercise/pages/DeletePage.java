package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeletePage {
    WebDriver driver;
    ////// Locators \\\\\\\\

    private By DeleteText = By.cssSelector("h2[data-qa='account-deleted']");
    private By SecondContinueButton = By.cssSelector("a[data-qa='continue-button']");

    public DeletePage(WebDriver driver) {
        this.driver = driver;
    }
////// Actions \\\\\\\

    public DeletePage clickContinue(){
        driver.findElement(SecondContinueButton).click();
        return this;
    }

    /////// Assertions \\\\\\\\

    public DeletePage validatedThatAccountDeletedIsVisible(){
        Assert.assertEquals(driver.findElement(DeleteText).getText(), "ACCOUNT DELETED!");
        return this;
    }






}
