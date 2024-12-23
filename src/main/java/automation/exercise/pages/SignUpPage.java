package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPage {
    WebDriver driver;

    //////// Locators \\\\\\\\\\
    private By EnterAccountInfo = By.xpath("(//b)[1]");
    private By password = By.id("password");
    private By dayOfBirth = By.id("days");
    private By monthOfBirth = By.id("months");
    private By yearOfBirth = By.id("years");
    private By NewsletterCheck = By.id("newsletter");
    private By optinCheck = By.id("optin");
    private By firstNAme = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By mobileNumber = By.id("mobile_number");
    private By zipcode = By.id("zipcode");
    private By secondSignupButton = By.cssSelector("button[data-qa='create-account']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    ////// Actions \\\\\\\\\\
    public SignUpPage fillinAcoountInformationToSignUp(String Password, String DayOFBirth, String MonthOfBirth, String YearOfBirth) {
        driver.findElement(By.id("id_gender2")).click();
        //driver.findElement(By.id("name")).sendKeys("Yara");
        //driver.findElement(By.id("email")).sendKeys("gegit66990@luxyss.com");
        driver.findElement(password).sendKeys(Password);
        //dropdown date of birth
        new Select(driver.findElement(dayOfBirth)).selectByVisibleText(DayOFBirth);
        new Select(driver.findElement(monthOfBirth)).selectByVisibleText(MonthOfBirth);
        new Select(driver.findElement(yearOfBirth)).selectByVisibleText(YearOfBirth);
        //checkboxes
        driver.findElement(NewsletterCheck).click();
        driver.findElement(optinCheck).click();
        return this;
    }

    public SignUpPage fillinAddressInformationToSignUp(String FirstNAme, String LastNAme, String Company, String Address1, String Address2, String Country, String State, String City, String ZipCode, String MobileNumber) {
        //continue filling data
        driver.findElement(firstNAme).sendKeys(FirstNAme);
        driver.findElement(lastName).sendKeys(LastNAme);
        driver.findElement(company).sendKeys(Company);
        driver.findElement(address1).sendKeys(Address1);
        driver.findElement(address2).sendKeys(Address2);
        //dropdown menue for country
        new Select(driver.findElement(country)).selectByVisibleText(Country);
        //continue filling data
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(ZipCode);
        driver.findElement(mobileNumber).sendKeys(MobileNumber);
        return this;
    }

    public SignUpPage clickCreateAccount(){
        driver.findElement(secondSignupButton).click();
        return this;
    }

    ///////// Assertions \\\\\\\\\\\\\
    public SignUpPage assertThatEnterAccountInfoIsVisible(){
        Assert.assertEquals(driver.findElement(EnterAccountInfo).getText(), "ENTER ACCOUNT INFORMATION");
    return this;
    }

}
