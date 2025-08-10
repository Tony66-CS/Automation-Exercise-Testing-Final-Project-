package testCases;


import pages.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {

	@DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
            {"wrongEmail1@example.com", "wrongPass1"}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String email, String password) {
        // Step 3: Verify home page is visible successfully
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4: Click on 'Signup / Login'
        homePage.openLoginPage();

        // Step 5: Verify 'Login to your account' is visible
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.loginMsg.isDisplayed());

        // Step 6 & 7: Enter incorrect email/password and click 'login'
        loginPage.Login(email, password);

        // Step 8: Verify error message is visible
        Assert.assertTrue(loginPage.loginfailedmsg.isDisplayed());
    }
}
