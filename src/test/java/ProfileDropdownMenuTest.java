import org.testng.annotations.BeforeClass;
import pages.GlobalNavBarPage;
import pages.LogInPage;
import pages.ProfileDropdownMenuPage;

public class ProfileDropdownMenuTest extends BaseTest {
    private GlobalNavBarPage globalNavBarPage;
    private LogInPage logInPage;
    private ProfileDropdownMenuPage profileDropdownMenuPage;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        logInPage = new LogInPage(driver);
        globalNavBarPage = logInPage.login(validHandle, validPassword);
        profileDropdownMenuPage = globalNavBarPage.openProfileDropDownMenu();
    }
}
