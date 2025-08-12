package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase20 extends TestBase{
    @DataProvider(name = "searchAndLoginData")
    public Object[][] getData() {
        return new Object[][]{
                {"Tshirt", "antoinemageud@icloud.com", "111"},
                //{"Dress", "antoinemageud@icloud.com", "111"}
        };
    }

    @Test(dataProvider = "searchAndLoginData")
    public void searchProductsAndVerifyCartAfterLogin(String productName, String email, String password) {
        HomePage homePage = new HomePage(driver);
        ProductPage productsPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Step 3: Click on 'Products' button
        homePage.openProductPage();

        // Step 4: Verify user is navigated to ALL PRODUCTS page
        Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());

        // Step 5: Search for product
        productsPage.enterSearchKeyword(productName);

        // Step 6: Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(productsPage.AllproductsMsg.isDisplayed());

        // Step 7: Verify all searched products are visible
        Assert.assertTrue(productsPage.areAllSearchResultsVisible());
        
        // Step 8: Add those products to cart
        productsPage.addAllSearchResultsToCart();

        // Step 9: Go to cart and verify products are visible
        homePage.openCartPage();
        Assert.assertTrue(cartPage.areProductsInCart(), "Products not found in cart before login");

        // Step 10: Click 'Signup / Login' and log in
        homePage.openLoginPage();
        loginPage.Login(email, password);

        // Step 11: Go to Cart page again
        homePage.openCartPage();

        // Step 12: Verify products are still in cart after login
        Assert.assertTrue(cartPage.areProductsInCart(), "Products not found in cart after login");
    }
}
