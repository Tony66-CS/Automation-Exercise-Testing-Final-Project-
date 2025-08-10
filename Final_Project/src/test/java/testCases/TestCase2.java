package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pages.*;

public class TestCase2 extends TestBase{

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "antoinemageud@icloud.com", "111" },
    };
  }
  
  @Test(dataProvider = "dp")
  public void LoginCorrectEmailPassword(String email, String password) {
	  
	// Page Objects
      HomePage homePage = new HomePage(driver);
      LoginPage loginPage = new LoginPage(driver);
      UserHomePage userHomePage = new UserHomePage(driver);
      AccountDeletedPage AccDel = new AccountDeletedPage(driver);

      // Step 3: Verify home page is visible
      Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

      // Step 4: Click on 'Signup / Login'
      homePage.openLoginPage();

      // Step 5: Verify 'Login to your account' is visible
      Assert.assertTrue(loginPage.loginMsg.isDisplayed());

      // Step 6 & 7: Enter correct email and password, click 'login'
      loginPage.Login(email, password);

      // Step 8: Verify 'Logged in as username' is visible
      Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed());

      // Step 9: Click 'Delete Account'
      userHomePage.DeleteAccount();

      // Step 10: Verify 'ACCOUNT DELETED!' is visible
      Assert.assertTrue(AccDel.AccDeletedMsg.isDisplayed());
	  
  }

}
