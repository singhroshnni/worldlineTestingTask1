package Assessment.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {
	
	WebDriver driver;
	
	
	@BeforeMethod()
	@Parameters("browser")
	// Test to select Browser
	public void selectBrower(String browser) {

		// if browser is Chrome
		if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) { // if browser is Firefox
            System.setProperty("webdriver.gecko.driver", "D:\\\\geckodriver-v0.34.0-win64\\\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("Unsupported browser. Please choose 'chrome' or 'firefox'.");
            System.exit(0);
        }
		
		driver.get("https://www.coursera.org/");
		
		
	}
	
	
	@Test(priority=0)
	// Test to maximize window
	public void maxScreen() {
		
		driver.manage().window().maximize();
		driver.quit();
		
	}
	@Test(priority=1)
	
	public void testSearch() throws InterruptedException {
		
		driver.manage().window().maximize();
		//Finding search box using xpath
		WebElement ser=driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
		
		
        String xpath = "//input[@placeholder='What do you want to learn?']";
        String className = ser.getAttribute("class"); // getting class 
        String cssValue = ser.getCssValue("background-color"); // getting background-color
        String cssValueFont = ser.getCssValue("font-fammily"); // getting font-family
        String cssValsiz = ser.getCssValue("font-size"); // getting font-size
        String cssValcol = ser.getCssValue("color"); //getting color
        String cssValmar = ser.getCssValue("margin"); // getting margin value
        String id = ser.getAttribute("id"); // getting id (this attribute is not available for searchbox)
        String name = ser.getAttribute("name"); //getting name (this attribute is not available for searchbox)
        

        // Print attributes
        System.out.println("Search Box Attributes:");
       
        System.out.println("XPath: " + xpath);
        System.out.println("Class Name: " + className);
        System.out.println("CSS Value: " + cssValue);
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Font-Family: " + cssValueFont);
        System.out.println("Font-size: " + cssValsiz);
        System.out.println("Font-color: " + cssValcol);
        System.out.println("Margin: " + cssValmar);
        
        //Seraching selenium courses in searchbox
        ser.sendKeys("Selenium");
		WebElement btn = driver.findElement(By.xpath("//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']"));
		btn.click();
		Thread.sleep(1000);
		
        
        driver.quit();
		
		

	}
	
	@Test(priority=2)
	// Test for checking link path and partial path
	public void testLink() throws InterruptedException {
		
//	
//		
		driver.manage().window().maximize();
		
		//finding link tag using link text
		WebElement loginLink = driver.findElement(By.linkText("Log In"));
        String linkText = loginLink.getText();
        String partialLinkText = loginLink.getAttribute("href");

        //printing attributes
        System.out.println("\nLog In Link Attributes:");
        System.out.println("Link Text: " + linkText);
        System.out.println("Partial Link Text: " + partialLinkText);
        

        
        driver.quit();
	}
	
	@Test(priority=3)
	public void testLinkAttributes() throws InterruptedException {
		
		
		driver.manage().window().maximize();
		//Finding link using xpath
		WebElement logLink = driver.findElement(By.xpath("//a[normalize-space()='Log In']"));
        logLink.click();
        Thread.sleep(1000);
		
        //finding attributes like id and name for username and password input box after clicking login
        WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement sub = driver.findElement(By.xpath("//button[@type='submit']"));
        
        String id=uname.getAttribute("id");
        String name=uname.getAttribute("name");
        
        String idp=pass.getAttribute("id");
        String namep=pass.getAttribute("name");
        String xpath="//a[normalize-space()='Log In']";
        
        
        //Printing attributes
        System.out.println("Log-in Link Attributes:");
        
        System.out.println("XPath: " + xpath);
        System.out.println("Id of Username: " + id);
        System.out.println("Name of username: " + name);
        System.out.println("ID of password: " + idp);
        System.out.println("Name of password: " + namep);
    
        uname.sendKeys("username");
        pass.sendKeys("password");
        
        
        sub.click();
        Thread.sleep(10000);
        

     // Find the error message element using XPath selector
     WebElement errorMessageElement = driver.findElement(By.xpath("//div[@role='alert']//div//span"));

     // Extract the text of the error message
     String errorMessage = errorMessageElement.getText();

     // Define the expected error message
     String expectedErrorMessage = "We don't recognize that username or password. You can try again or reset your password";

     // Use Assert.assertEquals to compare the expected and actual error message
     Assert.assertEquals(errorMessage, expectedErrorMessage, "Error message is not as expected");

        
        driver.quit();
        
		
	}
}
