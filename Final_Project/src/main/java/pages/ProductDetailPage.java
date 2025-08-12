package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends PageBase{



    public ProductDetailPage(WebDriver driver) {super(driver);}
    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    public WebElement productName;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    public WebElement category;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
    public WebElement price;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    public WebElement availability;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    public WebElement condition;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    public WebElement brand;
    
    @FindBy(xpath = "//*[@id=\"quantity\"]")
    private WebElement quantityInput;
    
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    private WebElement addtoCartBtn;
    
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement viewCartLink;
    
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a")
    public WebElement reviewMsg;

//new
    
    @FindBy(xpath = "//*[@id='name']")
    private WebElement reviewNameInput;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement reviewEmailInput;

    @FindBy(xpath = "//*[@id=\"review\"]")
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
    
    //mxm
    
    public void setProductQuantity(String qty) {
        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }

    public void clickAddToCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(addtoCartBtn));
    	addtoCartBtn.click();
    }

    public void clickViewCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        viewCartLink.click();
    }
    
}

