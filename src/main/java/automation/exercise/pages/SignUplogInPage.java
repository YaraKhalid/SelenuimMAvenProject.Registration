package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUplogInPage {
    WebDriver driver;

    /////// locators \\\\\\\\\\\\\
    private By UsernAme = By.cssSelector("input[data-qa='signup-name']");
    private By email = By.cssSelector("input[data-qa='signup-email']");
    private By newUserSignUpText=By.xpath("(//h2)[3]");
    private By FirstSignUpButton = By.cssSelector("button[data-qa='signup-button']");

    public SignUplogInPage(WebDriver driver) {
        this.driver = driver;
    }

    ///////// Actions \\\\\\\\\\\\\\
    public SignUplogInPage enterSignUpUserAndEmail(String UserName, String Email) {
        driver.findElement(UsernAme).sendKeys(UserName);
        driver.findElement(email).sendKeys(Email);
        return this;
    }

    public SignUplogInPage clickOnSignUpButton(){
        driver.findElement(FirstSignUpButton).click();
        return this;
    }

    ////////// Assertions \\\\\\\\\\\
    public SignUplogInPage assertThatNewUserSignUpIsShown(){
        driver.findElement(newUserSignUpText).isDisplayed();
        return this;
    }



}
