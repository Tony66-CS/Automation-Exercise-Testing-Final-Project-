package Automation_Exercise.Final_Project;

import java.time.Duration;

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
    
    public void openLoginPage() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }

    public void openHomePage() {
    	wait.until(ExpectedConditions.elementToBeClickable(homeLink));
        homeLink.click();
    }
	
}
