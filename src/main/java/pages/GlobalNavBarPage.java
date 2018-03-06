package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Models the Global Navigation Bar at the header when a user if logged in.
 */
public class GlobalNavBarPage extends BasePage {
    private final WebDriver driver;

    @FindBy(how = How.CSS, using = "#global-nav-home > a > span.text")
    private WebElement homeLinkText;

    @FindBy(how = How.CSS, using = "#global-nav-home > a")
    private WebElement homeLink;

    @FindBy(how = How.CSS, using = "#global-actions > li.people.notifications > a > span.text")
    private WebElement notificationsLinkText;

    @FindBy(how = How.CSS, using = "#global-actions > li.people.notifications > a")
    private WebElement notificationsLink;

    @FindBy(how = How.CSS, using = "#global-actions > li.dm-nav > a > span.text")
    private WebElement messagesLinkText;

    @FindBy(how = How.CSS, using = "#global-actions > li.dm-nav > a")
    private WebElement messagesLink;

    @FindBy(how = How.CSS, using = "#global-new-tweet-button")
    private WebElement tweetBtn;

    @FindBy(how = How.ID, using = "user-dropdown-toggle")
    private WebElement profileSettingsLink;

    @FindBy(how = How.CSS, using = "#doc > div.topbar.js-topbar > div.global-nav > div > div > h1")
    private WebElement twitterHomeIconLink;

    @FindBy(how = How.ID, using = "#search-query")
    private WebElement searchBox;

    @FindBy(how = How.CSS, using = "#global-nav-home > a > span.Icon.Icon--homeFilled.Icon--large.u-textUserColor")
    private WebElement homeIcon;

    @FindBy(how = How.CSS, using = "#global-nav-search > span > button")
    private WebElement searchBoxIcon;

    @FindBy(how = How.CSS, using = "#global-actions > li.people.notifications > a > span.Icon.Icon--notifications.Icon--large")
    private WebElement notificationsIcon;

    @FindBy(how = How.CSS, using = "#global-actions > li.dm-nav > a > span.Icon.Icon--dm.Icon--large")
    private WebElement messagesIcon;

    @FindBy(how = How.CSS, using = "#user-dropdown-toggle > img")
    private WebElement profileIcon;

    @FindBy(how = How.CSS, using = "#signout-button > button")
    private WebElement logOutButton;

    public GlobalNavBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String getHomeLink() {
        return homeLink.getAttribute("href");
    }

    public final String getHomeText() {
        return homeLinkText.getText();
    }

    public final String getNotificationsText() {
        return notificationsLinkText.getText();
    }

    public final String getNotificationsLink() {
        return notificationsLink.getAttribute("href");
    }

    public final String getMessagesText() {
        return messagesLinkText.getText();
    }

    public final String getMessagesLink() {
        return messagesLink.getAttribute("href");
    }

    public final String getTweetBtnText() {
        return tweetBtn.getText();
    }

    public final boolean isTweetBtnVisible() {
        return tweetBtn.isDisplayed();
    }

    public final String getSearchBoxPlaceholder() {
        return searchBox.getAttribute("placeholder");
    }

    public final boolean isSearchIconVisible() {
        return searchBoxIcon.isDisplayed();
    }

    public final boolean isSearchBoxVisible() {
        return searchBox.isDisplayed();
    }

    public final void logOut() {
        notificationsLink.click();
        logOutButton.click();
    }
}
