package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import pages.*;

public class TestCase11 extends TestBase{
	@DataProvider(name = "subscriptionEmailsCart")
    public Object[][] subscriptionEmailsCart() {
        return new Object[][]{
            {"cart" + System.currentTimeMillis() + "@mail.com"},
        };
    }

    @Test(dataProvider = "subscriptionEmailsCart")
    public void verifyCartPageSubscription(String email) {
        HomePage homePage = new HomePage(driver);

        // Step 3: Verify home page is visible
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4: Click 'Cart' button
        homePage.openCartPage();

        // Step 5: Scroll down to footer
        scrollToElement(homePage.Subscription);

        // Step 6: Verify text 'SUBSCRIPTION'
        Assert.assertTrue(homePage.Subscription.isDisplayed());

        // Step 7: Enter email and click subscribe
        homePage.sendSubscribtionEmail(email);

        // Step 8: Verify success message
        Assert.assertTrue(homePage.SubscribtionMsg.isDisplayed());
    }
}
