package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLoggedInPage {
    WebDriver driver;

    //////// Locators \\\\\\\\\

    private By USerLoggedIn = By.cssSelector("i[class='fa fa-user']");

    public UserLoggedInPage(WebDriver driver) {
        this.driver = driver;
    }
////// Actions \\\\\\\\\\

    public UserLoggedInPage verifyThatLoggedInAsUsernameIsVisible(){
        driver.findElement(USerLoggedIn).isDisplayed();
        return this;
    }


    /////// Assertions \\\\\\\

}
