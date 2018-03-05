package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends BasePage{
    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(getBaseUrl());
    }

    public static WebElement getPasswordInputField(WebDriver driver){
        return null;
    }

    public static WebElement getUsernameInputField(WebDriver driver){
        return null;
    }

    public static WebElement getForgotPasswordLink(WebDriver driver){
        return null;
    }

    public static WebElement getLogInButton(WebDriver driver){
        return null;
    }

    public static WebElement getJoiningPasswordField(WebDriver driver){
        return null;
    }

    public static WebElement getJoiningPhoneEmailField(WebDriver driver){
        return null;
    }


    public static WebElement getGettingStartedBtn(WebDriver driver){
        return null;
    }

    public List<WebElement> getPromoLabels(){
        By promoIdent = By.cssSelector("div.StaticLoggedOutHomePage-communicationContent .StaticLoggedOutHomePage-communicationItem");
        List<WebElement> promos = this.driver.findElements(promoIdent);
        return promos;
    }

}
