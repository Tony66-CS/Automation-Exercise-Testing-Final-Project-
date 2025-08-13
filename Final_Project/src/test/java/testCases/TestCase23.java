package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase23 extends TestBase{

	@DataProvider(name = "userDetails")
	public Object[][] getUserDetails() {
	    return new Object[][]{
	    { 1, "Antwan", "testuser" + System.currentTimeMillis() + "@mail.com","Passfares1234!", "22", "June", "2003",
	      "test", "FUE","10 BahaaElDin", "Apart1 ", "United States",
	      "Miami", "Florida", "19991", "01273585296"}
	    };
	}
	
	@Test(dataProvider = "userDetails")
	public void verifyAddressDetailsInCheckout(Integer num, String name,String email, String pass, String day, String month, String yr,
			   String lName, String comp, String addr1, String addr2, String country,
			   String st, String city, String zipcode, String mobileNum) {
		
		HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage Registerpage = new RegisterPage(driver);
        ProductPage productsPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        UserHomePage accountPage = new UserHomePage(driver);
        AccountCreatedPage Acccreated = new AccountCreatedPage(driver);
		AccountDeletedPage Accdeleted = new AccountDeletedPage(driver);
		
		
		
	    // Step 1-3: Launch browser, go to site, verify homepage
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed(), "Home page not visible");

	    // Step 4: Go to Signup/Login
	    homePage.openLoginPage();

	    // Step 5-6: Fill Signup details and create account
	    Registerpage.startSignup(name, email);
	    Registerpage.fillAccountDetails(pass, day, month, yr, name, lName, comp, addr1, 
				addr2+num, country+num, st, city,  zipcode, mobileNum);
	    Assert.assertTrue(Acccreated.accountCreatedMessage.isDisplayed());
	    Acccreated.clickContinue();
	    
	    // Step 7: Verify "Logged in as" text
	    Assert.assertTrue(accountPage.loggedInAsMsg.isDisplayed());
	    
	    // Step 8: Add product(s) to cart
	    homePage.openProductPage();
	    productsPage.hoverAndAddToCart(0);
	    productsPage.clickViewCart();

	    // Step 9-10: Verify cart page
	    cartPage.waitForCartPage();
	    Assert.assertTrue(cartPage.getProductCount() > 0, "Cart is empty!");

	    // Step 11: Proceed to checkout
	    cartPage.clickproceed();

	    // Step 12-13: Verify addresses
	    String expectedDeliveryAddress = "YOUR DELIVERY ADDRESS\nMr. " + name + " " + lName + "\n" + comp + "\n" + addr1 + "\n" + addr2 + num + "\n" + city + " " + st + " " + zipcode + "\n" + country + "\n" + mobileNum;
	    String expectedBillingAddress = "YOUR BILLING ADDRESS\nMr. " + name + " " + lName + "\n" + comp + "\n" + addr1 + "\n" + addr2 + num + "\n" + city + " " + st + " " + zipcode + "\n" + country + "\n" + mobileNum;
	    
	    String deliveryAddress = checkoutPage.getDeliveryAddress();
	    String billingAddress = checkoutPage.getBillingAddress();

	    Assert.assertEquals(deliveryAddress.trim(), expectedDeliveryAddress.trim(), "Delivery address mismatch!");
	    Assert.assertEquals(billingAddress.trim(), expectedBillingAddress.trim(), "Billing address mismatch!");

	    // Step 14: Delete account
	    accountPage.DeleteAccount();

	    // Step 15: Verify account deleted

	    Assert.assertTrue(Accdeleted.AccDeletedMsg.isDisplayed());
	}

}
