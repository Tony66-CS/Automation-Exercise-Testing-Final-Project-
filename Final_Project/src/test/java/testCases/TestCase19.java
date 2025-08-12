package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase19 extends TestBase{
	@Test
    public void verifyBrandProductsNavigation() {

        HomePage homePage = new HomePage(driver);
        ProductPage productsPage = new ProductPage(driver);

        // Step 3: Click on 'Products'
        homePage.openProductPage();

        // Step 4: Verify Brands are visible with better error handling
        // Add debug information to help troubleshoot
        productsPage.printBrandDebugInfo();
        
        Assert.assertTrue(productsPage.isBrandsSectionVisible(), 
            "Brands section should be visible on the products page");

        // Step 5: Click on first brand
        productsPage.clickBrand1();

        // Step 6: Verify navigation and products
        Assert.assertTrue(productsPage.Brand1Msg.isDisplayed(), 
            "Brand 1 products should be displayed after clicking first brand");
        		
        // Step 7: Click another brand
        productsPage.clickBrand2();

        // Step 8: Verify navigation and products for second brand
        Assert.assertTrue(productsPage.Brand2Msg.isDisplayed(), 
            "Brand 2 products should be displayed after clicking second brand");

	
	}
}
