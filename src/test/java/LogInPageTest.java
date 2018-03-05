import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInPageTest extends BaseTest {

    private LogInPage logInPage;

    private final String expectedUsernameLoginErrorMessage =
            "The username and password you entered did not match our records. Please double-check and try again.";
    private final String expectedEmailLoginErrorMessage =
            "The email and password you entered did not match our records. Please double-check and try again.";

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

    @Test
    public void invalidEmailValidPasswordFailsLogIn(){
        attemptUsernameLoginTest(invalidEmail, validPassword);
    }

    @Test
    public void invalidEmailInvalidPasswordFailsLogin(){
        attemptUsernameLoginTest(invalidEmail, invalidPassword);
    }

    @Test
    public void validEmailInvalidPasswordFailsLogin(){
        attemptEmailLoginTest(validEmail, invalidPassword);
    }

    @Test
    public void emptyCredentialsFailsLogin(){
        attemptUsernameLoginTest("", "");
    }

    @Test
    public void invalidHandleInvalidPasswordFailsLogin(){
        attemptUsernameLoginTest(invalidHandle, invalidPassword);
    }

    @Test
    public void invalidHandleValidPasswordFailsLogin(){
        attemptUsernameLoginTest(invalidHandle, validPassword);
    }

    @Test
    public void validHandleInvalidPasswordFailsLogin(){
        attemptUsernameLoginTest(validHandle, invalidPassword);
    }

}