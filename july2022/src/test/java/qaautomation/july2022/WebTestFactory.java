package qaautomation.july2022;


//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.july2022.pages.LoginPage;
import qaautomation.july2022.pages.ProfilePage;

public class WebTestFactory extends BaseWebTest {
	
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	String wrongUsername = "tom";
	String wrongPassword = "aaaa";
	
	@Test
	public void testLogin() {
		
		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		String actualText = profilePage.getProfileText();
		String expectedText = "You";
		String expectedText2 = "logged";
		String expectedText3 = "secure";
		
		Assert.assertTrue(actualText.contains(expectedText));
		Assert.assertTrue(actualText.contains(expectedText2));
		Assert.assertTrue(actualText.contains(expectedText3));
		
	}
	
	@Test
	public void testLoginNew() {
		
		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
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
		loginPage.inputUsername(wrongUsername);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginWrongPassword() {
		
		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.inputUsername(username);
		loginPage.inputPassword(wrongPassword);
		loginPage.clickLoginButton();
		String actualText = profilePage.getProfileText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginWrongUsernameAndPassword() {
		
		driver.get().get("http://the-internet.herokuapp.com/login");
		loginPage.inputUsername(wrongUsername);
		loginPage.inputPassword(wrongPassword);
		loginPage.clickLoginButton();
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
