package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfileDropdownMenuPage extends BasePage {
    private final WebDriver driver;
    @FindBy(how = How.CSS, using = "b.fullname")
    private WebElement name;
    @FindBy(how = How.CSS, using = ".name > span:nth-child(1)")
    private WebElement twitterHandle;
    @FindBy(how = How.CSS, using = "li.current-user:nth-child(3) > a:nth-child(1)")
    private WebElement profileMenuLink;
    @FindBy(how = How.CSS, using = ".DashUserDropdown > ul:nth-child(3) > li:nth-child(4) > a:nth-child(1)")
    private WebElement listsMenuLink;
    @FindBy(how = How.CSS, using = ".DashUserDropdown > ul:nth-child(3) > li:nth-child(5) > a:nth-child(1)")
    private WebElement momentsMenuLink;
    @FindBy(how = How.CSS, using = ".DashUserDropdown > ul:nth-child(3) > li:nth-child(7) > a:nth-child(1)")
    private WebElement twitterAdsMenuLink;
    @FindBy(how = How.CSS, using = ".user-dropdown-analytics")
    private WebElement analyticsMenuLink;
    @FindBy(how = How.CSS, using = ".DashUserDropdown > ul:nth-child(3) > li:nth-child(10) > a:nth-child(1)")
    private WebElement settingsPrivacyMenuLink;
    @FindBy(how = How.CSS, using = ".DashUserDropdown > ul:nth-child(3) > li:nth-child(11) > a:nth-child(1)")
    private WebElement helpCenterMenuLink;
    @FindBy(how = How.CSS, using = ".js-keyboard-shortcut-trigger > button:nth-child(1)")
    private WebElement keyboardShortcutsButton;
    @FindBy(how = How.CSS, using = "#signout-button > button:nth-child(1)")
    private WebElement logoutBtn;
    @FindBy(how = How.CSS, using = "li.current-user:nth-child(15) > a:nth-child(1)")
    private WebElement nightModeMenuLink;

    public ProfileDropdownMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String getName() {
        return name.getText();
    }

    public final String getTwitterHandle() {
        return twitterHandle.getText();
    }

    public final String getProfileMenuLink() {
        return profileMenuLink.getAttribute("href");
    }

    public final String getProfileText() {
        return profileMenuLink.getText();
    }

    public final String getListsMenuLink() {
        return listsMenuLink.getAttribute("href");
    }

    public final String getListsText() {
        return listsMenuLink.getText();
    }

    public final String getMomentsMenuLink() {
        return momentsMenuLink.getAttribute("href");
    }

    public final String getMomentsText() {
        return momentsMenuLink.getText();
    }

    public final String getTwitterAdsLink() {
        return twitterAdsMenuLink.getAttribute("href");
    }

    public final String getTwitterAdsText() {
        return twitterAdsMenuLink.getText();
    }

    public final String getAnalyticsMenuLink() {
        return analyticsMenuLink.getAttribute("href");
    }

    public final String getAnalyticsText() {
        return analyticsMenuLink.getText();
    }

    public final String getSettingsPrivacyLink() {
        return settingsPrivacyMenuLink.getAttribute("href");
    }

    public final String getSettingsPrivacyText() {
        return settingsPrivacyMenuLink.getText();
    }

    public final String getHelpCenterMenuLink() {
        return helpCenterMenuLink.getAttribute("href");
    }

    public final String getHelpCenterText() {
        return helpCenterMenuLink.getText();
    }

    public final boolean isKeyboardShortcutsButtonVisible() {
        return keyboardShortcutsButton.isDisplayed();
    }

    public final KeyboardShortcutsPage openKeyboardShortcuts() {
        keyboardShortcutsButton.click();
        KeyboardShortcutsPage keyboardShortcutsPage = PageFactory.initElements(driver, KeyboardShortcutsPage.class);
        return keyboardShortcutsPage;
    }
}
