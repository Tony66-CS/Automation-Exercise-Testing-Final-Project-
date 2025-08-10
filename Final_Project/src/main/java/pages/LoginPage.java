package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {super(driver);}

	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
	public WebElement loginMsg;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	WebElement loginBtn;
	
	public void setEmail(String emailText) {
        email.clear();
        email.sendKeys(emailText);
    }

    public void setPassword(String passwordText) {
        password.clear();
        password.sendKeys(passwordText);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public String getLoginMessage() {
        return loginMsg.getText();
    }

    public void Login(String emailText, String passText) {
        setEmail(emailText);
        setPassword(passText);
        clickLogin();
    }
	
}
