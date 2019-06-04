package TestLuncher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import page.Homepage;

public class Launcher {

	public static  Properties p;
	
	public  WebDriver driver;
	public Homepage objHomepage;

	public String pagename;

	@Test
	public void demo() throws Throwable {
		
		File dest=null;
		try {
			FileReader reader = new FileReader(System.getProperty("user.dir") + "\\config\\config.properties");
			p = new Properties();
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String browsername = p.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\BDDD\\Driver\\chromedriver.exe");
			 driver = new ChromeDriver(options);
			
		} else if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\Workspace\\BDDD\\Driver\\IEDriverServer.exe");

			 driver = new InternetExplorerDriver();
		}	
		
		
		String url=p.getProperty("applicationurl");
		driver.get(url);
		driver.manage().window().maximize();
		Homepage objHomepage =new Homepage(driver,pagename);
		objHomepage.Home();
   		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		String returnDate = formatter.format(date);
		dest = new File("D:\\Execution report\\ExecutionResultsSummary" + returnDate);
		dest.mkdirs();
		Date ExecutionWatch= new Date();
		System.out.println( " Execution Endeded at time  :-"+ ExecutionWatch);
		
		System.out.println("ExecutionResultSummary Report generated at path " +dest);
		}
	

	}
	



