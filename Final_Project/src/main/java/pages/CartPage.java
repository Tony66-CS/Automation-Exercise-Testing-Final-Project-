package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//table[@id='cart_info_table']//tr")
    public List<WebElement> cartRows;

    @FindBy(xpath = "//table[@id='cart_info_table']//td[@class='cart_price']/p")
    public List<WebElement> productPrices;

    @FindBy(xpath = "//table[@id='cart_info_table']//td[@class='cart_quantity']/button")
    public List<WebElement> productQuantities;

    @FindBy(xpath = "//table[@id='cart_info_table']//td[@class='cart_total']/p")
    public List<WebElement> productTotals;

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")
    public WebElement cartTitle;

    @FindBy(xpath = "//table[@id='cart_info_table']//td[@class='cart_description']/h4/a")
    public List<WebElement> productNames;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")
    public WebElement viewCartBtn;
    
    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    private WebElement proceedToCheckout;
    
    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement RegisterBtn;
    
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a")
    private List<WebElement> DeleteItemBtn;
    
    @FindBy(xpath = "//*[@id=\"empty_cart\"]/p")
    public WebElement CartisEmpty;
    
    @FindBy(xpath = "//table[@id='cart_info_table']//tr")
    public List<WebElement> cartItems;
    
    
    
    public boolean isProductInCart(String productName) {
        for (WebElement row : cartRows) {
            if (row.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public String getProductPrice(int index) {
        return productPrices.get(index).getText().trim();
    }

    public String getProductQuantity(int index) {
        return productQuantities.get(index).getText().trim();
    }

    public String getProductTotal(int index) {
        return productTotals.get(index).getText().trim();
    }

    public String getProductName(int index) {
        return productNames.get(index).getText().trim();
    }

    public void waitForCartPage() {
		wait.until(ExpectedConditions.visibilityOf(cartTitle));
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }
    public int getProductCount() {
    	return cartRows.size() - 1;
    }
    
    public void clickproceed() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();

    }
    
    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(RegisterBtn)).click();

    }
    
    public int getProductCounttobeDeleted() {
        return DeleteItemBtn.size();
    }

    public void removeProduct(int index) {
    	DeleteItemBtn.get(index).click();
    }
    
    public void waitForEmptyCart() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(CartisEmpty));
    }
    
    public boolean areProductsInCart() {
        return cartItems.size() > 0 && cartItems.stream().allMatch(WebElement::isDisplayed);
    }
    
    public boolean isProductInCartt(String productName) {
    	 // Wait until at least one product row is loaded
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.cssSelector("table.table tbody tr")
        ));

        // Get all product rows and check if any contains the given name
        return driver.findElements(By.cssSelector("table.table tbody tr"))
                     .stream()
                     .anyMatch(row -> row.getText().toLowerCase().contains(productName.toLowerCase()));

    }
}