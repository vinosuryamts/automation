package launchbrowser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class LaunchBrowser {
	
		public static WebDriver driver = null;
		
		public static void openingBrowser(WebDriver webdriver,String browsername) {
			
			driver = webdriver;
			
			switch(browsername){
				
				case "Internet Explorer":
						System.setProperty("webdriver.ie.driver",".\\driver\\IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						driver.manage().window().maximize();
						break;
					
					case "Mozilla Firefox":
						System.setProperty("webdriver.firefox.marionette",".\\driver\\geckodriver.exe");
						driver = new FirefoxDriver();
						driver.manage().window().maximize();
						break;
					
					case "Chrome":
						System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						break;
						
					case "Opera":
						System.setProperty("webdriver.opera.driver", ".\\driver\\operadriver.exe");
						OperaOptions options = new OperaOptions();
				        options.setBinary("C:\\Users\\FALMS\\AppData\\Local\\Programs\\Opera\\64.0.3417.61_0\\opera.exe");
						driver = new OperaDriver(options);
						driver.manage().window().maximize();
						break;
						
					default:
						System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						break;
						
			}

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			System.out.println("Opening browser "+browsername); 
			
		}
		
		public static void implicitWait(WebDriver driverval,int seconds,TimeUnit time) {
			System.out.println("Time Wait " + seconds + " "+ time);
			driver = driverval;
			driver.manage().timeouts().implicitlyWait(seconds, time);
			
		}
		
		public static void closedriver(WebDriver driverval) {
			driver = driverval;
			driver.close();
			
			try {
				Runtime.getRuntime().exec("taskkill /f /im opera.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Closed Browser");
		}
		
		public static void navigateto(WebDriver driverval,String urlval) {
			driver = driverval;
			driver.get(urlval);
		}
}
