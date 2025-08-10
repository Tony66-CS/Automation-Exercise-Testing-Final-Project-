package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends PageBase{

	public AccountCreatedPage(WebDriver driver) {super(driver);}
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement accountCreatedMessage;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div")
    WebElement continueButton;
    
    public void clickContinue() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
    


}
