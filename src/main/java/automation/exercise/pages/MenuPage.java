package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    WebDriver driver;

    //////// Locators \\\\\\\\\
    private By SignUpLogInButton = By.cssSelector("a[href='/login']");
    private By DeleteButton = By.cssSelector("a[href='/delete_account']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    //////// Actions \\\\\\\\
    public MenuPage navigateToSignUpPage(){
        driver.findElement(SignUpLogInButton).click();
        return this;
    }
    public MenuPage deleteAccount(){
        driver.findElement(DeleteButton).click();
        return this;
    }

    /////// Assertions \\\\\\\

}
