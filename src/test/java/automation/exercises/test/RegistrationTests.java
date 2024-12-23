package automation.exercises.test;

import Utilities.JsonFileManager;
import Utilities.PropertiesReader;
import automation.exercise.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Utilities.DriverFactory;


public class RegistrationTests {
    private WebDriver driver;
    private JsonFileManager testData;

    @BeforeMethod
    public void setup() {
        //driver = new EdgeDriver();
        //driver.manage().window().maximize();
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"),Boolean.parseBoolean(System.getProperty("maximizeWindow")), Boolean.parseBoolean(System.getProperty("headlessExecution")));
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/RegisterationTestJsonFile.json");
    }
    @BeforeSuite
    public void beforeSuite(){
        PropertiesReader.loadProperties();
    }

    @Test
    @Description("Registration Test 1")
    @Severity(SeverityLevel.BLOCKER)
    public void Registration() {
        new HomePage(driver)
                .navigateToURL()
                .verifyHomePageIsLoaded();
        new MenuPage(driver)
                .navigateToSignUpPage();
        new SignUplogInPage(driver)
                .assertThatNewUserSignUpIsShown()
                .enterSignUpUserAndEmail(testData.getTestData("UserName"),testData.getTestData("Email"))
                .clickOnSignUpButton();
        new SignUpPage(driver)
                .assertThatEnterAccountInfoIsVisible()
                .fillinAcoountInformationToSignUp("Yara123", "15", "August", "2000")
                .fillinAddressInformationToSignUp("Yara", "Sayed", "Giza", "OCtober", "October", "Canada", "October", "Giza", "12511", "012345432678")
                .clickCreateAccount();
        new AccountCreatedPage(driver)
                .assertThatAccountCreatedIsVisible()
                .clickOnContinue();
        new UserLoggedInPage(driver)
                .verifyThatLoggedInAsUsernameIsVisible();
        new MenuPage(driver)
                .deleteAccount();
        new DeletePage(driver)
                .validatedThatAccountDeletedIsVisible()
                .clickContinue();
    }
    @AfterMethod
    public void teardown(){driver.quit();}

}
