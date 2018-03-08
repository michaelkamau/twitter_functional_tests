import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.GlobalNavBarPage;
import pages.LogInPage;

public class GlobalNavBarTest extends BaseTest {
    private GlobalNavBarPage globalNavBarPage;
    private LogInPage logInPage;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        logInPage = new LogInPage(driver);
        globalNavBarPage = logInPage.login(validHandle, validPassword);
    }

    @Test
    public void canAccessHomeLink() {
        Assert.assertEquals(globalNavBarPage.getHomeText(), "Home");
        Assert.assertEquals(globalNavBarPage.getHomeLink(), BasePage.getBaseUrl());
    }

    @Test
    public void canAccessNotificationsLink() {
        Assert.assertEquals(globalNavBarPage.getNotificationsText(), "Notifications");
        Assert.assertEquals(globalNavBarPage.getNotificationsLink(), BasePage.getNotificationsUrl());
    }

    @Test
    public void viewTweetBtn() {
        Assert.assertTrue(globalNavBarPage.isTweetBtnVisible());
        Assert.assertEquals(globalNavBarPage.getTweetBtnText(), "Tweet");
    }

    @Test
    public void viewMessagesText() {
        Assert.assertEquals(globalNavBarPage.getMessagesText(), "Messages");
    }

    @Test
    public void viewSearchBox() {
        Assert.assertTrue(globalNavBarPage.isSearchBoxVisible());
        Assert.assertEquals(globalNavBarPage.getSearchBoxPlaceholder(), "Search Twitter");
    }

    @Test
    public void viewTwitterHomeIconLink() {
        Assert.assertTrue(globalNavBarPage.isTwitterHomeIconVisible());
    }

}
