package Automation_Exercise.Final_Project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePage extends PageBase{

	public UserHomePage(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement loggedInAsMsg;
    
    @FindBy (xpath = "//a[contains(text(), 'Delete Account')]")
    public WebElement DeleteAccBtn;

    
    public void DeleteAccount() {
    
    	wait.until(ExpectedConditions.elementToBeClickable(DeleteAccBtn));
    	DeleteAccBtn.click();
    	
    	
    }
    
}
