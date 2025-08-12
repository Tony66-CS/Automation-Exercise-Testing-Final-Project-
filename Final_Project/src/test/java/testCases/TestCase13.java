package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase13 extends TestBase{
	@Test
    public void verifyProductQuantityInCart() {
        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailsPage = new ProductDetailPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 3 - Verify home page visible
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4 - Click 'View Product' for first product
        homePage.clickFirstViewProduct();

        // Step 5 - Verify product detail is opened
        Assert.assertTrue(productDetailsPage.condition.isDisplayed());
        Assert.assertTrue(productDetailsPage.availability.isDisplayed());
        Assert.assertTrue(productDetailsPage.category.isDisplayed());
        Assert.assertTrue(productDetailsPage.brand.isDisplayed());
        
        // Step 6 - Increase quantity to 4
        productDetailsPage.setProductQuantity("4");

        // Step 7 - Click 'Add to cart'
        productDetailsPage.clickAddToCart();

        // Step 8 - Click 'View Cart'
        productDetailsPage.clickViewCart();

        // Step 9 - Verify quantity in cart is exactly 4
        Assert.assertEquals(cartPage.getProductQuantity(0), "4");
    }
}
