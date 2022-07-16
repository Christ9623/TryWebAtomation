package qaautomation.july2022;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTestAfterRefactor extends BaseWebTest{		
	
	@Test
	public void testLogin() {
				
		//driver.get("https://google.com");
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
				
	}
	
	@Test
	public void testLoginWrongUsername() {
		
		//driver.get("https://google.com");
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
		
	}
	
	@Test
	public void testLoginWrongPassword() {
		
		//driver.get("https://google.com");
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
		
		
	}
	
	@Test
	public void testLoginWrongUsernameAndPassword() {
		
		//driver.get("https://google.com");
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Tomsmi");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPasswor");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
		
	}
	
	

}
