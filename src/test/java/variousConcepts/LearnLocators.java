package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LearnLocators {

WebDriver driver;

//		Element List - By type
//		By USER_NAME_FIELD =By.xpath("//input[@id='user_name']");
//		By PASSWORD_FIELD =By.xpath("//*[@id='password\"]");
//		By SIGNIN_BUTTON_FIELD =By.xpath("//*[@id=\"login_submit\"]");
		By DASHBOARD_VALIDATION_FIELD =By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");
	
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver1\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testLogin() {


		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id='login_submit']"));
		
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123a");
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_VALIDATION_FIELD));

		boolean pageTitleDisplayStatus;
		try {
					
			WebElement DASHBOARD_VALIDATION_ELEMENT = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
			pageTitleDisplayStatus = true;
			
		}catch(Exception e) {
			
			pageTitleDisplayStatus = false;
			e.getStackTrace(); 
			
		}
				
		Assert.assertTrue("Dashboard Page Not Found!!!", pageTitleDisplayStatus);

//		Assert.assertTrue("Dashboard Page Not Found!!!", (DASHBOARD_VALIDATION_ELEMENT).isDisplayed());
//		Assert.assertTrue("Dashboard Page Not Found!!!",driver.findElement(DASHBOARD_VALIDATION_FIELD).isDisplayed());
//		


		
		
		
		
	}
	
	

	
}
