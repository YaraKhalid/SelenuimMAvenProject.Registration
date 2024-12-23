package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

                //////// locators \\\\\\\\\\\\\
    private final By HomePageVisibality = By.cssSelector("img[src='/static/images/home/logo.png']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    ///////////// Actions \\\\\\\\\\\\\\
    public HomePage navigateToURL() {
        driver.navigate().to("https://automationexercise.com/");
        return this;
    }


                 /////// Assertions \\\\\\\\\\\\\

    public HomePage verifyHomePageIsLoaded(){
        driver.findElement(HomePageVisibality).isDisplayed();
        return this;

    }

}
