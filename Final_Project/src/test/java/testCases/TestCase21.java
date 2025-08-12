package testCases;

import org.testng.annotations.Test;

import pages.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestCase21 extends TestBase{
	@DataProvider(name = "reviewData")
    public Object[][] reviewData() {
        return new Object[][]{
            {"John Doe", "john@example.com", "This is a great product! Highly recommend it."}
        };
    }

    @Test(dataProvider = "reviewData")
    public void testAddReviewOnProduct(String name, String email, String review) {
        HomePage homePage = new HomePage(driver);
        ProductPage productsPage = new ProductPage(driver);
        ProductDetailPage productDetailsPage = new ProductDetailPage(driver);

        // Step 3: Click 'Products'
        homePage.openProductPage();

        // Step 4: Verify navigation to ALL PRODUCTS
        Assert.assertTrue(productsPage.AllproductsMsg.isDisplayed());

        // Step 5: Click 'View Product'
        productsPage.clickFirstProductView();

        // Step 6: Verify 'Write Your Review' is visible
        Assert.assertTrue(productDetailsPage.reviewMsg.isDisplayed());
        
        // Step 7: Enter name, email, review
        productDetailsPage.enterReviewDetails(name, email, review);

        // Step 8: Click 'Submit'
        productDetailsPage.clickSubmitReview();

        // Step 9: Verify success message
        Assert.assertTrue(productDetailsPage.isReviewSuccessMessageDisplayed());
    }
}
