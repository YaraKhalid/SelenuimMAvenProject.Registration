package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize, boolean headless) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("initializing Chrome Browser on OS: " + System.getProperty("os.name") + " and it's version is: " + System.getProperty("os.version"));
            ChromeOptions Options= new ChromeOptions();
            if (headless) {
                Options.addArguments("headless");
                driver = new ChromeDriver(Options);
            System.out.println("Successfully initialized the Chrome Browser");
        } else if (browserName.equalsIgnoreCase("firefox")) {
                System.out.println("initializing Firefox Browser on OS: " + System.getProperty("os.name") + " and it's version is: " + System.getProperty("os.version"));
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            }
        } else if (browserName.equalsIgnoreCase("Edge")) {
            System.out.println("initializing Edge Browser on OS: " + System.getProperty("os.name") + " and it's version is: " + System.getProperty("os.version"));
            EdgeOptions options=new EdgeOptions();
            options.addArguments("--headless");
            driver=new EdgeDriver(options);

        }
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("Window is maximized. And the new window size is now: " + driver.manage().window().getSize());
        }
        return driver;
    }
}
