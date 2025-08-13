package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase26 extends TestBase{

	@Test
    public void verifyScrollUpWithoutArrowButton() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        // Step 3: Verify home page is visible
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible!");

        // Step 4: Scroll down to bottom
        homePage.scrollToBottom();

        // Step 5: Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(homePage.isSubscriptionVisible(), "'SUBSCRIPTION' section is not visible!");

        // Step 6: Scroll up to top without clicking arrow
        homePage.scrollToTop();

        // Step 7: Verify top text is visible
        Assert.assertTrue(homePage.isTopTextVisible(),
                "'Full-Fledged practice website for Automation Engineers' text is not visible!");
    }
	
}
