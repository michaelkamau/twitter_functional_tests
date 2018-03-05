import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GlobalNavBarPage;
import pages.LogInPage;

public class LogInPageTest extends BaseTest {

    private LogInPage logInPage;

    private final String expectedUsernameLoginErrorMessage =
            "The username and password you entered did not match our records. " +
                    "Please double-check and try again.";
    private final String expectedEmailLoginErrorMessage =
            "The email and password you entered did not match our records. " +
                    "Please double-check and try again.";

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        logInPage = new LogInPage(driver);
    }

    private void attemptUsernameLoginTest(final String identifier, final String password){
        logInPage.login(identifier, password);
        String errorMessage = logInPage.getLoginErrorMessage();
        Assert.assertEquals(errorMessage, expectedUsernameLoginErrorMessage);
        logInPage.dismissLoginErrorPopup();
    }

    private void attemptEmailLoginTest(final String identifier, final String password){
        logInPage.login(identifier, password);
        String errorMessage = logInPage.getLoginErrorMessage();
        Assert.assertEquals(errorMessage, expectedEmailLoginErrorMessage);
        logInPage.dismissLoginErrorPopup();
    }

    @Test(groups = {"invalidLogin"})
    public void invalidEmailValidPasswordFailsLogIn(){
        attemptUsernameLoginTest(invalidEmail, validPassword);
    }

    @Test(groups = {"invalidLogin"})
    public void invalidEmailInvalidPasswordFailsLogin(){
        attemptUsernameLoginTest(invalidEmail, invalidPassword);
    }

    @Test(groups = {"invalidLogin"})
    public void validEmailInvalidPasswordFailsLogin(){
        attemptEmailLoginTest(validEmail, invalidPassword);
    }

    @Test(groups = {"invalidLogin"})
    public void emptyCredentialsFailsLogin(){
        attemptUsernameLoginTest("", "");
    }

    @Test(groups = {"invalidLogin"})
    public void invalidHandleInvalidPasswordFailsLogin(){
        attemptUsernameLoginTest(invalidHandle, invalidPassword);
    }

    @Test(groups = {"invalidLogin"})
    public void invalidHandleValidPasswordFailsLogin(){
        attemptUsernameLoginTest(invalidHandle, validPassword);
    }

    @Test(groups = {"invalidLogin"})
    public void validHandleInvalidPasswordFailsLogin(){
        attemptUsernameLoginTest(validHandle, invalidPassword);
    }

    private void validLoginTest(final String identifier) {
        GlobalNavBarPage globalNavBarPage;
        globalNavBarPage = logInPage.login(identifier, validPassword);
        Assert.assertEquals(globalNavBarPage.getHomeLinkText(), "Home");
        globalNavBarPage.logOut();
    }

    @Test(dependsOnGroups = {"invalidLogin"}, alwaysRun = true)
    public void validHandleValidPasswordLogsIn() {
        validLoginTest(validHandle);
    }

    @Test(dependsOnGroups = {"invalidLogin"}, alwaysRun = true)
    public void validEmailValidPasswordLogsIn() {
        validLoginTest(validEmail);
    }

}
