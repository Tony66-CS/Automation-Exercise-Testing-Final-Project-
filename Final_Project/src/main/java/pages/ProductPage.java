package pages;

import org.openqa.selenium.By;
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
}