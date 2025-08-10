package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestCase8 extends TestBase{
	@Test
	public void viewFirstProductDetails() {
	    HomePage homePage = new HomePage(driver);

	    // Step 3: Verify home page is visible
	    Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

	    // Step 4: Click 'Products' button
	    homePage.openProductPage();

	    // Step 5: Verify ALL PRODUCTS page is visible
	    ProductPage productsPage = new ProductPage(driver);
	    productsPage.waitForAllProducts();
	    Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());

	    // Step 6: Verify products list is visible
	    Assert.assertTrue(productsPage.productsList.size() > 0);

	    // Step 7: Click on 'View Product' of first product
	    productsPage.clickFirstProductView();

	    // Step 8 & 9: Verify product detail info is visible
	    ProductDetailPage detailPage = new ProductDetailPage(driver);
	    Assert.assertTrue(detailPage.productName.isDisplayed());
	    Assert.assertTrue(detailPage.category.isDisplayed());
	    Assert.assertTrue(detailPage.price.isDisplayed());
	    Assert.assertTrue(detailPage.availability.isDisplayed());
	    Assert.assertTrue(detailPage.condition.isDisplayed());
	    Assert.assertTrue(detailPage.brand.isDisplayed());
	}
}
