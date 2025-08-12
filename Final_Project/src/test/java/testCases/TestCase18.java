package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase18 extends TestBase{

    @Test
    public void verifyCategoryNavigation() {

        HomePage homePage = new HomePage(driver);

        // Step 3: Verify categories are visible
        Assert.assertTrue(homePage.CategoryLabel.isDisplayed());

        // Step 4 & 5: Click on 'Women' → 'Dress'
        homePage.openWomenCategoryAndClickTops();

        // Step 6: Verify Women category page
        Assert.assertTrue(homePage.TopsMsg.isDisplayed());

        // Step 7: Click on 'Men' → 'Tshirts'
        homePage.openMenCategoryAndClickTShirts();

        // Step 8: Verify Men category page
        Assert.assertTrue(homePage.TShirtsMsg.isDisplayed());
    }
}
