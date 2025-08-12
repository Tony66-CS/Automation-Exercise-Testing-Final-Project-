package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase10 extends TestBase{

	
	
	@DataProvider(name = "subscriptionEmails")
    public Object[][] subscriptionEmails() {
        return new Object[][]{
            {"test" + System.currentTimeMillis() + "@mail.com"}
            };
    }

    @Test(dataProvider = "subscriptionEmails")
    public void verifySubscriptionSuccess(String email) {
        HomePage homePage = new HomePage(driver);

        // Step 3: Verify home page is visible
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4: Scroll down to footer
        scrollToElement(homePage.Subscription);

        // Step 5: Verify text 'SUBSCRIPTION'
        Assert.assertTrue(homePage.Subscription.isDisplayed());

        // Step 6: Enter email address in input and click arrow button
        homePage.sendSubscribtionEmail(email);

        // Step 7: Verify success message
        Assert.assertTrue(homePage.SubscribtionMsg.isDisplayed());
    }
}
