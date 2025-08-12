package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {super(driver);}

	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	// Address details section
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[2]/h2")
    private WebElement addressDetailsSection;

    // Review your order section
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[4]/h2")
    private WebElement reviewOrderSection;

    // Comment text area
    @FindBy(name = "message")
    private WebElement commentTextArea;

    // Place Order button
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    private WebElement placeOrderBtn;

    // Payment fields
    @FindBy(name = "name_on_card")
    private WebElement nameOnCardInput;

    @FindBy(name = "card_number")
    private WebElement cardNumberInput;

    @FindBy(name = "cvc")
    private WebElement cvcInput;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonthInput;

    @FindBy(name = "expiry_year")
    private WebElement expiryYearInput;

    @FindBy(id = "submit")
    private WebElement payAndConfirmBtn;

    // Success message after placing order
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement orderSuccessMsg;

    
    public boolean isAddressDetailsVisible() {
        return addressDetailsSection.isDisplayed();
    }

    public boolean isReviewOrderVisible() {
        return reviewOrderSection.isDisplayed();
    }

    public void enterComment(String comment) {
        commentTextArea.clear();
        commentTextArea.sendKeys(comment);
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void enterPaymentDetails(String name, String cardNumber, String cvc, String month, String year) {
        nameOnCardInput.sendKeys(name);
        cardNumberInput.sendKeys(cardNumber);
        cvcInput.sendKeys(cvc);
        expiryMonthInput.sendKeys(month);
        expiryYearInput.sendKeys(year);
    }

    public void clickPayAndConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(payAndConfirmBtn)).click();
    }

    public boolean isOrderSuccessMessageVisible() {
        return orderSuccessMsg.isDisplayed();
    }
    
}
