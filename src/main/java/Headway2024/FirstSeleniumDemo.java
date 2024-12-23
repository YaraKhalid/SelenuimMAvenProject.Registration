package Headway2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSeleniumDemo {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();

        //Sign up
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Yara");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("gegit69@luxyss.com");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender2")).click();
        //driver.findElement(By.id("name")).sendKeys("Yara");
        //driver.findElement(By.id("email")).sendKeys("gegit66990@luxyss.com");
        driver.findElement(By.id("password")).sendKeys("Yara2000");

        //dropdown date of birth
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("15");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("August");
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("2000");

        //checkboxes
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //continue filling data
        driver.findElement(By.id("first_name")).sendKeys("Yara");
        driver.findElement(By.id("last_name")).sendKeys("Sayed");
        driver.findElement(By.id("company")).sendKeys("Giza Systems");
        driver.findElement(By.id("address1")).sendKeys("Sherif Elhennawy, 6 October City");
        driver.findElement(By.id("address2")).sendKeys("6 October City");

        //dropdown menue for country
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Canada");

        //continue filling data
        driver.findElement(By.id("state")).sendKeys("October");
        driver.findElement(By.id("city")).sendKeys("Giza");
        driver.findElement(By.id("zipcode")).sendKeys("12511");
        driver.findElement(By.id("mobile_number")).sendKeys("01123435678");
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
        //verify account created
        System.out.println(driver.findElement(By.cssSelector("h2[data-qa='account-created']")).getText());

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //verify account Deleted
        System.out.println(driver.findElement(By.cssSelector("h2[data-qa='account-deleted']")).getText());


    }
}
