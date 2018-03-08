import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseTest {

    final String chromeDriverPath = System.getenv("SELENIUM_DRIVERS_DIR") + "/chromedriver";
    final static Logger logger = Logger.getLogger("twitter_functional_tests");
    final String validEmail = System.getenv("validEmail");
    final String validHandle = System.getenv("validHandle");
    final String validPassword = System.getenv("validPassword");
    final String twitterFullName = System.getenv("twitterFullName");
    final String invalidPassword = "not_a_password";
    final String invalidEmail = "not_an_email";
    final String invalidHandle = "not_a_handle";
    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
