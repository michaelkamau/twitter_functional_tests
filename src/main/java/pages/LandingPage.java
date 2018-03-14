package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage extends BasePage{
    private final WebDriver driver;

    @FindBy(how = How.CSS, using = ".StaticLoggedOutHomePage-login > form:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement passwordInputField;

    @FindBy(how = How.CSS, using = ".StaticLoggedOutHomePage-login > form:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    private WebElement identifierInputField;

    @FindBy(how = How.CSS, using = "input.EdgeButton:nth-child(3)")
    private WebElement logInButton;

    @FindBy(how = How.CSS, using = "a.forgot:nth-child(1)")
    private WebElement forgotPasswordLink;

    @FindBy(how = How.CSS, using = "div.StaticLoggedOutHomePage-field:nth-child(6) > input:nth-child(1)")
    private WebElement joiningIdentifierInputField;

    @FindBy(how = How.CSS, using = "div.StaticLoggedOutHomePage-field:nth-child(7) > input:nth-child(1)")
    private WebElement joiningPasswordInputField;

    @FindBy(how = How.CSS, using = "button.EdgeButton--medium:nth-child(1)")
    private WebElement getStartedButton;

    @FindBy(how = How.CSS, using = ".StaticLoggedOutHomePage-signupTitle")
    private WebElement signUpTitleLabel;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String getLoggedOutUrl() {
        return driver.getCurrentUrl();
    }

}
