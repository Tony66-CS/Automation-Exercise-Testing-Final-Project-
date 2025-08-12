package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase16 extends TestBase{
 

    @Test
    public void placeOrderLoginBeforeCheckout() {
        // Step 1 & 2: Launch browser and navigate to URL
        driver.get("http://automationexercise.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed(), "Home page not visible");

        // Step 4: Click 'Signup / Login'
        homePage.openLoginPage();

        // Step 5: Login with existing credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("antoinemageud@icloud.com", "111");

        // Step 6: Verify 'Logged in as username'
        UserHomePage userHomePage = new UserHomePage(driver);
        Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed(), "Login message not visible");

        // Step 7: Add products to cart
        homePage.openProductPage();
        ProductPage productsPage = new ProductPage(driver);
        productsPage.hoverAndAddToCart(0);
        productsPage.clickContinueShopping();
        productsPage.hoverAndAddToCart2(1);
        productsPage.clickViewCart();

        // Step 8 & 9: Verify cart page
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.cartTitle.isDisplayed(), "Cart page not displayed");

        // Step 10: Proceed to checkout
        cartPage.clickproceed();

        // Step 11: Verify Address Details and Review Your Order
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details missing");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Order review missing");

        // Step 12: Enter description and place order
        checkoutPage.enterComment("Please handle with care");
        checkoutPage.clickPlaceOrder();

        // Step 13: Enter payment details
        checkoutPage.enterPaymentDetails("John Doe", "4111111111111111", "123", "12", "2025");

        // Step 14: Pay and Confirm Order
        checkoutPage.clickPayAndConfirm();

        // Step 15: Verify success message
        Assert.assertTrue(checkoutPage.isOrderSuccessMessageVisible(), "Order success message missing");

        // Step 16: Delete account
        userHomePage.DeleteAccount();

        // Step 17: Verify account deleted
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        Assert.assertTrue(accountDeletedPage.AccDeletedMsg.isDisplayed(), "Account deleted message missing");
        accountDeletedPage.ClickContinue();
    }
}
