import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.TweetBoxPage;

public class TweetBoxTest extends BaseTest {

    private LogInPage logInPage;
    private TweetBoxPage tweetBoxPage;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        logInPage = new LogInPage(driver);
        logInPage.login(validHandle, validPassword);
        tweetBoxPage = PageFactory.initElements(driver, TweetBoxPage.class);
        tweetBoxPage.expandBox();
    }

    @Test
    public void viewTweetBox() {
        Assert.assertTrue(tweetBoxPage.isTweetBoxDisplayed());
        final String expectedPlaceholder = "What’s happening?";
        Assert.assertEquals(tweetBoxPage.getDefaultPlaceholderText(), expectedPlaceholder);
    }

    @Test
    public void tweetButtonDisabledWithEmptyTweet() {
        Assert.assertTrue(tweetBoxPage.isTweetButtonDisabled());
    }

    @Test
    public void addExtraTweetButtonDisabledWithEmptyTweet() {
        Assert.assertTrue(tweetBoxPage.isAddExtraTweetBtnDisabled());
    }

    @Test
    public void viewAttachMediaButton() {
        Assert.assertTrue(tweetBoxPage.isAttachMediaBtnVisible());
        // This is failing for some unknown reason
        final String expectedAttachMediaTooltip = "Add photos or video";
        Assert.assertEquals(tweetBoxPage.getAttachMediaTooltip(), expectedAttachMediaTooltip);
    }

    @Test
    public void viewAttachGIFButton() {
        Assert.assertTrue(tweetBoxPage.isAttachGIFBtnDisplayed());
        final String expectedAttachGIFTooltip = "Add a GIF";
        Assert.assertEquals(tweetBoxPage.getAttachGIFTooltip(), expectedAttachGIFTooltip);
    }
}
