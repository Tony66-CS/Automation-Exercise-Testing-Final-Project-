package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDeletedPage extends PageBase{

	public AccountDeletedPage(WebDriver driver) {
		super(driver);
	}

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	

    @FindBy (xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement AccDeletedMsg;
  
    @FindBy (xpath = "//*[@id=\"form\"]/div/div/div/div")
    WebElement ContinueBtn;
    
    public void ClickContinue() {
    	wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn));
    	this.ContinueBtn.click();
    }
    
}
