package qaautomation.july2022;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTestAfterRefactor extends BaseWebTest {	
	
	@Test
	public void testLogin() {
		
		String username = "tomsmith";
		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You";
		String expectedText2 = "logged";
		String expectedText3 = "secure";
		
		Assert.assertTrue(actualText.contains(expectedText));
		Assert.assertTrue(actualText.contains(expectedText2));
		Assert.assertTrue(actualText.contains(expectedText3));
		
	}
	
	@Test
	public void testLoginWrongUsername() {
		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.id("username")).sendKeys("tomsmithzzz");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginWrongPassword() {
		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("passwordsalah!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginWrongUsernameAndPassword() {
		driver.get().get("http://the-internet.herokuapp.com/login");
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmithzzz");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretzzzPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
