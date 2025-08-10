package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pages.*;

public class TestCase4 extends TestBase{

	@DataProvider(name = "validCredentials")
    public Object[][] validCredentials() {
        return new Object[][]{
            {"antoinemageud@icloud.com", "111"}
        };
    }

    @Test(dataProvider = "validCredentials")
    public void loginAndLogout(String email, String password) {
        // Step 3: Verify home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4: Click on 'Signup / Login'
        homePage.openLoginPage();

        // Step 5: Verify 'Login to your account' is visible
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.loginMsg.isDisplayed());

        // Step 6 & 7: Enter correct email and password, click 'login'
        loginPage.Login(email, password);

        // Step 8: Verify 'Logged in as username' is visible
        UserHomePage userHomePage = new UserHomePage(driver);
        Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed());

        // Step 9: Click 'Logout' button
        userHomePage.logout();

        // Step 10: Verify that user is navigated to login page
        Assert.assertTrue(loginPage.loginMsg.isDisplayed());
    }
    
}

