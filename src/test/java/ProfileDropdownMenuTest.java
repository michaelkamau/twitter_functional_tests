import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class ProfileDropdownMenuTest extends BaseTest {
    private ProfileDropdownMenuPage profileDropdownMenuPage;
    private final String PROFILE_LINK = BasePage.getBaseUrl() + validHandle;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        LogInPage logInPage = new LogInPage(driver);
        GlobalNavBarPage globalNavBarPage = logInPage.login(validHandle, validPassword);
        profileDropdownMenuPage = globalNavBarPage.openProfileDropDownMenu();
    }

    @Test
    public void viewName() {
        Assert.assertEquals(profileDropdownMenuPage.getName(), twitterFullName);
    }

    @Test
    public void viewTwitterHandle() {
        Assert.assertEquals(profileDropdownMenuPage.getTwitterHandle(), "@" + validHandle);
    }

    @Test
    public void viewProfileMenuLink() {
        final String expectedProfileMenuLink = PROFILE_LINK;
        Assert.assertEquals(profileDropdownMenuPage.getProfileMenuLink(), expectedProfileMenuLink);
        Assert.assertEquals(profileDropdownMenuPage.getProfileText(), "Profile");
    }

    @Test
    public void viewListsMenuLink() {
        final String expectedListsMenuLink = PROFILE_LINK + "/lists";
        Assert.assertEquals(profileDropdownMenuPage.getListsMenuLink(), expectedListsMenuLink);
        Assert.assertEquals(profileDropdownMenuPage.getListsText(), "Lists");
    }

    @Test
    public void viewMomentsMenuLink() {
        final String expectedMomentsMenuLink = PROFILE_LINK + "/moments";
        Assert.assertEquals(profileDropdownMenuPage.getMomentsMenuLink(), expectedMomentsMenuLink);
        Assert.assertEquals(profileDropdownMenuPage.getMomentsText(), "Moments");
    }

    @Test
    public void viewTwitterAdsMenuLink() {
        final String expectedTwitterAdsLink = "https://ads.twitter.com/?ref=gl-tw-tw-twitter-ads";
        Assert.assertEquals(profileDropdownMenuPage.getTwitterAdsLink(), expectedTwitterAdsLink);
        Assert.assertEquals(profileDropdownMenuPage.getTwitterAdsText(), "Twitter Ads");
    }

    @Test
    public void viewAnalyticsMenuLink() {
        final String expectedAnalyticsLink = "https://analytics.twitter.com/";
        Assert.assertEquals(profileDropdownMenuPage.getAnalyticsMenuLink(), expectedAnalyticsLink);
        Assert.assertEquals(profileDropdownMenuPage.getAnalyticsText(), "Analytics");
    }

    @Test
    public void viewSettingsPrivacyMenuLink() {
        final String expectedSettingsLink = BasePage.getBaseUrl() + "settings";
        Assert.assertEquals(profileDropdownMenuPage.getSettingsPrivacyLink(), expectedSettingsLink);
        Assert.assertEquals(profileDropdownMenuPage.getSettingsPrivacyText(), "Settings and privacy");
    }

    @Test
    public void viewHelpCenterMenuLink() {
        final String expectedHelpCenterMenuLink = "https://support.twitter.com/";
        Assert.assertEquals(profileDropdownMenuPage.getHelpCenterMenuLink(), expectedHelpCenterMenuLink);
        Assert.assertEquals(profileDropdownMenuPage.getHelpCenterText(), "Help Center");
    }

    @Test
    public void accessKeyboardShortcuts() {
        Assert.assertTrue(profileDropdownMenuPage.isKeyboardShortcutsButtonVisible());
        KeyboardShortcutsPage keyboardShortcutsPage = profileDropdownMenuPage.openKeyboardShortcuts();
        Assert.assertTrue(keyboardShortcutsPage.isKeyboardShortcutsDialogDisplayed());
    }

    @Test
    public void viewNightModeToggle() {
        Assert.assertEquals(profileDropdownMenuPage.getNightModeText(), "Night mode");
    }

    @Test
    public void logOut() {
        LandingPage landingPage = profileDropdownMenuPage.logOut();
        String expectedLogoutUrl = BasePage.getBaseUrl() + "?logged_out=1&lang=en";
        Assert.assertEquals(landingPage.getLoggedOutUrl(), expectedLogoutUrl);
    }
}
