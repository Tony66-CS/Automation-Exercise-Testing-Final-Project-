package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase14 extends TestBase{
	@DataProvider
	 public Object[][] dp() {
		return new Object[][] {
	      new Object[] { 1, "Antwan", "Passfares1234!", "22", "June", "2003",
	    	      "test", "FUE",
	    	      "10 BahaaElDin", "Apart1 ", "United States",
	    	      "Miami", "Florida", "19991", "01273585296"}};
	    }

	@Test(dataProvider = "dp")
	public void placeOrderRegisterWhileCheckout(Integer num, String name, String pass, String day, String month, String yr,
			   String lName, String comp, String addr1, String addr2, String country,
			   String st, String city, String zipcode, String mobileNum) {
	    // Step 1 & 2: Launch browser and navigate to URL
	    driver.get("http://automationexercise.com");
	    
	    HomePage homePage = new HomePage(driver);
	    Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

	    // Step 4: Add products to cart
	    homePage.openProductPage();
	    ProductPage productsPage = new ProductPage(driver);
	    productsPage.hoverAndAddToCart(0);
	    productsPage.clickContinueShopping();
	    productsPage.hoverAndAddToCart2(1);
	    productsPage.clickViewCart();

	    // Step 5 & 6: Verify cart page is displayed
	    CartPage cartPage = new CartPage(driver);
	    Assert.assertTrue(cartPage.cartTitle.isDisplayed());

	    // Step 7: Proceed to checkout
	    cartPage.clickproceed();

	    // Step 8: Click Register / Login
	    cartPage.clickRegister();

	    // Step 9: Fill details in Signup and create account
	    RegisterPage registerPage = new RegisterPage(driver);
	    registerPage.startSignup("tonyyyyyyyyyyyy", "jklh@fakeuiy.com");

	    registerPage.fillAccountDetails(pass, day, month, yr, name, lName, comp, addr1, 
	    								addr2+num, country+num, st, city,  zipcode, mobileNum);
	    // Step 10: Verify ACCOUNT CREATED
	    AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
	    Assert.assertTrue(accountCreatedPage.accountCreatedMessage.isDisplayed());
	    accountCreatedPage.clickContinue();

	    // Step 11: Verify Logged in as username
	    UserHomePage userHomePage = new UserHomePage(driver);
	    Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed());

	    // Step 12: Click Cart button again
	    homePage.openCartPage();

	    // Step 13: Proceed to Checkout
	    cartPage.clickproceed();

	    // Step 14: Verify Address Details and Review Your Order
	    CheckoutPage checkoutPage = new CheckoutPage(driver);
	    Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details missing");
	    Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Order review missing");

	    // Step 15: Enter description in comment and place order
	    checkoutPage.enterComment("Please handle with care");
	    checkoutPage.clickPlaceOrder();

	    // Step 16: Enter payment details
	    checkoutPage.enterPaymentDetails("John Doe", "4111111111111111", "123", "12", "2025");

	    // Step 17: Pay and Confirm Order
	    checkoutPage.clickPayAndConfirm();

	    // Step 18: Verify success message
	    Assert.assertTrue(checkoutPage.isOrderSuccessMessageVisible(), "Order success message missing");

	    // Step 19: Delete Account
	    userHomePage.DeleteAccount();

	    // Step 20: Verify ACCOUNT DELETED
	    AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
	    Assert.assertTrue(accountDeletedPage.AccDeletedMsg.isDisplayed());
	    accountDeletedPage.ClickContinue();
	}
}
