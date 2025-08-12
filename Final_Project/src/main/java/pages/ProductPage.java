package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductPage extends PageBase {

    public ProductPage(WebDriver driver) {super(driver);}

    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    
	@FindBy(xpath = "//h2[contains(text(),'All Products')]")
    public WebElement allProductsTitle;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='product-image-wrapper']")
    public List<WebElement> productsList;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    public WebElement firstProductViewLink;


    @FindBy(id = "search_product")
    WebElement searchInput;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    public WebElement searchedProductsTitle;
    
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
    private WebElement AddtoCart1;
    
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")
    private WebElement AddtoCart2;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    public WebElement viewCartBtn;

    @FindBy(css = ".add-to-cart")
    private List<WebElement> addToCartButtons;
    
    @FindBy(xpath = "//h2[contains(text(),'Brands') or contains(text(),'brands')]")
    public WebElement BrandLabel;

    @FindBy(css = "div.brands_products ul li a")
    private List<WebElement> brandLinks;
    
    @FindBy(xpath = "//div[@class='brands_products']//ul//li[1]/a")
    private WebElement Brand1;
    
    @FindBy(xpath = "//div[@class='brands_products']//ul//li[2]/a")
    private WebElement Brand2;
    
    // Brand message elements - these will be dynamic based on which brand is selected
    @FindBy(xpath = "//div[@class='features_items']//h2")
    public WebElement Brand1Msg;
    
    @FindBy(xpath = "//div[@class='features_items']//h2")
    public WebElement Brand2Msg;
    
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    public WebElement AllproductsMsg;
    
    @FindBy(css = ".productinfo.text-center")
    private List<WebElement> productList;

    //ttt
    

    @FindBy(xpath = "//*[@id='name']")
    private WebElement reviewNameInput;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement reviewEmailInput;

    @FindBy(xpath = "textarea#review")
    private WebElement reviewTextArea;

    @FindBy(id = "button-review")
    private WebElement submitReviewButton;

    @FindBy(xpath = "//*[contains(text(),'Thank you for your review.')]")
    private WebElement reviewSuccessMessage;

    public boolean isWriteReviewVisible() {
        return reviewNameInput.isDisplayed() && reviewEmailInput.isDisplayed() && reviewTextArea.isDisplayed();
    }

    public void enterReviewDetails(String name, String email, String review) {
        wait.until(ExpectedConditions.visibilityOf(reviewNameInput)).sendKeys(name);
        reviewEmailInput.sendKeys(email);
        reviewTextArea.sendKeys(review);
    }

    public void clickSubmitReview() {
        wait.until(ExpectedConditions.elementToBeClickable(submitReviewButton)).click();
    }

    public boolean isReviewSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(reviewSuccessMessage)).isDisplayed();
    }
    
    //ttt
    public void hoverAndAddToCart(int productIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = productsList.get(productIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        wait.until(ExpectedConditions.elementToBeClickable(AddtoCart1));
        AddtoCart1.click();
        
    }

    public void hoverAndAddToCart2(int productIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = productsList.get(productIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        wait.until(ExpectedConditions.elementToBeClickable(AddtoCart2));
        AddtoCart2.click();
        
    }
    
    
    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        continueShoppingBtn.click();
    }

    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
        viewCartBtn.click();
    }
    
    

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div")
    public List<WebElement> searchedProductsList;

    public void waitForAllProductss() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(allProductsTitle));
    }

    public void enterSearchKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
    
    public void waitForAllProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(allProductsTitle));
    }

    public void clickFirstProductView() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProductViewLink));
        firstProductViewLink.click();
    }
    
    public void clickBrand1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until brand list is visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(Brand1));
        
        // Scroll and click with JS for better reliability
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Brand1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Brand1);
    }

    public void clickBrand2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until brand list is visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(Brand2));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Brand2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Brand2);
    }
    
    // Alternative method to click any brand by index
    public void clickBrandByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        if (index >= 0 && index < brandLinks.size()) {
            WebElement brandElement = brandLinks.get(index);
            wait.until(ExpectedConditions.elementToBeClickable(brandElement));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", brandElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandElement);
        } else {
            throw new IllegalArgumentException("Brand index " + index + " is out of range. Available brands: " + brandLinks.size());
        }
    }
    
    // Method to get the number of available brands
    public int getBrandCount() {
        return brandLinks.size();
    }
    
    // Method to check if brands section is visible
    public boolean isBrandsSectionVisible() {
        try {
            return BrandLabel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean areAllSearchResultsVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        return productList.stream().allMatch(WebElement::isDisplayed);
    }
    
    public void addAllSearchResultsToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement product : addToCartButtons) {
            js.executeScript("arguments[0].scrollIntoView(true);", product);
            js.executeScript("arguments[0].click();", product);
            wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
        }
    }
    
    public void printBrandDebugInfo() {
        System.out.println("=== Brand Debug Information ===");
        System.out.println("BrandLabel found: " + (BrandLabel != null));
        if (BrandLabel != null) {
            try {
                System.out.println("BrandLabel text: " + BrandLabel.getText());
                System.out.println("BrandLabel displayed: " + BrandLabel.isDisplayed());
            } catch (Exception e) {
                System.out.println("Error getting BrandLabel info: " + e.getMessage());
            }
        }
        
        System.out.println("Brand links count: " + brandLinks.size());
        for (int i = 0; i < brandLinks.size(); i++) {
            try {
                WebElement brand = brandLinks.get(i);
                System.out.println("Brand " + (i + 1) + ": " + brand.getText() + " (href: " + brand.getAttribute("href") + ")");
            } catch (Exception e) {
                System.out.println("Error getting brand " + (i + 1) + " info: " + e.getMessage());
            }
        }
    }
    
}