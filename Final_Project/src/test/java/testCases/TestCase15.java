package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase15 extends TestBase{


    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { 1, "Antwan", "Passfares1234!", "22", "June", "2003",
                "test", "FUE",
                "10 BahaaElDin", "Apart1 ", "United States",
                "Miami", "Florida", "19991", "01273585296" }
        };
    }

    @Test(dataProvider = "dp")
    public void placeOrderRegisterBeforeCheckout(Integer num, String name, String pass, String day, String month, String yr,
                                                 String lName, String comp, String addr1, String addr2, String country,
                                                 String st, String city, String zipcode, String mobileNum) {

        // Step 1 & 2: Launch browser and navigate to URL
        driver.get("http://automationexercise.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed(), "Home page not visible");

        // Step 3: Click Signup / Login
        homePage.openLoginPage();

        // Step 4: Fill all details in Signup and create account
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.startSignup("tonyyyyyyyyyyyyioio", "jklh@fakeuiyjnninu.com");
        registerPage.fillAccountDetails(pass, day, month, yr, name, lName, comp, addr1,
                addr2 + num, country + num, st, city, zipcode, mobileNum);

        // Step 5: Verify ACCOUNT CREATED and click Continue
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPage.accountCreatedMessage.isDisplayed(), "Account not created");
        accountCreatedPage.clickContinue();

        // Step 6: Verify Logged in as username
        UserHomePage userHomePage = new UserHomePage(driver);
        Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed(), "'Logged in as' not visible");

        // Step 7: Add products to cart
        homePage.openProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.hoverAndAddToCart(0);
        productPage.clickContinueShopping();
        productPage.hoverAndAddToCart2(1);
        productPage.clickViewCart();

        // Step 8: Verify that cart page is displayed
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.cartTitle.isDisplayed(), "Cart page not visible");

        // Step 9: Click Proceed To Checkout
        cartPage.clickproceed();

        // Step 10: Verify Address Details and Review Your Order
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details missing");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Order review missing");

        // Step 11: Enter description in comment text area and click 'Place Order'
        checkoutPage.enterComment("Handle with care please");
        checkoutPage.clickPlaceOrder();

        // Step 12: Enter payment details
        checkoutPage.enterPaymentDetails("John Doe", "4111111111111111", "123", "12", "2025");

        // Step 13: Pay and Confirm Order
        checkoutPage.clickPayAndConfirm();

        // Step 14: Verify success message
        Assert.assertTrue(checkoutPage.isOrderSuccessMessageVisible(), "Order success message missing");

        // Step 15: Delete Account
        userHomePage.DeleteAccount();

        // Step 16: Verify ACCOUNT DELETED and click Continue
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        Assert.assertTrue(accountDeletedPage.AccDeletedMsg.isDisplayed(), "Account deleted message not found");
        accountDeletedPage.ClickContinue();
    }
	
}
