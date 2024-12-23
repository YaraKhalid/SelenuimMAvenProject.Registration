import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGdemo {
    WebDriver driver = new EdgeDriver();

    //locators
    private By HomePageVisibality = By.cssSelector("img[src='/static/images/home/logo.png']");
    private By EnterAccountInfo = By.xpath("(//b)[1]");
    private By AccountCreated = By.cssSelector("h2[data-qa='account-created']");
    private By FirstContinueButton = By.cssSelector("a[data-qa='continue-button']");
    private By DeleteButton = By.cssSelector("a[href='/delete_account']");
    private By DeleteText = By.cssSelector("h2[data-qa='account-deleted']");
    private By SecondContinueButton = By.cssSelector("a[data-qa='continue-button']");
    private By SignUpLogInButton = By.cssSelector("a[href='/login']");
    private By UsernAme = By.cssSelector("input[data-qa='signup-name']");
    private By email = By.cssSelector("input[data-qa='signup-email']");
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
    private By USerLoggedIn = By.cssSelector("i[class='fa fa-user']");
    private By FirstSignUpButton = By.cssSelector("button[data-qa='signup-button']");
    private By secondSignupButton = By.cssSelector("button[data-qa='create-account']");


    @BeforeClass
    public void beforeClass() {
        navigateToURL("https://automationexercise.com/");
        driver.manage().window().maximize();

    }


    @Test
    public void testSinUp() {

        verifyHomePageIsLoaded();
        navigateToSignUpPage();
        assertThatNewUserSignUpIsShown();
        enterSignUpUserAndEmail("Yara", "gegitjj69@luxyss.com");
        clickOnSignUp();
        assertThatEnterAccountInfoIsVisible();
        fillinAcoountInformationToSignUp("Yara123", "15", "August", "2000");
        fillinAddressInformationToSignUp("Yara", "Sayed", "Giza", "OCtober", "October", "Canada", "October", "Giza", "12511", "012345432678");
        clickCreateAccount();
        assertThatAccountCreatedIsVisible();
        clickOnContinue();
        verifyThatLoggedInAsUsernameIsVisible();
        deleteAccount();
        validatedThatAccountDeletedIsVisible();
        clickContinue();
    }


    private void navigateToURL(String URL) {
        driver.navigate().to(URL);
    }

    private void verifyHomePageIsLoaded(){
        driver.findElement(HomePageVisibality).isDisplayed();
    }

    private void navigateToSignUpPage(){
        driver.findElement(SignUpLogInButton).click();
    }

    private void assertThatNewUserSignUpIsShown(){
        driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
    }

    private void enterSignUpUserAndEmail(String UserNAme, String Email) {
        driver.findElement(UsernAme).sendKeys(UserNAme);
        driver.findElement(email).sendKeys(Email);
    }
    private void clickOnSignUp(){
        driver.findElement(FirstSignUpButton).click();
    }

    private void assertThatEnterAccountInfoIsVisible(){
        Assert.assertEquals(driver.findElement(EnterAccountInfo).getText(), "ENTER ACCOUNT INFORMATION");
    }

    private void fillinAcoountInformationToSignUp(String Password, String DayOFBirth, String MonthOfBirth, String YearOfBirth) {
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
    }

    private void fillinAddressInformationToSignUp(String FirstNAme, String LastNAme, String Company, String Address1, String Address2, String Country, String State, String City, String ZipCode, String MobileNumber) {
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
    }

    private void clickCreateAccount(){
        driver.findElement(secondSignupButton).click();
    }

    private void assertThatAccountCreatedIsVisible(){
        Assert.assertEquals(driver.findElement(By.cssSelector("h2[data-qa='account-created']")).getText(), "ACCOUNT CREATED!");
    }

    private void clickOnContinue(){
        driver.findElement(FirstContinueButton).click();
    }

    private void verifyThatLoggedInAsUsernameIsVisible(){
        driver.findElement(USerLoggedIn).isDisplayed();
    }

    private void deleteAccount(){
        driver.findElement(DeleteButton).click();
    }
    private void validatedThatAccountDeletedIsVisible(){
        Assert.assertEquals(driver.findElement(DeleteText).getText(), "ACCOUNT DELETED!");
    }

    private void clickContinue(){
        driver.findElement(SecondContinueButton).click();
    }


}
