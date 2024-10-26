package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public Properties prop;
    public String email ;
    public String pass ;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();

        String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\Config\\config.properties";

        FileInputStream fis = new FileInputStream(filePath);

        prop.load(fis);

        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        email = prop.getProperty("username");
        pass = prop.getProperty("password");

        if (browser.equalsIgnoreCase("chrome")) {


            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {


            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {


            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;


    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {
        driver = initializeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
