package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import pages.*;

public class TestCase24 extends TestBase {

    @DataProvider(name = "userDetails")
    public Object[][] getUserDetails() {
        return new Object[][]{
            { 1, "John", "testuser" + System.currentTimeMillis() + "@mail.com", "TestPass123!", "15", "March", "1990",
              "Doe", "Test Company", "123 Main Street", "Apt 4B", "United States",
              "New York", "NY", "10001", "5551234567"}
        };
    }

    @Test(dataProvider = "userDetails")
    public void verifyCompleteOrderFlow(Integer num, String name, String email, String pass, String day, String month, String yr,
               String lName, String comp, String addr1, String addr2, String country,
               String st, String city, String zipcode, String mobileNum) {
        
        HomePage homePage = new HomePage(driver);
        ProductPage productsPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        UserHomePage userHomePage = new UserHomePage(driver);
        AccountDeletedPage accountDeleted = new AccountDeletedPage(driver);

        // Step 1-3: Launch browser, navigate to site, verify homepage
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed(), "Home page not visible successfully");

        // Step 4: Add products to cart
        homePage.openProductPage();
        
        // Add debug information
        productsPage.printProductDebugInfo();
        
        // Add first product to cart
        productsPage.hoverAndAddToCart(0); // Add first product to cart
        productsPage.clickContinueShopping();
        
        // Add another product to cart
        productsPage.hoverAndAddToCart(1);
        productsPage.clickViewCart();

        // Step 5-6: Click 'Cart' button and verify cart page
        Assert.assertTrue(cartPage.getProductCount() > 0, "Cart page should display products");

        // Step 7: Click 'Register / Login' button (from cart page)
        // First we need to trigger the modal by trying to proceed to checkout
        cartPage.clickproceed();
        
        // Now the Register/Login modal should be visible
        cartPage.clickRegister();

        // Step 9: Fill all details in Signup and create account
        registerPage.startSignup(name, email);
        registerPage.fillAccountDetails(pass, day, month, yr, name, lName, comp, addr1, 
                addr2 + num, country + num, st, city, zipcode, mobileNum);

        // Step 10: Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(accountCreated.accountCreatedMessage.isDisplayed(), "Account creation message should be displayed");
        accountCreated.clickContinue();

        // Step 11: Verify 'Logged in as username' at top
        Assert.assertTrue(userHomePage.loggedInAsMsg.isDisplayed(), "Logged in message should be displayed");

        // Step 12-13: Click 'Cart' button and 'Proceed To Checkout' button
        homePage.openCartPage();
        cartPage.clickproceed();

        // Step 14: Verify Address Details and Review Your Order
        String expectedDeliveryAddress = "YOUR DELIVERY ADDRESS\nMr. " + name + " " + lName + "\n" + comp + "\n" + addr1 + "\n" + addr2 + num + "\n" + city + " " + st + " " + zipcode + "\n" + country + "\n" + mobileNum;
        String expectedBillingAddress = "YOUR BILLING ADDRESS\nMr. " + name + " " + lName + "\n" + comp + "\n" + addr1 + "\n" + addr2 + num + "\n" + city + " " + st + " " + zipcode + "\n" + country + "\n" + mobileNum;
        
        String deliveryAddress = checkoutPage.getDeliveryAddress();
        String billingAddress = checkoutPage.getBillingAddress();

        Assert.assertEquals(deliveryAddress.trim(), expectedDeliveryAddress.trim(), "Delivery address mismatch!");
        Assert.assertEquals(billingAddress.trim(), expectedBillingAddress.trim(), "Billing address mismatch!");

        // Step 15: Enter description in comment text area and click 'Place Order'
        checkoutPage.enterOrderComment("This is a test order for automation testing purposes.");
        checkoutPage.clickPlaceOrder();

        // Step 16: Enter payment details
        checkoutPage.enterPaymentDetails("John Doe", "4111111111111111", "123", "12", "2025");

        // Step 17: Click 'Pay and Confirm Order' button
        checkoutPage.clickPayAndConfirmOrder();

        // Step 18: Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(checkoutPage.isOrderSuccessMessageDisplayed(), "Order success message should be displayed");

        // Step 19: Click 'Download Invoice' button and verify invoice is downloaded successfully
        checkoutPage.clickDownloadInvoice();
        // Note: File download verification would require additional setup in the test framework

        // Step 20: Click 'Continue' button
        checkoutPage.clickContinueAfterOrder();

        // Step 21: Click 'Delete Account' button
        userHomePage.DeleteAccount();

        // Step 22: Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(accountDeleted.AccDeletedMsg.isDisplayed(), "Account deletion message should be displayed");
        accountDeleted.ClickContinue();
    }
}
