package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;

public class TestCase25 extends TestBase{
    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDown() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        // Step 3: Verify home page is visible
        Assert.assertTrue(homePage.isHomePageVisible());

        // Step 4: Scroll down to bottom
        homePage.scrollToBottom();

        // Step 5: Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(homePage.isSubscriptionVisible());

        // Step 6: Click on scroll up arrow
        homePage.clickScrollUpArrow();

        // Step 7: Verify top text is visible
        Assert.assertTrue(homePage.isTopTextVisible());
    }
}
