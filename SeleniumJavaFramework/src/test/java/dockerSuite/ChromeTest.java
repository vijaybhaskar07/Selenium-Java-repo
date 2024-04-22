package dockerSuite;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest {
	
	@Test
	public void chromeTest( )throws MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
		URL url = new URL("http://192.168.0.108:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, options);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());       
        driver.quit();
	}

}
