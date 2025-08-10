package testCases;

import org.testng.annotations.Test;


import data.LoadPropertiesAlreadyRegisterData;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import pages.*;

public class TestCase5 extends TestBase{

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] {"20223142@fue.edu.eg", "Tonyyy"}
	    };
	  }
	  
	  
	  @Test(dataProvider = "dp")
	  public void TestAlreadyRegisteredAcc(String email , String name) {
		  
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
		    registerpage.startSignup(name, email);
		    
		    //8. Verify error 'Email Address already exist!' is visible
		    Assert.assertTrue(registerpage.AlreadyRegisterMsg.isDisplayed());
		    
		  
		    
	  }
	  
	  
	  @Test
	  public void AlreadyRegisterTestProp() {
		  
		    String name  = LoadPropertiesAlreadyRegisterData.userData.getProperty("name");
		    String email = LoadPropertiesAlreadyRegisterData.userData.getProperty("email");
		  
			// Step 3: Assert home page is loaded
		    String expectedTitle = "Automation Exercise";
		    Assert.assertEquals(driver.getTitle(), expectedTitle);

		    // Step 4: Click 'Signup / Login'
		    HomePage homepage = new HomePage(driver);
		    homepage.openLoginPage();

		    // Step 5: Verify 'New User Signup!' is visible
		    RegisterPage registerpage = new RegisterPage(driver);
		    Assert.assertTrue(registerpage.newUserSignupMsg.isDisplayed());

		    // Step 6–7: Enter name and email, click signup
		    registerpage.startSignup(name, email);
		    
		    //8. Verify error 'Email Address already exist!' is visible
		    Assert.assertTrue(registerpage.AlreadyRegisterMsg.isDisplayed());

		    homepage.homeLink.click();
		  
	  }
	  
	  
	  
	  }
