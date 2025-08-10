package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {super(driver);}

	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @FindBy(id = "id_gender1")
    WebElement mrTitle;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "days")
    WebElement dayDropdown;

    @FindBy(id = "months")
    WebElement monthDropdown;

    @FindBy(id = "years")
    WebElement yearDropdown;

    // Newsletter and Offers
    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement offersCheckbox;

    // Address Info
    @FindBy(id = "first_name")
    WebElement firstNameField;

    @FindBy(id = "last_name")
    WebElement lastNameField;

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(id = "address1")
    WebElement address1Field;

    @FindBy(id = "address2")
    WebElement address2Field;

    @FindBy(id = "country")
    WebElement countryDropdown;

    @FindBy(id = "state")
    WebElement stateField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "zipcode")
    WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    WebElement mobileField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    WebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    public WebElement AlreadyRegisterMsg;
    
	@FindBy(name = "name")
    WebElement nameField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement emailField;

    
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    WebElement signupButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
    public WebElement enterAccountInfoMessage;
    
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    public WebElement newUserSignupMsg;
    
    
    	
    public void startSignup(String name, String email) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        
    	wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        signupButton.click();
    }

    
    public void fillAccountDetails(String password, String day, String month, String year,
                                    String firstName, String lastName, String company,
                                    String address1, String address2, String country,
                                    String state, String city, String zip, String mobile) {
    	
    	
    	wait.until(ExpectedConditions.elementToBeClickable(mrTitle));
        mrTitle.click();
        passwordField.sendKeys(password);
        dayDropdown.sendKeys(day);
        monthDropdown.sendKeys(month);
        yearDropdown.sendKeys(year);

        
    	wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox));
        newsletterCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(offersCheckbox));
        offersCheckbox.click();

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        companyField.sendKeys(company);
        address1Field.sendKeys(address1);
        address2Field.sendKeys(address2);
        countryDropdown.sendKeys(country);
        stateField.sendKeys(state);
        cityField.sendKeys(city);
        zipcodeField.sendKeys(zip);
        mobileField.sendKeys(mobile);

        
    	wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    
}


