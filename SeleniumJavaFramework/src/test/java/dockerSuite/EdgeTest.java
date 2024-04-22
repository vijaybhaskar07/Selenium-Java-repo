package dockerSuite;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class EdgeTest {
	
	@Test
	public void fireFoxTest( )throws MalformedURLException {
		
		EdgeOptions options = new EdgeOptions();
		URL url = new URL("http://192.168.0.108:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, options);
		driver.navigate().to("https://www.facebook.com/");
		System.out.println(driver.getTitle());       
        driver.quit();
	}

}
