package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestCase9 extends TestBase{
	@Test
	public void searchProductAndVerifyResults() {
	    HomePage homePage = new HomePage(driver);

	    // Step 3: Verify home page is visible successfully
	    Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

	    // Step 4: Click on 'Products' button
	    homePage.openProductPage();

	    // Step 5: Verify ALL PRODUCTS page is visible
	    ProductPage productsPage = new ProductPage(driver);
	    productsPage.waitForAllProducts();
	    Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());

	    // Step 6: Enter product name in search input and click search
	    String searchKeyword = "Dress";
	    productsPage.enterSearchKeyword(searchKeyword);
	    productsPage.clickSearchButton();

	    // Step 7: Verify 'SEARCHED PRODUCTS' is visible
	    Assert.assertTrue(productsPage.searchedProductsTitle.isDisplayed());

	    // Step 8: Verify all search results are related to the keyword
	    for (WebElement product : productsPage.searchedProductsList) {
	        Assert.assertTrue(product.getText().toLowerCase().contains(searchKeyword.toLowerCase()));
	    }
	}
}
