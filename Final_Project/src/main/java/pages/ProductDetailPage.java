package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBase{



    public ProductDetailPage(WebDriver driver) {super(driver);}

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
    
}
