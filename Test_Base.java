package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 	// login page  information
public class Test_Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	// properties intialization 

	public Test_Base() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\priya\\eclipse-workspace\\sathyatrail.zip_expanded\\Sathya\\config.properties");
			prop.load(ip);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//  navigate to chrome driver 
	public static void initialisation()
	{
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
	
	



}
