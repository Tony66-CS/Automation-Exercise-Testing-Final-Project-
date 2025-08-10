package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase6 {
	WebDriver driver = new ChromeDriver();
	String smallTXTFile = "/Users/antoinemageud/Documents/GitHub/Automation-Exercise-Testing-Final-Project-/Final_Project/src/test/java/data/TextFile.txt";
	String baseURL = "https://automationexercise.com/contact_us";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

 
  @BeforeTest
  public void beforeTest() {
	
	 //1. Navigate to the Contact Us page
 
	  driver.navigate().to(baseURL);
	  driver.manage().window().maximize();

	  
  }

  
	@Test
  public void TestContactUs() throws InterruptedException {
		
		//2.Verify that the "GET IN TOUCH" header is displayed.
		
		WebElement ContactUS = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[1]/div/div/h2"));
		
		Assert.assertTrue(ContactUS.isDisplayed());
		
		//3.Fill out the contact form with valid test data
		
		WebElement Name = driver.findElement(By.name("name"));		   
		Name.sendKeys("Antwan Fares");
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("antoinemageud@icloud.com");
        WebElement Sub = driver.findElement(By.name("subject"));
        Sub.sendKeys("Concern about a TestCase");
        WebElement Msg = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        Msg.sendKeys("Hi this Tony!");
        		   
        //4. Upload a file (any small .TXT file or image from your local system).
     
        try {
            WebElement UploadFile = wait.until(ExpectedConditions.elementToBeClickable(By.name("upload_file")));
            UploadFile.sendKeys(smallTXTFile);
            
        } catch (Exception e) {
        	System.err.println("File upload failed during test execution!");
            System.err.println("Exception: " + e.getMessage());
            throw e;
        }

        //5. Click the 'Submit' button.
        
        WebElement SubmitBtn = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
        SubmitBtn.click();
        
        //6. Handle the alert (Click OK on the JavaScript alert PoPup).
        
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //7. Verify that the success message "Success! Your details have been submitted successfully." is displayed.
        
        WebElement SuccessMsg = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		Assert.assertTrue(SuccessMsg.isDisplayed());
		
		//8. Click the 'Home' button and verify that the user is navigated back to the home page (https://automationexercise.com).
		
        WebElement HomeBtn = driver.findElement(By.xpath("//*[@id=\"form-section\"]/a"));
        HomeBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        

	}
 
  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  
  }


}
