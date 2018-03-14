package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
