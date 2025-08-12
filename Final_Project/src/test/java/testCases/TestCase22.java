package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase22 extends TestBase{
	@Test
    public void testAddRecommendedItemToCart() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 3: Scroll to bottom
        homePage.scrollToRecommendedItems();

        // Step 4: Verify 'RECOMMENDED ITEMS' are visible
        Assert.assertTrue(homePage.isRecommendedItemsVisible());

        // Step 5: Click Add To Cart
        homePage.clickAddToCartRecommended();

        // Step 6: Click View Cart
        homePage.clickViewCart();

        // Step 7: Verify product is in cart (using partial match for product name)
        Assert.assertTrue(cartPage.isProductInCartt("Blue Top"));
    }
}
