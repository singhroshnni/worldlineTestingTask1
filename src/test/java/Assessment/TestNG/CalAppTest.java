package Assessment.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalAppTest {
	
	WebDriver driver;
	
	@Test(enabled=false)
	@Parameters({"a","b"})
	public void testAdd(String sa, String sb) {
		CalculatorApp app = new CalculatorApp();
		int a=Integer.parseInt(sa);
		int b=Integer.parseInt(sb);
		int ans =app.addFun(a,b);
		int expected =a+b;
		
		Assert.assertEquals(ans,expected);
	}
	
	@Test(enabled=false)
	public void testSub(){
		CalculatorApp app = new CalculatorApp();
		int ans =app.subFun(15,10);
		int expected =5;
		
		Assert.assertEquals(ans,expected);
	}
	
	@Test(enabled=false)
	public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement p=driver.findElement(By.name("q"));
        p.sendKeys("VIT");
        p.submit();
    }
	
	@Test
	public void loginCheck(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement uname = driver.findElement(By.name("user-name"));
        WebElement pw = driver.findElement(By.name("password"));
        WebElement log =driver.findElement(By.name("login-button"));
        uname.sendKeys("standard_user");
        pw.sendKeys("secret_sauce");
        log.click();
        String expect="https://www.saucedemo.com/inventory.html";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(expect, actual);
        
        
	}

}
