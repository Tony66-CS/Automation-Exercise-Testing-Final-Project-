package testCases;


import pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
            { "wrongemail" + System.currentTimeMillis() + "@test.com", "wrongpass" + System.currentTimeMillis() }
            
        };
    }

    @Test(dataProvider = "invalidCredentials", description = "Login User with incorrect email and password")
    public void loginUserWithIncorrectEmailAndPassword(String email, String password) {
        // Step 1: Go to homepage
        driver.get("http://automationexercise.com");

        // Step 2: Verify that home page is visible
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        
        
        
        
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(email, password);
        // Step 4: Verify 'Login to your account' is visible
        Assert.assertTrue(
               
               loginPage.loginMsg.isDisplayed()
        );

        
       

        // Step 6: Verify error message
        
        Assert.assertTrue(
               
              loginPage.loginfailedmsg.isDisplayed()
        );
    }
}
