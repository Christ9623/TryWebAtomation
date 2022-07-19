package qaautomation.july2022.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage extends BasePage {
	
	public CommonPage (ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void openUrl(String url) {
		driver.get().get(url);		
	}

	public void openNewTab() {
		driver.get().switchTo().newWindow(WindowType.TAB);		
	}
	
	public void openNewWindow() {
		driver.get().switchTo().newWindow(WindowType.WINDOW);		
	}
	
	public void switchWindow() {
		driver.get().switchTo().newWindow(WindowType.WINDOW);		
	}
}
