package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {
    private final WebDriver driver;
    private GlobalNavBarPage globalNavBarPage;
    private final String LOGIN_URL = getBaseUrl() + "login/";

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(LOGIN_URL);
    }

    private WebElement getUserNameField() {
        By usernameIdent = By.cssSelector("#page-container > div > div.signin-wrapper > form > fieldset > div:nth-child(2) > input");
        return driver.findElement(usernameIdent);
    }

    private WebElement getPasswordField() {
        By passIdent = By.cssSelector("#page-container > div > div.signin-wrapper > form > fieldset > div:nth-child(3) > input");
        return driver.findElement(passIdent);
    }

    private WebElement getLogInBtn() {
        By logInBtnIdent = By.cssSelector("#page-container > div > div.signin-wrapper > form > div.clearfix > button");
        return driver.findElement(logInBtnIdent);
    }

    public GlobalNavBarPage login(final String identifier, final String password) {
        if (!driver.getCurrentUrl().equals(LOGIN_URL)) {
            driver.get(LOGIN_URL);
        }
        fillIdentifier(identifier);
        fillPassword(password);
        clickLogInButton();
        globalNavBarPage = PageFactory.initElements(driver, GlobalNavBarPage.class);
        return globalNavBarPage;
    }

    public String getLoginErrorMessage() {
        WebElement popUp = getLoginErrorPopup();
        return popUp.getText();
    }

    private WebElement getLoginErrorPopup() {
        By popupIdent = By.cssSelector("#message-drawer > div > div > span");
        return driver.findElement(popupIdent);
    }

    public LogInPage dismissLoginErrorPopup() {
        By errorBtnIdent = By.cssSelector("#message-drawer > div > div > a");
        driver.findElement(errorBtnIdent).click();
        return this;
    }

    private void clickLogInButton() {
        getLogInBtn().click();
    }

    private void fillPassword(String password) {
        WebElement passwordField = getPasswordField();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void fillIdentifier(String identifierStr) {
        WebElement identifier = getUserNameField();
        identifier.clear();
        identifier.sendKeys(identifierStr);
    }

}
