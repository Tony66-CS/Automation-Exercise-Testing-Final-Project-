package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase12 extends TestBase{

	@Test
	public void testAddTwoProductsToCart() {
	    HomePage homePage = new HomePage(driver);
	    ProductPage productPage = new ProductPage(driver);
	    CartPage cartPage = new CartPage(driver);

	    // Step 3 - Verify home page visible
	    Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

	    // Step 4 - Click on Products
	    homePage.openProductPage();
	    productPage.waitForAllProducts();

	    // Step 5 - Hover over first product and click 'Add to cart'
	    productPage.hoverAndAddToCart(0);

	    // Step 6 - Click 'Continue Shopping'
	    productPage.clickContinueShopping();

	    // Step 7 - Hover over second product and click 'Add to cart'
	    productPage.hoverAndAddToCart2(1);

	    // Step 8 - Click 'View Cart'
	    productPage.clickViewCart();

	    // Step 9 - Verify two products in cart
	    Assert.assertEquals(cartPage.getProductCount(), 2);

	    // Step 10 - Verify product details
	    for (int i = 0; i < cartPage.getProductCount(); i++) {
	        String price = cartPage.getProductPrice(i);
	        String quantity = cartPage.getProductQuantity(i);
	        String total = cartPage.getProductTotal(i);

	        Assert.assertTrue(price.contains("Rs."), "Invalid price format for product " + (i + 1));
	        Assert.assertTrue(Integer.parseInt(quantity) > 0, "Quantity should be > 0 for product " + (i + 1));

	        int expectedTotal = Integer.parseInt(price.replace("Rs.", "").trim()) *
	                            Integer.parseInt(quantity.trim());
	        
	        int actualTotal = Integer.parseInt(total.replace("Rs.", "").trim());

	        Assert.assertEquals(actualTotal, expectedTotal);
	    }
	}
	
}
