package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class PageTest {

	protected static WebDriver driver;

	@BeforeSuite
	public static void beforeSuite() {
		System.out.println("Inside BeforeSuite Method.");
		killDriverInstance();
	}

	@Parameters({ "browserName", "url" })
	@BeforeMethod
	public void beforeMethod(String browserName, String url) {
		System.out.println("Inside beforeMethod method.");
		System.out.println("Browser Name:" + browserName);
		switch (browserName) {
		case "Chrome":
			initChrome(url);
			break;
		case "Firefox":
			initFirefox(url);
			break;
		case "IE":
			initIE(url);
			break;
		default:
			System.out.println("Invalid Broswer Name.");
		}
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside AfterMethod");
	}

	@AfterSuite
	public static void afterSuite() {
		System.out.println("Inside afterSuite Method.");
		killDriverInstance();
	}

	public static void killDriverInstance() {
		try {
			String basePath = System.getProperty("user.dir");
			String finalPath = basePath + "\\src\\utils\\killDriver.bat";
			Process process = Runtime.getRuntime().exec(finalPath);
			process.waitFor();
		} catch (Exception ex) {
			System.out.println("Exception in killDriverInstance method:" + ex.toString());
		}
	}

	public static void initChrome(String url) {
		String basePath = System.getProperty("user.dir");
		System.out.println("Base Path:" + basePath);
		String finalPath = basePath + "//servers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", finalPath);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(url);
	}

	public static void initFirefox(String url) {

	}

	public static void initIE(String url) {

	}
}
