package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TweetBoxPage extends BasePage {

    private final WebDriver driver;

    @FindBy(how = How.ID, using = "tweet-box-home-timeline")
    private WebElement tweetBox;

    @FindBy(how = How.CSS, using = "form.tweet-form:nth-child(2) > div:nth-child(3) > div:nth-child(2) > button:nth-child(2)")
    private WebElement tweetButton;

    @FindBy(how = How.CSS, using = "form.tweet-form:nth-child(2) > div:nth-child(3) > div:nth-child(2) > span:nth-child(1) > button:nth-child(1)")
    private WebElement addExtraTweetBtn;

    @FindBy(how = How.NAME, using = "media_empty")
    private WebElement attachMediaBtn;

    @FindBy(how = How.CSS, using = "form.tweet-form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(2) > div:nth-child(1) > button:nth-child(1)")
    private WebElement attachGIFBtn;

    @FindBy(how = How.CSS, using = "form.tweet-form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(2) > div:nth-child(1) > button:nth-child(1) > span:nth-child(2)")
    private WebElement attachGIFTooltip;

    public TweetBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public final boolean isTweetBoxDisplayed() {
        return tweetBox.isDisplayed();
    }

    public final String getDefaultPlaceholderText() {
        return tweetBox.getAttribute("data-placeholder-default");
    }

    public void expandBox() {
        tweetBox.click();
    }

    public final boolean isTweetButtonDisabled() {
        return !tweetButton.isEnabled();
    }

    public final String getTweetButtonText() {
        return tweetButton.getText();
    }

    public final boolean isAddExtraTweetBtnDisabled() {
        return !addExtraTweetBtn.isEnabled();
    }

    public final boolean isAttachMediaBtnVisible() {
        return attachMediaBtn.isDisplayed();
    }

    public final String getAttachMediaTooltip() {
        Actions actions = new Actions(driver);
        actions.moveToElement(attachMediaBtn);
        return attachMediaBtn.getAttribute("data-original-title");
    }

    public final boolean isAttachGIFBtnDisplayed() {
        return attachGIFBtn.isDisplayed();
    }

    public final String getAttachGIFTooltip() {
        Actions actions = new Actions(driver);
        actions.moveToElement(attachGIFBtn);
        return attachGIFTooltip.getText();
    }
}
