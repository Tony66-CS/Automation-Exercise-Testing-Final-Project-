package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestCase7 extends TestBase{
	@Test
    public void verifyTestCasesNavigation() {
        // Step 3: Verify home page is visible successfully
        HomePage homePage = new HomePage(driver);
        TestCasesPage TCpage = new TestCasesPage(driver);
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4: Click on 'Test Cases' button
        homePage.openTestCasesPage();
        
        // Verify user is navigated to test cases page successfully
        String expectedUrl = "https://automationexercise.com/test_cases";
        Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl));
        Assert.assertTrue(TCpage.TestCasesMsg.isDisplayed());
    }
}
