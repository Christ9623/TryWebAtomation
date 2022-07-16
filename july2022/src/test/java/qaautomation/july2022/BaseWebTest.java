package qaautomation.july2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}