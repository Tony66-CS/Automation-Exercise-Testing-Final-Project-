package testCases;

import org.testng.annotations.Test;


import data.LoadPropertiesRegisterData;
import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase1 extends TestBase{
	@DataProvider
	 public Object[][] dp() {
		return new Object[][] {
	      new Object[] { 1, "Antwan", "Passfares1234!", "22", "June", "2003",
	    	      "test", "FUE",
	    	      "10 BahaaElDin", "Apart1 ", "United States",
	    	      "Miami", "Florida", "19991", "01273585296" },
	      new Object[] { 2, "Fares", "Passotony1234!", "22", "June", "2003",
	    	      "test", "FUE", "10 BahaaElDin", "Apart1 ", "United States",
	    	      "California", "Los Angeles", "19991", "01273585296" },};
	    }

	  @Test(dataProvider = "dp")
	  public void testRegister(Integer num, String name, String pass, String day, String month, String yr,
			  				   String lName, String comp, String addr1, String addr2, String country,
			  				   String st, String city, String zipcode, String mobileNum){
		  
		  
	    driver.get("https://automationexercise.com");


	    
	    // Step 3: Assert home page is loaded
	    String expected = "Automation Exercise";
	    Assert.assertEquals(driver.getTitle(), expected);

	    // Step 4: Click 'Signup / Login'
	    HomePage homepage = new HomePage(driver);
	    homepage.openLoginPage();

	    // Step 5: Verify 'New User Signup!' is visible
	    RegisterPage registerpage = new RegisterPage(driver);
	    Assert.assertTrue(registerpage.newUserSignupMsg.isDisplayed());

	    // Step 6–7: Enter name and email, click signup
	    String email = "user" + num + System.currentTimeMillis() + "@mail.com";
	    registerpage.startSignup(name, email);

	    // Step 8: Verify 'ENTER ACCOUNT INFORMATION' is visible
	    Assert.assertTrue(registerpage.enterAccountInfoMessage.isDisplayed());

	    // Step 9–13: Fill account info
	    registerpage.fillAccountDetails(pass, day, month, yr, name, lName, comp, addr1, 
	    								addr2+num, country+num, st, city,  zipcode, mobileNum);
	    
	    AccountCreatedPage createdpage = new AccountCreatedPage(driver);
	    
	    // Step 14: Verify 'ACCOUNT CREATED!' is visible
	    Assert.assertTrue(createdpage.accountCreatedMessage.isDisplayed());

	    // Step 15: Click 'Continue'
	    createdpage.clickContinue();

	    // Step 16: Verify 'Logged in as username' is visible
	    UserHomePage userHomePage = new UserHomePage(driver);
	    Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed());

	    // Step 17: Click 'Delete Account'
	    userHomePage.DeleteAccount();

	    // Step 18: Verify 'ACCOUNT DELETED!' is visible and click continue
	    AccountDeletedPage deletedpage = new AccountDeletedPage(driver);
	    Assert.assertTrue(deletedpage.AccDeletedMsg.isDisplayed());
	    deletedpage.ClickContinue();
	    
	  }

	@Test
		  public void RunTestUsingProp() {
				
			    String num = LoadPropertiesRegisterData.userData.getProperty("n");
			    String name = LoadPropertiesRegisterData.userData.getProperty("name");
			    String pass = LoadPropertiesRegisterData.userData.getProperty("password");
			    String day = LoadPropertiesRegisterData.userData.getProperty("day");
			    String month = LoadPropertiesRegisterData.userData.getProperty("month");
			    String yr = LoadPropertiesRegisterData.userData.getProperty("year");
			    String lName = LoadPropertiesRegisterData.userData.getProperty("lastname");
			    String comp = LoadPropertiesRegisterData.userData.getProperty("company");
			    String addr = LoadPropertiesRegisterData.userData.getProperty("address");
			    String addr2 = LoadPropertiesRegisterData.userData.getProperty("address2");
			    String country = LoadPropertiesRegisterData.userData.getProperty("contry");
			    String st = LoadPropertiesRegisterData.userData.getProperty("state");
			    String city = LoadPropertiesRegisterData.userData.getProperty("city");
			    String zipcode = LoadPropertiesRegisterData.userData.getProperty("zipcode");
			    String mobileNum = LoadPropertiesRegisterData.userData.getProperty("mobile");

			    driver.get("https://automationexercise.com");


			    
			    // Step 3: Assert home page is loaded
			    String expectedTitle = "Automation Exercise";
			    Assert.assertEquals(driver.getTitle(), expectedTitle);

			    // Step 4: Click 'Signup / Login'
			    HomePage homePage = new HomePage(driver);
			    homePage.openLoginPage();

			    // Step 5: Verify 'New User Signup!' is visible
			    RegisterPage registerPage = new RegisterPage(driver);
			    Assert.assertTrue(registerPage.newUserSignupMsg.isDisplayed());

			    // Step 6–7: Enter name and email, click signup
			    String email = "user" + num + System.currentTimeMillis() + "@mail.com";
			    registerPage.startSignup(name, email);

			    // Step 8: Verify 'ENTER ACCOUNT INFORMATION' is visible
			    Assert.assertTrue(registerPage.enterAccountInfoMessage.isDisplayed());

			    // Step 9–13: Fill account info
			    registerPage.fillAccountDetails(pass, day, month, yr,
		                						name, lName, comp,
		                						addr, addr2+num, country+num,
		                						st, city,  zipcode, mobileNum);
			    
			    AccountCreatedPage createdpage = new AccountCreatedPage(driver);
			    
			    // Step 14: Verify 'ACCOUNT CREATED!' is visible
			    Assert.assertTrue(createdpage.accountCreatedMessage.isDisplayed());

			    // Step 15: Click 'Continue'
			    createdpage.clickContinue();

			    
			    // Step 16: Verify 'Logged in as username' is visible
			    UserHomePage userHomePage = new UserHomePage(driver);
			    Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed());

			    // Step 17: Click 'Delete Account'
			    userHomePage.DeleteAccount();

			    // Step 18: Verify 'ACCOUNT DELETED!' is visible and click continue
			    AccountDeletedPage deletedpage = new AccountDeletedPage(driver);
			    Assert.assertTrue(deletedpage.AccDeletedMsg.isDisplayed());
			    deletedpage.ClickContinue();
			    
			    
		  }


}
