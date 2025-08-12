package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase17 extends TestBase{

	@Test
    public void removeProductFromCart() {
        // Step 1 & 2: Launch browser and navigate to URL
        driver.get("http://automationexercise.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.featuresItemsHeader.isDisplayed());

        // Step 4: Add products to cart
        homePage.openProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.hoverAndAddToCart(0);
        productPage.clickViewCart();

        // Step 5 & 6: Verify cart page is displayed
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.cartTitle.isDisplayed());

        // Step 7: Click 'X' button to remove a product
        cartPage.removeProduct(0); 
        cartPage.waitForEmptyCart();

        // Step 8: Verify that product is removed from the cart
        Assert.assertTrue(cartPage.CartisEmpty.isDisplayed());
    }
}
