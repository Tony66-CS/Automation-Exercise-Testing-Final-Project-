package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @FindBy(linkText = "Signup / Login")
    public WebElement loginLink;

    @FindBy(linkText = "Home")
    public WebElement homeLink;

    @FindBy(xpath = "//h2[text()='Features Items']")
    public WebElement featuresItemsHeader; 
    
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement testCasesBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	private WebElement productsBtn;

	@FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
	public WebElement Subscription;
	
	@FindBy(xpath = "//*[@id=\"susbscribe_email\"]")
	private WebElement SubscriptionEmailField;
	
	@FindBy(id = "subscribe")
	private WebElement SubscribeBtn;
	
	@FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
	public WebElement SubscribtionMsg;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	private WebElement cartBtn;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
	private WebElement VuewProduct1;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/h2")
	public WebElement CategoryLabel;
	
	@FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")
	private WebElement WomenSelect;
	
	@FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")
	private WebElement MenSelect;
	
	@FindBy(xpath = "//*[@id='Women']/div/ul/li[1]/a")
	private WebElement TopsSelect;
	
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
	public WebElement TopsMsg;
	
	@FindBy(xpath = "//*[@id='Men']/div/ul/li[1]/a")
	private WebElement TShirtSelection;
	
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
	public WebElement TShirtsMsg;
	
	
	
	public void clickFirstViewProduct() {
		wait.until(ExpectedConditions.visibilityOf(VuewProduct1));
		VuewProduct1.click();
	}
	public void sendSubscribtionEmail(String Email) {
		
		wait.until(ExpectedConditions.visibilityOf(SubscriptionEmailField));
	    SubscriptionEmailField.clear();
	    SubscriptionEmailField.sendKeys(Email);
	    SubscribeBtn.click();
		
	}
	
	public void openTestCasesPage() {
	    wait.until(ExpectedConditions.elementToBeClickable(testCasesBtn));
	    testCasesBtn.click();
	}
    
	public void openProductPage() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(productsBtn));
    	productsBtn.click();
    }
	
    public void openLoginPage() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }

    public void openHomePage() {
    	wait.until(ExpectedConditions.elementToBeClickable(homeLink));
        homeLink.click();
    }
    
    public void openCartPage() {
    	wait.until(ExpectedConditions.elementToBeClickable(homeLink));
    	cartBtn.click();
    }
    
    public void openWomenCategoryAndClickTops() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='accordian']/div[1]/div[1]/h4/a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WomenSelect);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", WomenSelect);

        WebElement dressLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='Women']/div/ul/li[2]/a"))); // adjust index for "Dress"
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dressLink);
    }
    
    public void openMenCategoryAndClickTShirts() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='accordian']/div[2]/div[1]/h4/a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", MenSelect);
        //Thread.sleep(500); // tiny pause for animation
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MenSelect);

        WebElement tshirtLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='Men']/div/ul/li[1]/a")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", tshirtLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tshirtLink);
    }

	
}
