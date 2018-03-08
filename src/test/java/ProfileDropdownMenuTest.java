import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GlobalNavBarPage;
import pages.LogInPage;
import pages.ProfileDropdownMenuPage;

public class ProfileDropdownMenuTest extends BaseTest {
    private ProfileDropdownMenuPage profileDropdownMenuPage;

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
}
